package com.model;

/**
 * Transaction service interface.
 * Can retrieve a Member's balance and create a new transaction for a Member.
 */
public interface TransactionServices {

  /**
   * Get the balance of a member.
   *
   * @param member - member
   * @return - balance
   */
  public int getMemberBalance(Member member);

  /**
   * Create a new transaction for a member.
   *
   * @param member - member
   * @param amount - positive for credits, negative for debits
   */
  public void newTransactionForMember(Member member, int amount);

}
