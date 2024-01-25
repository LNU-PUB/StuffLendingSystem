package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a member.
 */
public class Member {
  private String id;
  private String name;
  private String email;
  private String mobile;
  private int credits;
  private final int memberCreationDay;
  private List<Item> items;
  private List<Contract> contracts;

  /**
   * Constructor.
   *
   * @param id     - unique id
   * @param name   - name
   * @param email  - email
   * @param mobile - mobile
   * @param items  - items
   */
  public Member(String id, String name, String email, String mobile, List<Item> items, int creationDay, int credits) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.mobile = mobile;
    this.items = new ArrayList<>(items);
    this.contracts = new ArrayList<>();
    this.memberCreationDay = creationDay;
    this.credits = credits;
  }

  /**
   * Constructor.
   *
   * @param member - The member to create a deep copy of.
   */
  public Member(Member member) {
    this.id = member.getId();
    this.name = member.getName();
    this.email = member.getEmail();
    this.mobile = member.getMobile();
    this.credits = member.getCredits();
    this.memberCreationDay = member.getMemberCreationDay();
    this.items = new ArrayList<>();
    for (Item item : member.getItems()) {
      this.items.add(new Item(item));
    }
  }

  public void addContract(Contract contract) {
    this.contracts.add(contract);
  }

  public List<Contract> getContracts() {
    return this.contracts;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getMemberCreationDay() {
    return memberCreationDay;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getMobile() {
    return this.mobile;
  }

  public List<Item> getItems() {
    return (List<Item>) new ArrayList<>(this.items);
  }

  public void addCredits(int credits) {
    this.credits += credits;
  }

  public void deductCredits(int credits) {
    this.credits -= credits;
  }

  public int getCredits() {
    return this.credits;
  }

  public int getNumberOfItems() {
    return items.size();
  }
}
