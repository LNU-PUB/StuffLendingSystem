package com.controller.model;

/**
 * The type of list to show.
 */
public enum MembersListType {
  LIST("Simple List Members", 'l'),
  DETAILED("Detailed List Members", 'd');

  private final String name;
  private final char selector;

  MembersListType(String name, char selector) {
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
