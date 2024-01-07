package com.controller.model;

/**
 * Represents the main actions of the application.
 */
public enum MainActions implements Actions {
  LISTMEMBERS("listMembers", 'l'),
  LISTMEMBERSDETAIL("listMembersDetail", 'd'),
  ADVANCETIME("time", 'a'),
  UNKNOWN("Unknown", 'u'),
  QUIT("quit", 'x');

  private final String name;
  private final char selector;

  MainActions(String name, char selector) {
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
