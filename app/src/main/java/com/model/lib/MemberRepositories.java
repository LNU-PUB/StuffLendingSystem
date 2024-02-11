package com.model.lib;

import com.model.Member;

/**
 * The member repositories interface.
 */
public interface MemberRepositories {
  // ***** CRUD operations *****

  /**
   * Gets a list of all members.
   *
   * @return - a list of all members.
   */
  public Iterable<Member> getMembers();

  /**
   * Gets a list of members sorted by name or id.
   *
   * @param asName - true if the list should be sorted by name, false if sorted by id.
   * @param ascending - true if the list should be sorted in ascending order, false if not.
   * @return - a list of members sorted by name or id.
   */
  public Iterable<Member> getMembersSortedBy(boolean asName, boolean ascending);

  /**
   * Gets a member by id.
   *
   * @param id - the id of the member.
   * @return - the member.
   */
  public Member getMemberById(String id);

  /**
   * Adds a new member.
   *
   * @param member - the member to add.
   * @return - the updated member repository.
   */
  public Member addNewMember(BasicMemberData member);

  /**
   * Updates a member.
   *
   * @param newMember - the new member data.
   * @param oldMember - the old member.
   * @return - the updated member repository
   */
  public Member updateMember(BasicMemberData newMember, Member oldMember);

  /**
   * Deletes a member.
   *
   * @param member - the member to delete.
   * @return - true if the member was deleted, false if not.
   */
  public boolean deleteMember(Member member);

  // ***** Validation operations *****

  /**
   * Validates an email.
   *
   * @param email - the email.
   * @return - true if the email is valid, false if not.
   */
  public boolean validateEmail(String email);

  /**
   * Validates a mobile number.
   *
   * @param mobile - the mobile number.
   * @return - true if the mobile number is valid, false if not.
   */
  public boolean validateMobile(String mobile);

  /**
   * Validates a name.
   *
   * @param name - the name.
   * @return - true if the name is valid, false if not.
   */
  public boolean validateName(String name);
}
