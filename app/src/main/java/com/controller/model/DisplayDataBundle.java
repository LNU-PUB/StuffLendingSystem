package com.controller.model;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.Transaction;

/**
 * Class for displaying data bundles.
 */
public class DisplayDataBundle implements DisplayDataBundles {
  private final Iterable<Member> members;
  private final Iterable<Item> items;
  private final Iterable<Contract> contracts;
  private final Iterable<Transaction> transactions;

  /**
   * Constructor for the display data bundle.
   *
   * @param members       - The members.
   * @param items         - The items.
   * @param contracts     - The contracts.
   * @param transactions  - The transactions.
   */
  public DisplayDataBundle(Iterable<Member> members, Iterable<Item> items, Iterable<Contract> contracts,
      Iterable<Transaction> transactions) {
    this.members = members;
    this.items = items;
    this.contracts = contracts;
    this.transactions = transactions;
  }

  @Override
  public Iterable<Member> getMembers() {
    return members;
  }

  @Override
  public Iterable<Item> getItems() {
    return items;
  }

  @Override
  public Iterable<Contract> getContracts() {
    return contracts;
  }

  @Override
  public Iterable<Transaction> getTransactions() {
    return transactions;
  }

}
