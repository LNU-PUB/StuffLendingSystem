package com.model;

/**
 * A contract between a member and the stuff lending system.
 */
public class Contract {
  private final Member owner;
  private final Member borrower;
  private final Item item;
  private final int startDay;
  private final int endDay;

  /**
   * Creates a new instance of the contract.
   *
   * @param owner    - the owner of the item.
   * @param item     - the item.
   * @param borrower - the borrower of the item.
   * @param startDay - the start day of the contract.
   * @param endDay   - the end day of the contract.
   */
  public Contract(Member owner, Item item, Member borrower, int startDay, int endDay) {
    this.owner = owner;
    this.item = item;
    this.borrower = borrower;
    this.startDay = startDay;
    this.endDay = endDay;
  }

  /**
   * Gets the borrower.
   *
   * @return - the borrower.
   */
  public Member getBorrower() {
    return borrower;
  }

  /**
   * Gets the owner.
   *
   * @return - the owner.
   */
  public Member getOwner() {
    return owner;
  }

  /**
   * Gets the item.
   *
   * @return - the item.
   */
  public Item getItem() {
    return item;
  }

  /**
   * Gets the start day.
   *
   * @return - the start day.
   */
  public int getStartDay() {
    return startDay;
  }

  /**
   * Gets the end day.
   *
   * @return - the end day.
   */
  public int getEndDay() {
    return endDay;
  }

}
