package com.model;

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
  private final static int MIN_NAME_LENGTH = 2;

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
    if (mobile == null) {
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
    this.members = new ArrayList<Member>(members);
  }

  /**
   * Adds a new member.
   *
   * @param name   - The name of the member.
   * @param email  - The email of the member.
   * @param mobile - The mobile of the member.
   * @return - True if the member is added, false otherwise.
   */
  public boolean addNewMember(String name, String email, String mobile) {
    if (name == null || email == null || mobile == null) {
      return false;
    }

    if (name.equals("") || email.equals("") || mobile.equals("")) {
      return false;
    }

    if (!validateEmail(email)) {
      return false;
    }

    if (!validateMobile(mobile)) {
      return false;
    }

    String id = generateMemberId();
    List<Item> newItems = new ArrayList<>();

    Member newMember = new Member(id, name, email, mobile, newItems, timeService.getDay(), 0);
    members.add(newMember);
    updateMemberList(members);

    // signal new member added event

    return true;
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

  public void updateMember(Member member) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateMember'");
  }
}
