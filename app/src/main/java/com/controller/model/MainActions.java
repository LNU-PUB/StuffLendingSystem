package com.controller.model;

/**
 * Represents the main actions of the application.
 */
public enum MainActions implements Actions {
  MEMBER("member", 'm'),
  NEWCONTRACT("newContract", 'n'),
  ADVANCETIME("time", 'a'),
  UNKNOWN("Unknown", 'u'),
  QUIT("quit", 'q');

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
