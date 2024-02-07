package com.model.lib;

import com.model.Member;
import com.model.Transaction;

/**
 * Transaction repository interface.
 */
public interface TransactionRepositories {
  
  int getDay();

  int getMemberBalance(Member member);

  Object newTransactionForMember(Member member, int amount);

  Iterable<Transaction> getAllTransactions();
}
