package com.model.lib;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.Services;
import com.model.Transaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// NOTE:
// If done properly there should have been a roll-back mechanism 
// in case of failure for each operation that updates or deletes data to ensure
// that the data is consistent. This is not implemented here.

/**
 * Service.
 */
public final class Service implements Services {
  private static final int NEW_ITEM_CREDIT = 100;
  private final TimeRepositories timeRepo;
  private final MemberRepositories memberRepo;
  private final ItemRepositories itemRepo;
  private final ContractRepositories contractRepo;
  private final TransactionRepositories transactionRepo;

  /**
   * Constructor.
   *
   * @param timeRepo   - time repository
   * @param memberRepo - member repository
   * @param itemRepo   - item repository
   */
  public Service(TimeRepositories timeRepo, MemberRepositories memberRepo, ItemRepositories itemRepo,
      ContractRepositories contractRepo, TransactionRepositories transactionRepo) {
    this.timeRepo = new TimeRepository(timeRepo.getDay());
    this.memberRepo = new MemberRepository(memberRepo.getMembers());
    this.itemRepo = new ItemRepository(itemRepo.getItems());
    this.contractRepo = new ContractRepository(contractRepo.getContracts());
    this.transactionRepo = new TransactionRepository(transactionRepo.getAllTransactions());
  }

  // ***** Common *****
  @Override
  public int getSizeOfList(Iterable<?> list) {
    if (list instanceof Collection<?>) {
      return ((Collection<?>) list).size();
    } else {
      int size = 0;
      for (Object o : list) {
        size++;
      }
      return size;
    }
  }

  // ***** Members *****

  @Override
  public Iterable<Member> getAllMembers() {
    return memberRepo.getMembers();
  }

  @Override
  public Iterable<Member> getMembersSortedBy(boolean asName, boolean ascending) {
    return memberRepo.getMembersSortedBy(asName, ascending);
  }

  @Override
  public Member getMemberById(String id) {
    if (id.isEmpty()) {
      return null;
    }

    return memberRepo.getMemberById(id);
  }

  @Override
  public Member addMember(BasicMemberData member) {
    if (member == null) {
      return null;
    }
    return memberRepo.addNewMember(member);
  }

  @Override
  public Member updateMember(BasicMemberData newMember, Member oldMember) {
    if (newMember == null || oldMember == null) {
      return null;
    }

    return memberRepo.updateMember(newMember, oldMember);
  }

  @Override
  public boolean deleteMember(Member member) {
    Iterable<Item> items = itemRepo.getItemsByMember(member);

    for (Item item : items) {
      itemRepo.deleteItem(item);
    }

    return member != null && memberRepo.deleteMember(member);
  }

  @Override
  public boolean validateMemberName(String name) {
    return memberRepo.validateName(name);
  }

  @Override
  public boolean validateEmail(String email) {
    return memberRepo.validateEmail(email);
  }

  @Override
  public boolean validateMobile(String mobile) {
    return memberRepo.validateMobile(mobile);
  }

  // ***** Time *****
  @Override
  public int getDay() {
    return timeRepo.getDay();
  }

  @Override
  public void advanceDay() {
    timeRepo.advanceDay();
  }

  // ***** Item *****

  @Override
  public Iterable<Item> getAllItems() {
    return itemRepo.getItems();
  }

  @Override
  public Item getItemById(String id) {
    return itemRepo.getItemById(id);
  }

  @Override
  public Iterable<Item> getItemsByMember(Member member) {
    return itemRepo.getItemsByMember(member);
  }

  @Override
  public boolean isItemAvailable(Item item, int startDay, int endDay) {
    Iterable<Contract> contracts = contractRepo.getContractsByItem(item);

    for (Contract contract : contracts) {
      // Check if suggested start day is within this contract's rental period.
      if (contract.getStartDay() >= startDay && contract.getStartDay() <= endDay) {
        return false;
      }

      // Check if suggested end day is within this contract's rental period.
      if (endDay >= contract.getStartDay() && endDay <= contract.getEndDay()) {
        return false;
      }
    }

    return true;
  }

  @Override
  public Item addItem(BasicItemData basicItemData) {
    if (basicItemData == null) {
      return null;
    }

    // Member's credit for adding an item.
    BasicTransactionData basicTransactionData = new BasicTransactionData(basicItemData.getOwner(),
        NEW_ITEM_CREDIT, timeRepo.getDay());
    transactionRepo.addNewTransaction(basicTransactionData);
    // *** ONLY for testing ***
    // for (Transaction transaction :
    // transactionRepo.getTransactionsByMember(basicItemData.getOwner())) {
    // System.out.println(transaction.getMember().getName() + " credits: " +
    // transaction.getAmount() + " on day: "
    // + transaction.getTransactionDay());
    // }
    // System.out.println(basicItemData.getOwner().getName() + " has a credit of: "
    // + transactionRepo.getMemberBalance(basicItemData.getOwner()));

    return itemRepo.addItem(basicItemData);
  }

  @Override
  public Item updateItem(BasicItemData newItem, Item oldItem) {
    if (newItem == null || oldItem == null) {
      return null;
    }

    return itemRepo.updateItem(newItem, oldItem);
  }

  @Override
  public boolean deleteItem(Item itemToDelete) {
    // for testing only.
    Iterable<Contract> contracts3 = contractRepo.getContracts();

    System.out.println("Number of contracts b4 delete: " + getSizeOfList(contracts3));

    if (itemToDelete == null) {
      return false;
    }

    // delete all contracts associated with this item
    Iterable<Contract> contracts = contractRepo.getContractsByItem(itemToDelete);
    for (Contract contract : contracts) {
      contractRepo.deleteContract(contract);
    }

    // for testing only. s.3
    Iterable<Contract> contracts2 = contractRepo.getContracts();
    System.out.println("Number of contracts: " + getSizeOfList(contracts2));
    for (Contract contract : contracts2) {
      System.out.println(contract.getId());
    }

    return itemRepo.deleteItem(itemToDelete);
  }

  @Override
  public boolean validateItemName(String name) {
    return itemRepo.validateName(name);
  }

  @Override
  public boolean validateItemDescription(String description) {
    return itemRepo.validateDescription(description);
  }

  @Override
  public boolean validateItemCostPerDay(double costPerDay) {
    return itemRepo.validateCostPerDay(costPerDay);
  }

  // ***** Contract *****

  @Override
  public Iterable<Contract> getContracts() {
    return contractRepo.getContracts();
  }

  @Override
  public Iterable<Contract> getContractsByMember(Member member) {
    return contractRepo.getContractsByMember(member);
  }

  @Override
  public Iterable<Contract> getContractsByOwner(Member owner) {
    return contractRepo.getContractsByOwner(owner);
  }

  @Override
  public Iterable<Contract> getContractsByBorrower(Member borrower) {
    return contractRepo.getContractsByBorrower(borrower);
  }

  @Override
  public Iterable<Contract> getContractsByItem(Item item) {
    return contractRepo.getContractsByItem(item);
  }

  @Override
  public Iterable<Contract> getItemSpecificContractsForRange(Item item, int startDay, int endDay) {
    List<Contract> list = new ArrayList<>();
    Iterable<Contract> contracts = contractRepo.getContractsByItem(item);

    for (Contract contract : contracts) {
      if (contract.getStartDay() >= startDay && contract.getStartDay() <= endDay) {
        // Checks if suggested start day is within this contract's rental period.
        list.add(contract);
      } else if (endDay >= contract.getStartDay() && endDay <= contract.getEndDay()) {
        // Checks if suggested end day is within this contract's rental period.
        list.add(contract);
      }
    }

    return list;
  }

  @Override
  public Contract addNewContract(BasicContractData contractData) {
    return contractRepo.addNewContract(contractData);
  }

  @Override
  public Contract updateContract(BasicContractData newContractData, Contract oldContract) {
    return contractRepo.updateContract(newContractData, oldContract);
  }

  @Override
  public boolean deleteContract(Contract contractToDelete) {
    return contractRepo.deleteContract(contractToDelete);
  }

  // ***** Transactions *****

  @Override
  public Iterable<Transaction> getAllTransactions() {
    return transactionRepo.getAllTransactions();
  }

  @Override
  public Transaction getTransactionById(String id) {
    return transactionRepo.getTransactionById(id);
  }

  @Override
  public Iterable<Transaction> getTransactionsByMember(Member member) {
    return transactionRepo.getTransactionsByMember(member);
  }

  @Override
  public Transaction addNewTransaction(BasicTransactionData basicTransactionData) {
    return transactionRepo.addNewTransaction(basicTransactionData);
  }

  @Override
  public Transaction updateTransaction(Transaction updatedTransaction, Transaction oldTransaction) {
    return transactionRepo.updateTransaction(updatedTransaction, oldTransaction);
  }

  @Override
  public boolean deleteTransaction(Transaction transaction) {
    return transactionRepo.deleteTransaction(transaction);
  }

  @Override
  public double getMemberBalance(Member member) {
    return transactionRepo.getMemberBalance(member);
  }
}
