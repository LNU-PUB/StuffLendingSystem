package com.controller.model;

/**
 * Represents the actions that can be performed on a member.
 */
public enum ListMembersActions implements Actions {
  ADDMEMBER("addMember", 'a'),
  SELECTEDMEMBER("selectedMember", 's'),
  UNKNOWN("unknown", '0'),
  EXIT("exit", 'x');

  private final String name;
  private final char selector;

  ListMembersActions(String name, char selector) {
    this.name = name;
    this.selector = selector;
  }

  public String getName() {
    return name;
  }

  public char getSelector() {
    return selector;
  }
}
