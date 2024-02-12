package com.model.db;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.Transaction;

import java.util.List;

/**
 * Handles data access and storage for Member objects.
 */
public interface DataHandler {
  /**
   * Gets the member list.
   *
   * @return - The member list.
   */
  public List<Member> getMembers();

  /**
   * Gets the item list.
   *
   * @return - The item list.
   */
  public List<Item> getItems();

  /**
   * Gets the contract list.
   *
   * @return - The contract list.
   */
  public List<Contract> getContracts();

  /**
   * Gets the transaction list.
   *
   * @return - The transaction list.
   */
  public List<Transaction> getTransactions();
  
  /**
   * Stores a list of items.
   *
   * @param items - The list of items to store.
   * @return - True if the items were stored, false otherwise.
   */
  public boolean storeItems(List<Item> items);

  /**
   * Stores a list of members.
   *
   * @param members - The list of members to store.
   * @return - True if the members were stored, false otherwise.
   */
  public boolean storeMembers(List<Member> members);

  /**
   * Stores a list of contracts.
   *
   * @param contracts - The list of contracts to store.
   * @return - True if the contracts were stored, false otherwise.
   */
  public boolean storeContracts(List<Contract> contracts);
}
