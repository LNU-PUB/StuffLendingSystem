package com.controller.model.actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the main actions of the application.
 */
public enum MainActions implements Actions {
  LISTMEMBERS("listMembers", "l "),
  LISTMEMBERSDETAIL("listMembersDetail", "ld"),
  ADVANCETIME("time", "a "),
  UNKNOWN("Unknown", "u "),
  QUIT("quit", "x ");

  private final String name;
  private final String selector;

  MainActions(String name, String selector) {
    this.name = name;
    this.selector = selector;
  }

  public String getName() {
    return name;
  }

  public String getSelector() {
    return selector;
  }

  @Override
  public List<String> getValidSelectors() {
    List<String> selectors = new ArrayList<>();
    for (MainActions action : MainActions.values()) {
      selectors.add(action.getSelector());
    }
    return selectors;
  }
}
