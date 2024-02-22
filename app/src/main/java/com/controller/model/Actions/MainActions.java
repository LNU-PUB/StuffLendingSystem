package com.controller.model.actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the main actions of the application.
 */
public enum MainActions {
  LISTMEMBERS("listMembers", "l "),
  LISTMEMBERSDETAIL("listMembersDetail", "ld"),
  ADVANCETIME("time", "a "),
  UNKNOWN("Unknown", "u "),
  QUIT("quit", "x ");

  private final String name;
  private final String selector;

  /**
   * Creates a new instance of the enum.
   *
   * @param name     - the name of the action.
   * @param selector - the selector for the action.
   */
  MainActions(String name, String selector) {
    this.name = name;
    this.selector = selector;
  }

  /**
   * Returns the action for the given selector.
   *
   * @return the action name.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the selector for the action.
   *
   * @return the selector for the action.
   */
  public String getSelector() {
    return selector;
  }

  /**
   * Returns a list of valid selectors.
   *
   * @return a list of valid selectors.
   */
  public List<String> getValidSelectors() {
    List<String> selectors = new ArrayList<>();
    for (MainActions action : MainActions.values()) {
      selectors.add(action.getSelector());
    }
    return selectors;
  }
}
