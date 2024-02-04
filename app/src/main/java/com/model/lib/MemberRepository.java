package com.model.lib;

import com.model.Member;
import com.model.TimeService;
import com.model.db.DataHandlerMember;
import com.model.db.DataHardCodedMember;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The stuff lending system.
 */
public class MemberRepository implements MemberRepositories {
  private final TimeService timeService;
  private final DataHandlerMember dataHandler;
  private List<Member> members;
  private final SecureRandom random;
  private static final int MIN_NAME_LENGTH = 2;

  /**
   * Creates a new instance of the stuff lending system.
   */
  public MemberRepository(TimeService timeService) {
    this.dataHandler = new DataHardCodedMember();
    this.members = new ArrayList<Member>(dataHandler.getMembers());
    this.random = new SecureRandom();
    this.timeService = timeService;
  }

  /**
   * Deep copy constructor. Creates a new instance of the stuff lending system.
   *
   * @param timeService - The time service.
   * @param members     - The members.
   */
  public MemberRepository(TimeService timeService, List<Member> members) {
    this.members = new ArrayList<Member>(members);
    this.random = new SecureRandom();
    this.timeService = timeService;
    this.dataHandler = null;
  }

  /**
   * Gets the member list.
   *
   * @return - The member list.
   */

  public List<Member> getMembers() {
    return Collections.unmodifiableList(new LinkedList<>(members));
  }

  public TimeService getTimeService() {
    return timeService;
  }

  /**
   * Validates email address.
   *
   * @param email - The email to validate.
   * @return - True if the email is valid, false otherwise.
   */

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

  public boolean validateName(String name) {
    if (name == null || name.equals("") || name.length() < MIN_NAME_LENGTH) {
      return false;
    }

    String nameRegex = "^[a-zA-Z ,.\\-\\'\\p{L}]+$";
    Pattern namePattern = Pattern.compile(nameRegex);
    Matcher matcher = namePattern.matcher(name);

    return matcher.matches();
  }

  /**
   * Updates a member.
   *
   * @param newMember - The new member data.
   * @param member    - The member to update.
   * @return - The updated member if successful or null if not.
   */

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
    return updatedMember;
  }

  /**
   * Adds a new member.
   *
   * @param data - The member data.
   * @return - The new member if successful or null if not.
   */

  public Member addNewMember(BasicMemberData data) {
    if (data == null || !isValidInputData(data)) {
      return null;
    }

    String id = generateMemberId();

    Member newMember = new Member(id, data.getName(), data.getEmail(), data.getMobile(), timeService.getDay());

    synchronized (this) {
      if (!validateEmail(data.getEmail()) || !validateMobile(data.getMobile()) || !validateName(data.getName())) {
        return null;
      }
      members.add(newMember);
      // updateMemberList(members);
    }

    return newMember;
  }

  // Helper functions
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

  /**
   * Updates the member list.
   *
   * @param newList - The member to update.
   */
  // private synchronized void updateMemberList(List<Member> newList) {
  // LinkedList<Member> newMemberList = new LinkedList<Member>();

  // for (Member member : newList) {
  // newMemberList.add(new Member(member));
  // }
  // this.members = newMemberList;
  // }

  private boolean isValidInputData(BasicMemberData data) {
    return data.getName() != null && !data.getName().trim().isEmpty()
        && data.getEmail() != null && !data.getEmail().trim().isEmpty() && validateEmail(data.getEmail())
        && data.getMobile() != null && !data.getMobile().trim().isEmpty() && validateMobile(data.getMobile());
  }

  private String generateMemberId() {
    while (true) {
      String id = generateRandomId();
      if (isUniqueMemberId(id)) {
        return id;
      }
    }
  }

  private String generateRandomId() {
    // 6 alpha-numeric characters
    String alphaNumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder result = new StringBuilder(6);

    for (int i = 0; i < 6; i++) {
      int index = this.random.nextInt(alphaNumericCharacters.length());
      result.append(alphaNumericCharacters.charAt(index));
    }

    return result.toString();
  }

  private boolean isUniqueMemberId(String id) {
    if (id == null || id.length() != 6) {
      return false;
    }

    for (Member member : members) {
      if (member.getId().equals(id)) {
        return false;
      }
    }

    return true;
  }

  private void replaceMemberInList(Member oldMember, Member newMember) {
    for (int i = 0; i < members.size(); i++) {
      if (members.get(i).getId().equals(oldMember.getId())) {
        members.set(i, newMember);
        return;
      }
    }
  }

  /**
   * Gets a member by id.
   *
   * @param id - The id of the member to get.
   * @return - The member if found, null otherwise.
   */

  public Member getMemberById(String id) {
    for (Member member : members) {
      if (member.getId().equals(id)) {
        return new Member(member);
      }
    }

    return null;
  }

  /**
   * Deletes a member.
   *
   * @param member - The member to delete.
   * @return - True if the member was deleted, false otherwise.
   */

  public boolean deleteMember(Member member) {
    return true; // for development only.
  }
}
