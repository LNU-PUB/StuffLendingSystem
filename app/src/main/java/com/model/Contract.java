package com.model;

public class Contract {
  private final Member owner;
  private final Member borrower;
  private final Item item;
  private final int startDay;
  private final int endDay;

  public Contract(Member owner, Item item, Member borrower, int startDay, int endDay) {
    this.owner = owner;
    this.item = item;
    this.borrower = borrower;
    this.startDay = startDay;
    this.endDay = endDay;
  }

  public Member getBorrower() {
    return borrower;
  }

  public Member getOwner() {
    return owner;
  }

  public Item getItem() {
    return item;
  }

  public int getStartDay() {
    return startDay;
  }

  public int getEndDay() {
    return endDay;
  }
  
}
