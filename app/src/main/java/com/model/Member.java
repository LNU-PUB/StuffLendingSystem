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

    public Member(String id, String name, String email, String mobile, List<Item> items) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.items = items;
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
      return new ArrayList<>(this.items);
    }
}
