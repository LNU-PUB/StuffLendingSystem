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
   * Gets a list of members sorted by name or id.
   *
   * @param asName - true if the list should be sorted by name, false if sorted by id.
   * @param ascending - true if the list should be sorted in ascending order, false if not.
   * @return - a list of members sorted by name or id.
   */
  public Iterable<Member> getMembersSortedBy(boolean asName, boolean ascending);

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
   * Get an Item by id.
   *
   * @param id - id for Item
   * @return - Item
   */
  public Item getItemById(String id);

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
   * Update an item.
   *
   * @param newItem - new item data
   * @param oldItem - old item object
   * @return - updated item
   */
  public Item updateItem(BasicItemData newItem, Item oldItem);

  /**
   * Delete an Item.
   *
   * @param itemToDelete - item to delete.
   * @return - true if deleted, false otherwise.
   */
  public boolean deleteItem(Item itemToDelete);

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
}
