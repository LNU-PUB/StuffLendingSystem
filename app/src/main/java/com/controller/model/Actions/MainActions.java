package com.controller.model.actions;

import java.util.ArrayList;
import java.util.List;

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

  @Override
  public List<Character> getValidSelectors() {
    List<Character> selectors = new ArrayList<>();
    for (MainActions action : MainActions.values()) {
      selectors.add(action.getSelector());
    }
    return selectors;
  }
}
