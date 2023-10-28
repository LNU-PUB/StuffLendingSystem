package model;

import java.util.LinkedList;

public class Member {
  private String name;
  private String email;
  private String mobile;
  private LinkedList<Item> items;

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
    return items;
  }
}
