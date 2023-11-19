package model;

import java.util.LinkedList;
import model.lib.RentalPeriod;

/**
 * Contract class represents a Contract.
 */
public class Contract {
  private final Member member;
  private final Item item;
  private final LinkedList<RentalPeriod> rentalPeriods;

  /**
   * Contract Constructor.
   *
   * @param member - member of contract
   * @param item - item of contract
   * @param rentalPeriod - period of contract
   */
  public Contract(Member member, Item item, RentalPeriod rentalPeriod) {
    this.member = new Member(member);
    this.item = item;
    this.rentalPeriods = new LinkedList<RentalPeriod>();
    addPeriod(rentalPeriod);
  }

  public void addPeriod(RentalPeriod period) {
    RentalPeriod newPeriod = new RentalPeriod(period.startDay(), period.endDay());
    this.rentalPeriods.add(newPeriod);
  }

  public Member getMember() {
    return new Member(member);
  }

  public Item getItem() {
    return item;
  }

  public Iterable<RentalPeriod> getPeriod() {
    return new LinkedList<RentalPeriod>(rentalPeriods);
  }
}
