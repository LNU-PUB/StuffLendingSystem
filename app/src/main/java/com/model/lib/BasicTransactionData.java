package com.model.lib;

import com.model.Member;

/**
 * Basic transaction data.
 */
public class BasicTransactionData {
  private final Member member;
  private final double amount;
  private final int transactionDay;

  /**
   * Constructor.
   *
   * @param member         - the member.
   * @param amount         - the amount.
   * @param transactionDay - the transaction day.
   */
  public BasicTransactionData(Member member, double amount, int transactionDay) {
    this.member = member;
    this.amount = amount;
    this.transactionDay = transactionDay;
  }

  /**
   * Gets the member.
   *
   * @return - the member.
   */
  public Member getMember() {
    return member;
  }

  /**
   * Gets the amount.
   *
   * @return - the amount.
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Gets the transaction day.
   *
   * @return - the transaction day.
   */
  public int getTransactionDay() {
    return transactionDay;
  }
}
