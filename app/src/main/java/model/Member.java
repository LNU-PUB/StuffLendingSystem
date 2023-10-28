package model;

import java.util.LinkedList;

/**
 * Member class represents a Member.
 */
public class Member {
  private String name;
  private String email;
  private String mobile;
  private LinkedList<Item> items;

  /**
   * Member Constructor.
   *
   * @param name - name of member
   * @param email - email of member
   * @param mobile - mobile of member
   */
  public Member(String name, String email, String mobile) {
    this.name = name;
    this.email = email;
    this.mobile = mobile;
    this.items = new LinkedList<Item>();
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getMobile() {
    return mobile;
  }

  public Iterable<Item> getItems() {
    return new LinkedList<Item>(items);
  }
}
