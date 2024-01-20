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
  private List<Item> items;

  /**
   * Constructor.
   *
   * @param id - unique id
   * @param name - name
   * @param email - email
   * @param mobile - mobile
   * @param items - items
   */
  public Member(String id, String name, String email, String mobile, List<Item> items) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.mobile = mobile;
    this.items = new ArrayList<>(items);
  }

  /**
   * Constructor.
   *
   * @param member - The member to copy.
   */
  public Member(Member member) {
    this.id = member.getId();
    this.name = member.getName();
    this.email = member.getEmail();
    this.mobile = member.getMobile();
    this.items = new ArrayList<>();
    for (Item item : member.getItems()) {
      this.items.add(new Item(item));
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
}
