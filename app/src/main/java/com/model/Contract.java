package com.model;

import com.model.lib.Identifiable;
import java.util.Objects;

/**
 * A contract between a member and the stuff lending system.
 */
public final class Contract implements Identifiable {
  private final Member owner;
  private final Member borrower;
  private final Item item;
  private final int startDay;
  private final int endDay;
  private final String id;

  /**
   * Creates a new Contract object.
   *
   * @param id       - contract id.
   * @param owner    - the member who owns the item.
   * @param item     - the item that is lent.
   * @param borrower - the member borrowing the item.
   * @param startDay - contract starting day.
   * @param endDay   - contract ending day.
   */
  public Contract(String id, Member owner, Member borrower, Item item, int startDay, int endDay) {
    this.owner = owner;
    this.item = item;
    this.borrower = borrower;
    this.startDay = startDay;
    this.endDay = endDay;
    this.id = id;
  }

  /**
   * Creates a new instance of the contract.
   *
   * @param contract - the contract to create a deep copy of.
   */
  public Contract(Contract contract) {
    this.id = contract.getId();
    this.owner = contract.getOwner();
    this.item = contract.getItem();
    this.borrower = contract.getBorrower();
    this.startDay = contract.getStartDay();
    this.endDay = contract.getEndDay();
  }

  @Override
  public String getId() {
    return id;
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
   * Gets the borrower.
   *
   * @return - the borrower.
   */
  public Member getBorrower() {
    return borrower;
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

  @Override
  public String toString() {
    return "Contract{"
        + "id='" + getId() + '\''
        + ", owner=" + getOwner().getName()
        + ", borrower=" + getBorrower().getName()
        + ", item=" + getItem().getName()
        + ", startDay=" + getStartDay()
        + ", endDay=" + getEndDay()
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Contract contract = (Contract) o;

    return startDay == contract.startDay
        && endDay == contract.endDay
        && Objects.equals(id, contract.id)
        && Objects.equals(owner, contract.owner)
        && Objects.equals(borrower, contract.borrower)
        && Objects.equals(item, contract.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, owner, borrower, item, startDay, endDay);
  }

}
