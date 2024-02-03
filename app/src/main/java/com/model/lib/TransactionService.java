package com.model.lib;

import com.model.Member;
import com.model.TransactionServices;

/**
 * Transaction service.
 */
public class TransactionService implements TransactionServices {
  private MemberRepository memberRepo;

  public TransactionService(MemberRepository memberRepo) {
    this.memberRepo = memberRepo;
  }
  
  @Override
  public int getMemberBalance(Member member) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getMemberBalance'");
  }

  @Override
  public void newTransactionForMember(Member member, int amount) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'newTransactionForMember'");
  }
  
}
