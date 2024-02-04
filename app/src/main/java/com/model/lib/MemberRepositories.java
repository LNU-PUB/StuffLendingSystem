package com.model.lib;

import com.model.Member;
import com.model.TimeService;
import java.util.List;

/**
 * The member repositories interface.
 */
public interface MemberRepositories {
  /**
   * Gets a list of all members.
   *
   * @return - a list of all members.
   */
  public List<Member> getMembers();

  /**
   * Gets the time service.
   *
   * @return - the time service.
   */
  public TimeService getTimeService();

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
   * @return - the new member.
   */
  public Member addNewMember(BasicMemberData member);

  /**
   * Updates a member.
   *
   * @param newMember - the new member data.
   * @param oldMember - the old member.
   * @return - the updated member.
   */
  public Member updateMember(BasicMemberData newMember, Member oldMember);

  /**
   * Deletes a member.
   *
   * @param member - the member to delete.
   * @return - true if the member was deleted, false if not.
   */
  public boolean deleteMember(Member member);
}
