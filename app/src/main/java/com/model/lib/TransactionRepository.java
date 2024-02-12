package com.model.lib;

import com.model.Member;
import com.model.Transaction;
import com.model.db.DataHandler;
import com.model.db.HardCodedData;
import java.util.ArrayList;
import java.util.List;

/**
 * Transaction repository.
 */
public class TransactionRepository implements TransactionRepositories {
  private final List<Transaction> transactions;
  private final DataHandler dataHandler;

  /**
   * Constructor.
   */
  public TransactionRepository() {
    this.dataHandler = new HardCodedData();
    this.transactions = new ArrayList<>(this.dataHandler.getTransactions());

  }

  /**
   * Constructor.
   *
   * @param transactions - the transactions.
   */
  public TransactionRepository(Iterable<Transaction> transactions) {
    this.transactions = createTransactionList(transactions);
    this.dataHandler = null;
  }

  @Override
  public Iterable<Transaction> getAllTransactions() {
    return new ArrayList<Transaction>(transactions);
  }

  @Override
  public Transaction getTransactionById(String id) {
    for (Transaction transaction : transactions) {
      if (transaction.getId().equals(id)) {
        return new Transaction(transaction);
      }
    }

    return null;
  }

  @Override
  public Iterable<Transaction> getTransactionsByMember(Member member) {
    List<Transaction> outList = new ArrayList<>();

    for (Transaction transaction : transactions) {
      if (transaction.getMember().equals(member)) {
        outList.add(transaction);
      }
    }

    return outList;
  }

  @Override
  public Transaction addNewTransaction(BasicTransactionData basicTransactionData) {
    IdGenerator<Transaction> generator = new IdGenerator<>();
    String id = generator.generateId(transactions);

    Transaction newTransaction = new Transaction(id, basicTransactionData.getMember(),
        basicTransactionData.getAmount(), basicTransactionData.getTransactionDay());

    transactions.add(newTransaction);

    return new Transaction(newTransaction);
  }

  @Override
  public Transaction updateTransaction(Transaction updatedTransaction, Transaction oldTransaction) {
    Member member = updatedTransaction.getMember();
    double amount = updatedTransaction.getAmount();
    int transactionDay = updatedTransaction.getTransactionDay();

    synchronized (this) {
      String id = oldTransaction.getId();
      Transaction newTransaction = new Transaction(id, member, amount, transactionDay);

      replaceContractInList(newTransaction, oldTransaction);

      return new Transaction(newTransaction);
    }
  }

  @Override
  public boolean deleteTransaction(Transaction transaction) {

    for (Transaction t : transactions) {
      if (t.equals(transaction)) {
        transactions.remove(t);
        return true;
      }
    }

    return false;
  }

  @Override
  public double getMemberBalance(Member member) {
    List<Transaction> memberTransactions = (List<Transaction>) getTransactionsByMember(member);
    double balance = 0;

    for (Transaction transaction : memberTransactions) {
      balance += transaction.getAmount();
    }

    return balance;
  }

  // ***** Helper functions *****

  private List<Transaction> createTransactionList(Iterable<Transaction> allTransactions) {
    List<Transaction> outList = new ArrayList<>();

    for (Transaction transaction : allTransactions) {
      outList.add(new Transaction(transaction));
    }

    return outList;
  }

  private void replaceContractInList(Transaction newTransaction, Transaction oldTransaction) {

    for (int i = 0; i < transactions.size(); i++) {
      if (transactions.get(i).equals(oldTransaction)) {
        transactions.set(i, newTransaction);
        return;
      }
    }
  }
}
