package com.model;

import com.model.lib.Identifiable;

/**
 * Represents a transaction.
 */
public class Transaction implements Identifiable {
  private final String id;
  private final Member member;
  private final double amount;
  private final int transactionDay;


  /**
   * Constructor.
   *
   * @param id - the unique id of the transaction.
   */
  public Transaction(String id, Member member, double amount, int transactionDay) {
    this.id = id;
    this.member = member;
    this.amount = amount;
    this.transactionDay = transactionDay;
  }

  /**
   * Constructor.
   *
   * @param transaction - the transaction to create a deep copy of.
   */
  public Transaction(Transaction transaction) {
    this.id = transaction.id;
    this.member = transaction.member;
    this.amount = transaction.amount;
    this.transactionDay = transaction.transactionDay;
  }

  @Override
  public String getId() {
    return id;
  }

  /**
   * Returns the member that the transaction is associated with.
   *
   * @return - the member that the transaction is associated with.
   */
  public Member getMember() {
    return member;
  }

  /**
   * Returns the amount of the transaction.
   *
   * @return - the amount of the transaction.
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Returns the day of the transaction.
   *
   * @return - the day of the transaction.
   */
  public int getTransactionDay() {
    return transactionDay;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Transaction transaction = (Transaction) obj;

    return id.equals(transaction.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
