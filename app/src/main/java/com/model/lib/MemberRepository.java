package com.model.lib;

import com.model.Member;
import com.model.db.DataHandler;
import com.model.db.DataHardCodedMember;
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
    this.dataHandler = new DataHardCodedMember();
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
      // updateMemberList(members);
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
    final String id = member.getId();
    final String name = newMember.getName();
    final String email = newMember.getEmail();
    final String mobile = newMember.getMobile();
    final int creationDay = member.getMemberCreationDay();

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

    Member updatedMember = new Member(id, name, email, mobile, creationDay);

    replaceMemberInList(member, updatedMember);
    return new Member(updatedMember.getId(), updatedMember.getName(), updatedMember.getEmail(),
        updatedMember.getMobile(), updatedMember.getMemberCreationDay());
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

  /**
   * Validates email address.
   *
   * @param email - The email to validate.
   * @return - True if the email is valid, false otherwise.
   */
  @Override
  public boolean validateEmail(String email) {
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
    if (name == null || name.equals("") || name.length() < MIN_NAME_LENGTH) {
      return false;
    }

    String nameRegex = "^[a-zA-Z ,.\\-\\'\\p{L}]+$";
    Pattern namePattern = Pattern.compile(nameRegex);
    Matcher matcher = namePattern.matcher(name);

    return matcher.matches();
  }

  // *** Helper functions START ***

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

  // private String generateMemberId() {
  //   while (true) {
  //     String id = generateRandomId();
  //     if (isUniqueMemberId(id)) {
  //       return id;
  //     }
  //   }
  // }

  // private String generateRandomId() {
  //   // 6 alpha-numeric characters
  //   String alphaNumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  //   StringBuilder result = new StringBuilder(6);

  //   for (int i = 0; i < 6; i++) {
  //     int index = this.random.nextInt(alphaNumericCharacters.length());
  //     result.append(alphaNumericCharacters.charAt(index));
  //   }

  //   return result.toString();
  // }

  // private boolean isUniqueMemberId(String id) {
  //   if (id == null || id.length() != 6) {
  //     return false;
  //   }

  //   for (Member member : members) {
  //     if (member.getId().equals(id)) {
  //       return false;
  //     }
  //   }

  //   return true;
  // }

  private void replaceMemberInList(Member oldMember, Member newMember) {
    for (int i = 0; i < members.size(); i++) {
      if (members.get(i).getId().equals(oldMember.getId())) {
        members.set(i, newMember);
        return;
      }
    }
  }
}
