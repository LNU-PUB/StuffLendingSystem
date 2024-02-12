package com.model.lib;

import com.model.Member;
import com.model.Transaction;

/**
 * Transaction repository interface.
 */
public interface TransactionRepositories {
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
