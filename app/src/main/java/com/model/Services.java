package com.model;

import com.model.lib.BasicItemData;
import com.model.lib.BasicMemberData;

/**
 * Member Service interface.
 */
public interface Services {

  // ***** Members *****

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
   * Validate member name.
   *
   * @param name - name to validate
   * @return - true if valid, false otherwise
   */
  public boolean validateMemberName(String name);

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

  //***** Time *****

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

  // ***** Items *****

  /**
   * Get a list of all Items.
   *
   * @return - list of all Items.
   */
  public Iterable<Item> getAllItems();

  /**
   * Get an Item by member.
   *
   * @param member - member to get items for
   * @return - list of items
   */
  public Iterable<Item> getItemsByMember(Member member);

  /**
   * Add a new Item.
   *
   * @param basicItemData - data for new Item
   * @return - new Item
   */
  public Item addItem(BasicItemData basicItemData);

  /**
   * Validate item name.
   *
   * @param name - name to validate
   * @return - true if valid, false otherwise
   */
  public boolean validateItemName(String name);

  /**
   * Validate item description.
   *
   * @param description - description to validate
   * @return - true if valid, false otherwise
   */
  public boolean validateItemDescription(String description);

  /**
   * Validate item cost per day.
   *
   * @param costPerDay - cost per day to validate
   * @return - true if valid, false otherwise
   */
  public boolean validateItemCostPerDay(double costPerDay);

  /**
   * Get an Item by id.
   *
   * @param id - id for Item
   * @return - Item
   */
  public Item getItemById(String id);
  
}
