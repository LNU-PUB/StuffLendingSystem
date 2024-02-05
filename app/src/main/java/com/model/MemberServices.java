package com.model;

import com.model.lib.BasicMemberData;
import com.model.lib.MemberRepository;

/**
 * Member Service interface.
 */
public interface MemberServices {
  /**
   * Get a list of all Members.
   *
   * @return - list of all Members.
   */
  public Iterable<Member> getAllMembers();

  /**
   * Get an Member by id.
   *
   * @param id - id for Member
   * @return - Member
   */
  public Member getMemberById(String id);

  /**
   * Add a new Member.
   *
   * @param basicMemberData - data for new Member
   * @return - new Member
   */
  public Member addMember(BasicMemberData basicMemberData);

  /**
   * Update a member.
   *
   * @param newMember - new member data
   * @param oldMember - old member object
   * @return - updated member
   */
  public Member updateMember(BasicMemberData newMember, Member oldMember);

  /**
   * Delete a Member.
   *
   * @param member - member to delete.
   * @return - true if deleted, false otherwise.
   */
  public boolean deleteMember(Member member);

  /**
   * Validate name.
   *
   * @param name - name to validate
   * @return - true if valid, false otherwise
   */
  public boolean validateName(String name);

  /**
   * Validate email.
   *
   * @param email - email to validate
   * @return - true if valid, false otherwise
   */
  public boolean validateEmail(String email);

  /**
   * Validate mobile.
   *
   * @param mobile - mobile to validate
   * @return - true if valid, false otherwise
   */
  public boolean validateMobile(String mobile);

  /**
   * Get the current day.
   *
   * @return - current day
   */
  public int getDay();

  /**
   * Advance the day.
   */
  public void advanceDay();
}
