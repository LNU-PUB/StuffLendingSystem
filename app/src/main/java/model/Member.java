package model;

import java.util.LinkedList;
import model.lib.MemberInfo;
import model.lib.RentalPeriod;

/**
 * Member class represents a Member.
 */
public class Member {
  private MemberInfo memberInfo;
  private final LinkedList<Item> items;
  private final LinkedList<Contract> contracts;

  /**
   * Member Constructor.
   *
   * @param memberInfo - member info
   */
  public Member(MemberInfo memberInfo) {
    this.memberInfo = new MemberInfo(memberInfo.name(), memberInfo.email(), memberInfo.mobile());
    this.items = new LinkedList<Item>();
    this.contracts = new LinkedList<Contract>();
  }

  /**
   * Member Constructor.
   *
   * @param member - member to copy
   */
  public Member(Member member) {
    this.memberInfo = new MemberInfo(member.getName(), member.getEmail(), member.getMobile());
    this.items = new LinkedList<Item>((LinkedList<Item>) member.getItems());
    this.contracts = new LinkedList<Contract>((LinkedList<Contract>) member.getContracts());
  }

  public String getName() { 
    return memberInfo.name();
  }

  public String getEmail() {
    return memberInfo.email();
  }

  public String getMobile() {
    return memberInfo.mobile();
  }

  public int getNumberOfItems() {
    return items.size();
  }

  public void updateMemberInfo(MemberInfo memberInfo) {
    this.memberInfo = new MemberInfo(memberInfo.name(), memberInfo.email(), memberInfo.mobile());
  }

  public Iterable<Item> getItems() {
    return new LinkedList<Item>(items);
  }

  public Iterable<Contract> getContracts() {
    return new LinkedList<Contract>(contracts);
  }

  /**
   * Adds a new item to the member.
   *
   * @param item - item to add
   */
  public void addItem(Item item) {
    Item newItem = new Item(item.getCategory(),
        item.getName(),
        item.getDescription(),
        item.getCreationDay(),
        item.getDailyLendingCost());
    this.items.add(newItem);
  }

  /**
   * Adds a new contract to the member.
   *
   * @param contract - contract to add
   */
  public void addContract(Contract contract) {
    RentalPeriod period = contract.getPeriod().iterator().next();
    Contract newContract = new Contract(contract.getMember(), contract.getItem(), period);
    this.contracts.add(newContract);
  }

}
