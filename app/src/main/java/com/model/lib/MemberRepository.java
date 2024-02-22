package com.model.lib;

import com.model.Member;
import com.model.db.DataHandler;
import com.model.db.HardCodedData;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The stuff lending system.
 */
public final class MemberRepository implements MemberRepositories {
  private final DataHandler dataHandler;
  private final LinkedList<Member> members;
  private static final int MIN_NAME_LENGTH = 2;
  private final IdGenerator<Member> idGenerator;

  /**
   * Creates a new instance of the stuff lending system.
   */
  public MemberRepository() {
    this.dataHandler = new HardCodedData();
    this.members = new LinkedList<Member>(dataHandler.getMembers());
    this.idGenerator = new IdGenerator<Member>();
  }

  /**
   * Deep copy constructor. Creates a new instance of the stuff lending system.
   *
   * @param memberRepo - The member repository to copy.
   */
  protected MemberRepository(Iterable<Member> members) {
    this.members = createMemberList(members);
    this.dataHandler = null;
    this.idGenerator = new IdGenerator<Member>();
  }

  // ***** CRUD operations *****

  /**
   * Gets the member list.
   *
   * @return - The member list.
   */
  @Override
  public Iterable<Member> getMembers() {
    return new LinkedList<Member>(members);
  }

  /**
   * Gets a list of members sorted by name or id.
   *
   * @param asName    - True if the list should be sorted by name, false if sorted
   *                  by id.
   * @param ascending - True if the list should be sorted in ascending order,
   *                  false if not.
   * @return - A list of members sorted by name or id.
   */
  @Override
  public Iterable<Member> getMembersSortedBy(boolean asName, boolean ascending) {
    LinkedList<Member> sortedMembers = new LinkedList<Member>(members);
    if (asName) {
      if (ascending) {
        sortedMembers.sort((m1, m2) -> m1.getName().compareTo(m2.getName()));
      } else {
        sortedMembers.sort((m1, m2) -> m2.getName().compareTo(m1.getName()));
      }
    } else {
      if (ascending) {
        sortedMembers.sort((m1, m2) -> m1.getId().compareTo(m2.getId()));
      } else {
        sortedMembers.sort((m1, m2) -> m2.getId().compareTo(m1.getId()));
      }
    }

    return sortedMembers;
  }

  /**
   * Gets a member by id.
   *
   * @param id - The id of the member to get.
   * @return - The member if found, null otherwise.
   */
  @Override
  public Member getMemberById(String id) {
    for (Member member : members) {
      if (member.getId().equals(id)) {
        return new Member(member.getId(), member.getName(), member.getEmail(),
            member.getMobile(), member.getMemberCreationDay());
      }
    }

    return null;
  }

  /**
   * Adds a new member.
   *
   * @param data - The member data.
   * @return - The new member if successful or null if not.
   */
  @Override
  public Member addNewMember(BasicMemberData data) {
    if (data == null || !isValidInputData(data)) {
      return null;
    }

    // String id = generateMemberId();
    String id = idGenerator.generateId(members);

    Member newMember = new Member(id, data.getName(), data.getEmail(), data.getMobile(), data.getCreationDay());

    synchronized (this) {
      if (!validateEmail(data.getEmail()) || !validateMobile(data.getMobile()) || !validateName(data.getName())) {
        return null;
      }
      members.add(newMember);
    }

    return new Member(newMember.getId(), newMember.getName(), newMember.getEmail(),
        newMember.getMobile(), newMember.getMemberCreationDay());
  }

  /**
   * Updates a member.
   *
   * @param newMember - The new member data.
   * @param member    - The member to update.
   * @return - The updated member if successful or null if not.
   */
  @Override
  public Member updateMember(BasicMemberData newMember, Member member) {
    final String name = newMember.getName();
    final String email = newMember.getEmail();
    final String mobile = newMember.getMobile();

    if (!name.equals(member.getName())) {
      if (!validateName(name)) {
        return null;
      }
    }

    if (!email.equals(member.getEmail())) {
      if (!validateEmail(email)) {
        return null;
      }
    }

    if (!mobile.equals(member.getMobile())) {
      if (!validateMobile(mobile)) {
        return null;
      }
    }

    synchronized (this) {
      final String id = member.getId();
      final int creationDay = member.getMemberCreationDay();

      Member updatedMember = new Member(id, name, email, mobile, creationDay);

      replaceMemberInList(member, updatedMember);
      return new Member(updatedMember.getId(), updatedMember.getName(), updatedMember.getEmail(),
          updatedMember.getMobile(), updatedMember.getMemberCreationDay());
    }
  }

  /**
   * Deletes a member.
   *
   * @param member - The member to delete.
   * @return - True if the member was deleted, false otherwise.
   */
  @Override
  public boolean deleteMember(Member member) {
    for (Member m : members) {
      if (m == member || m.getId().equals(member.getId())) {
        members.remove(m);
        return true;
      }
    }

    return false;
  }

  // ***** Validation operations *****

  /**
   * Validates email address.
   *
   * @param email - The email to validate.
   * @return - True if the email is valid, false otherwise.
   */
  @Override
  public boolean validateEmail(String email) {
    // Rules: 1. Email cannot be null.
    // 2. Email must be unique within members.
    // 3. Email must be valid as defined by the regex in isValidEmail.
    if (email == null) {
      return false;
    }
    if (isValidEmail(email)) {
      return isUniqueEmail(email);
    }

    return false;
  }

  /**
   * Validates the mobile.
   *
   * @param mobile - The mobile to validate.
   * @return - True if the mobile is valid, false otherwise.
   */
  @Override
  public boolean validateMobile(String mobile) {
    // Rules: 1. Mobile cannot be null.
    // 2. Mobile must be unique within members.
    if (mobile == null || mobile.equals("")) {
      return false;
    }

    return isUniqueMobile(mobile);
  }

  /**
   * Validates the name.
   *
   * @param name - The name to validate.
   * @return - True if the name is valid, false otherwise.
   */
  @Override
  public boolean validateName(String name) {
    // Rules: 1. Name cannot be null.
    // 2. Name must be at least 2 characters long.
    // 3. Name must contain only letters, spaces, and the following special
    // characters: ,.-'
    if (name == null || name.equals("") || name.length() < MIN_NAME_LENGTH) {
      return false;
    }

    String nameRegex = "^[a-zA-Z ,.\\-\\'\\p{L}]+$";
    Pattern namePattern = Pattern.compile(nameRegex);
    Matcher matcher = namePattern.matcher(name);

    return matcher.matches();
  }

  // ***** Helper functions *****

  private LinkedList<Member> createMemberList(Iterable<Member> inList) {
    LinkedList<Member> outList = new LinkedList<Member>();
    for (Member member : inList) {
      outList.add(new Member(member.getId(), member.getName(), member.getEmail(),
          member.getMobile(), member.getMemberCreationDay()));
    }

    return outList;
  }

  private boolean isValidEmail(String email) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    Pattern emailPattern = Pattern.compile(emailRegex);
    Matcher matcher = emailPattern.matcher(email);

    return matcher.matches();
  }

  private boolean isUniqueEmail(String email) {
    for (Member member : members) {
      if (member.getEmail().equals(email)) {
        return false;
      }
    }

    return true;
  }

  private boolean isUniqueMobile(String mobile) {
    for (Member member : members) {
      if (member.getMobile().equals(mobile)) {
        return false;
      }
    }

    return true;
  }

  private boolean isValidInputData(BasicMemberData data) {
    return data.getName() != null && !data.getName().trim().isEmpty()
        && data.getEmail() != null && !data.getEmail().trim().isEmpty() && validateEmail(data.getEmail())
        && data.getMobile() != null && !data.getMobile().trim().isEmpty() && validateMobile(data.getMobile());
  }

  private void replaceMemberInList(Member oldMember, Member newMember) {
    for (int i = 0; i < members.size(); i++) {
      if (members.get(i).equals(oldMember)) {
        members.set(i, newMember);
        return;
      }
    }
  }
}
