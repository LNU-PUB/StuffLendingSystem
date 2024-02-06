package com.controller.model;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.Transaction;

/**
 * Interface for displaying data bundles.
 */
public interface DisplayDataBundles {
  /**
   * Get the members.
   *
   * @return - The members.
   */
  Iterable<Member> getMembers();

  /**
   * Get the items.
   *
   * @return - The items.
   */
  Iterable<Item> getItems();

  /**
   * Get the contracts.
   *
   * @return - The contracts.
   */
  Iterable<Contract> getContracts();

  /**
   * Get the transactions.
   *
   * @return - The transactions.
   */
  Iterable<Transaction> getTransactions();
}
