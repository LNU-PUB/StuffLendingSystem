package com.model.lib;

import com.model.Member;
import com.model.TimeService;
import com.model.db.DataHandlerMember;
import com.model.db.DataHardCodedMember;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The stuff lending system.
 */
public class MemberRepository {
  private TimeService timeService;
  private DataHandlerMember dataHandler;
  private List<Member> members;
  private final SecureRandom random;
  private static final int MIN_NAME_LENGTH = 2;

  /**
   * Creates a new instance of the stuff lending system.
   */
  public MemberRepository(TimeService timeService) {
    this.dataHandler = new DataHardCodedMember();
    this.members = dataHandler.getMembers();
    this.random = new SecureRandom();
    this.timeService = timeService;
  }

  /**
   * Gets the member list.
   *
   * @return - The member list.
   */
  public List<Member> getMembers() {
    return Collections.unmodifiableList(new ArrayList<>(members));
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

  private boolean isUniqueMobile(String mobile) {
    for (Member member : members) {
      if (member.getMobile().equals(mobile)) {
        return false;
      }
    }

    return true;
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
   * Updates the member list.
   *
   * @param newList - The member to update.
   */
  public void updateMemberList(List<Member> newList) {
    ArrayList<Member> newMemberList = new ArrayList<Member>();

    for (Member member : newList) {
      newMemberList.add(new Member(member));
    }
    this.members = newMemberList;
  }

  /**
   * Adds a new member.
   *
   * @param data - The member data.
   * @return - The new member if successful or null if not.
   */
  public Member addNewMember(BasicMemberData data) {
    String name = data.getName();
    String email = data.getEmail();
    String mobile = data.getMobile();

    if (name == null || email == null || mobile == null) {
      return null;
    }

    if (name.equals("") || email.equals("") || mobile.equals("")) {
      return null;
    }

    if (!validateEmail(email)) {
      return null;
    }

    if (!validateMobile(mobile)) {
      return null;
    }

    String id = generateMemberId();

    Member newMember = new Member(id, name, email, mobile, timeService.getDay());
    boolean success = members.add(newMember);
    if (success) {
      updateMemberList(members);
    }

    return success ? newMember : null;
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

  public Member updateMember(BasicMemberData newMember, Member member) {
    String id = member.getId();
    String name = newMember.getName();
    String email = newMember.getEmail();
    String mobile = newMember.getMobile();
    int creationDay = member.getMemberCreationDay();

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

  private void replaceMemberInList(Member oldMember, Member newMember) {
    for (int i = 0; i < members.size(); i++) {
      if (members.get(i).getId().equals(oldMember.getId())) {
        members.set(i, newMember);
        return;
      }
    }
  }

  public Member getMemberById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getMemberById'");
  }

  public boolean deleteMember(Member member) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteMember'");
  }
}
