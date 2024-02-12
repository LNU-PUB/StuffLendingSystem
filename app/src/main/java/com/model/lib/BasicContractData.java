package com.model.lib;

import com.model.Item;
import com.model.Member;

/**
 * Class for basic contract data.
 */
public class BasicContractData {
  private final Member owner;
  private final Member borrower;
  private final Item item;
  private final int startDay;
  private final int endDay;

  /**
   * Constructor.
   *
   * @param owner    - the item's owner
   * @param borrower - the borrower of the item.
   * @param item     - the item lent.
   * @param startDay - contract starting day.
   * @param endDay   - contract ending day.
   */
  public BasicContractData(Member owner, Member borrower, Item item, int startDay, int endDay) {
    this.owner = owner;
    this.borrower = borrower;
    this.item = item;
    this.startDay = startDay;
    this.endDay = endDay;
  }

  /**
   * Gets the owner of the item.
   *
   * @return - the owner member.
   */
  public Member getOwner() {
    return new Member(owner);
  }

  /**
   * Gets the borrower of the item.
   *
   * @return - the borrowing member.
   */
  public Member getBorrower() {
    return new Member(borrower);
  }

  /**
   * Get's the item.
   *
   * @return - the item that is being lent.
   */
  public Item getItem() {
    return new Item(item);
  }

  /**
   * Get's the starting day of the contract.
   *
   * @return - starting day.
   */
  public int getStartDay() {
    return startDay;
  }

  /**
   * Get's the end day of the contract.
   *
   * @return - the end day.
   */
  public int getEndDay() {
    return endDay;
  }
}
