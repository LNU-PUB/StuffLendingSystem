package com.model.lib;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.Services;

/**
 * Member Service.
 */
public final class Service implements Services {
  private final TimeRepositories timeRepo;
  private final MemberRepositories memberRepo;
  private final ItemRepositories itemRepo;
  private final ContractRepositories contractRepo;
  private final TransactionRepositories transactionRepo;
  private final static int NEW_ITEM_CREDIT = 100;

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
  public Item addItem(BasicItemData basicItemData) {
    if (basicItemData == null) {
      return null;
    }

    // Member's credit for adding an item.
    BasicTransactionData basicTransactionData = new BasicTransactionData(basicItemData.getOwner(),
        NEW_ITEM_CREDIT, timeRepo.getDay());
    transactionRepo.addNewTransaction(basicTransactionData);
    // *** ONLY for testing ***
    // for (Transaction transaction : transactionRepo.getTransactionsByMember(basicItemData.getOwner())) {
    //   System.out.println(transaction.getMember().getName() + " credits: " + transaction.getAmount() + " on day: "
    //       + transaction.getTransactionDay());
    // }
    // System.out.println(basicItemData.getOwner().getName() + " has a credit of: "
    //     + transactionRepo.getMemberBalance(basicItemData.getOwner()));

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
    if (itemToDelete == null) {
      return false;
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
}
