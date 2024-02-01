package com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a member.
 */
public class Member {
  private final String id;
  private final String name;
  private final String email;
  private final String mobile;
  private final int credits;
  private final int memberCreationDay;
  private final List<Item> items;
  private final List<Contract> contracts;

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
    this.items = items != null ? new ArrayList<>(items) : Collections.emptyList();
    this.contracts = new ArrayList<>();
    this.memberCreationDay = creationDay;
    this.credits = credits;
  }

  /**
   * Constructor.
   *
   * @param id           - unique id
   * @param name         - name
   * @param email        - email
   * @param mobile       - mobile
   * @param items        - items
   * @param contractList - contracts
   */
  public Member(String id, String name, String email, String mobile, List<Item> items,
      int creationDay, int credits, List<Contract> contractList) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.mobile = mobile;
    this.items = items != null ? new ArrayList<>(items) : Collections.emptyList();
    this.contracts = contractList != null ? new ArrayList<>(contractList) : Collections.emptyList();
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
    this.contracts = new ArrayList<>();
    for (Contract contract : member.getContracts()) {
      this.contracts.add(new Contract(contract));
    }
  }

  public List<Contract> getContracts() {
    return Collections.unmodifiableList(contracts);
  }

  public String getId() {
    return id;
  }

  public int getMemberCreationDay() {
    return memberCreationDay;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getMobile() {
    return this.mobile;
  }

  public List<Item> getItems() {
    return Collections.unmodifiableList(items);
  }

  public int getCredits() {
    return this.credits;
  }

  public int getNumberOfItems() {
    return items.size();
  }
}
