package com.model.lib;

import com.model.Member;
import com.model.TimeRepository;
import com.model.Transaction;

/**
 * Transaction repository.
 */
public class TransactionRepository implements TransactionRepositories {
  private final TimeRepository timeService;

  /**
   * Constructor.
   *
   * @param timeService - time service
   */
  public TransactionRepository(TimeRepository timeService) {
    this.timeService = timeService;
  }

  public TransactionRepository(TimeRepository timeService2, Iterable<Transaction> allTransactions) {
    this.timeService = new TimeRepository();
  }

  @Override
  public int getDay() {
    return timeService.getDay();
  }

  @Override
  public int getMemberBalance(Member member) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getMemberBalance'");
  }

  @Override
  public Object newTransactionForMember(Member member, int amount) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'newTransactionForMember'");
  }

  @Override
  public Iterable<Transaction> getAllTransactions() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllTransactions'");
  }
}
