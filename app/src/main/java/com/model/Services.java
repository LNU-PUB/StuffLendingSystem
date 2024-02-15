package com.model;

import com.model.lib.BasicContractData;
import com.model.lib.BasicItemData;
import com.model.lib.BasicMemberData;
import com.model.lib.BasicTransactionData;

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
   * @param asName    - true if the list should be sorted by name, false if sorted
   *                  by id.
   * @param ascending - true if the list should be sorted in ascending order,
   *                  false if not.
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

  // ***** Time *****

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

  // ***** Contracts *****

  /**
   * Gets all contracts.
   *
   * @return - all contracts.
   */
  Iterable<Contract> getContracts();

  /**
   * Gets all contracts by owner.
   *
   * @param owner - the owner.
   * @return - all contracts by owner.
   */
  Iterable<Contract> getContractsByOwner(Member owner);

  /**
   * Gets all contracts by borrower.
   *
   * @param borrower - the borrower.
   * @return - all contracts by borrower.
   */
  Iterable<Contract> getContractsByBorrower(Member borrower);

  /**
   * Gets all contracts by member both as owner and borrower.
   *
   * @param member - the member.
   * @return - all contracts by member.
   */
  Iterable<Contract> getContractsByMember(Member member);

  /**
   * Gets all contracts by item.
   *
   * @param item - the item.
   * @return - all contracts by item.
   */
  Iterable<Contract> getContractsByItem(Item item);

  /**
   * Adds a new contract.
   *
   * @param contractData - the contract data.
   * @return - the new contract.
   */
  Contract addNewContract(BasicContractData contractData);

  /**
   * Updates a contract.
   *
   * @param newContractData - the new contract data.
   * @param oldContract     - the old contract.
   * @return - the updated contract.
   */
  Contract updateContract(BasicContractData newContractData, Contract oldContract);

  /**
   * Deletes a contract.
   *
   * @param contractToDelete - the contract to delete.
   * @return - true if the contract was deleted, false otherwise.
   */
  boolean deleteContract(Contract contractToDelete);

  // ***** Transactions *****

  /**
   * Gets all transactions.
   *
   * @return - all transactions.
   */
  Iterable<Transaction> getAllTransactions();

  /**
   * Gets a transaction by id.
   *
   * @param id - the id.
   * @return - the transaction.
   */
  Transaction getTransactionById(String id);

  /**
   * Gets all transactions by member.
   *
   * @param member - the member.
   * @return - all transactions by member.
   */
  Iterable<Transaction> getTransactionsByMember(Member member);

  /**
   * Adds a new transaction.
   *
   * @param basicTransactionData - the basic transaction data.
   * @return - the new transaction.
   */
  Transaction addNewTransaction(BasicTransactionData basicTransactionData);

  /**
   * Updates a transaction.
   *
   * @param updatedTransaction - the updated transaction.
   * @param oldTransaction     - the old transaction.
   * @return - the updated transaction.
   */
  Transaction updateTransaction(Transaction updatedTransaction, Transaction oldTransaction);

  /**
   * Deletes a transaction.
   *
   * @param transaction - the transaction.
   * @return - true if the transaction was deleted, false otherwise.
   */
  boolean deleteTransaction(Transaction transaction);

  /**
   * Gets the balance of a member.
   *
   * @param member - the member.
   * @return - the balance of the member.
   */
  double getMemberBalance(Member member);
}
