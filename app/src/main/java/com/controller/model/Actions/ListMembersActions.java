package com.controller.model.actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the actions that can be performed on a member.
 */
public enum ListMembersActions implements Actions {
  ADDMEMBER("addMember", "a"),
  SELECTEDMEMBER("selectedMember", "s"),
  UNKNOWN("unknown", "u"),
  EXIT("exit", "x");

  private final String name;
  private final String selector;

  ListMembersActions(String name, String selector) {
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
    for (ListMembersActions action : ListMembersActions.values()) {
      selectors.add(action.getSelector());
    }
    return selectors;
  }
}
