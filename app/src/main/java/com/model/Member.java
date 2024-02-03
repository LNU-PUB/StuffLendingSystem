package com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents a member.
 */
public class Member {
  private final String id;
  private final String name;
  private final String email;
  private final String mobile;
  private final int memberCreationDay;

  /**
   * Constructor.
   *
   * @param id     - unique id
   * @param name   - name
   * @param email  - email
   * @param mobile - mobile
   * @param items  - items
   */
  public Member(String id, String name, String email, String mobile, int creationDay) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.mobile = mobile;
    this.memberCreationDay = creationDay;
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
    this.memberCreationDay = member.getMemberCreationDay();
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
}
