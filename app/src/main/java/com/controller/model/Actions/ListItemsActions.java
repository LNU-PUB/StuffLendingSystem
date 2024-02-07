package com.controller.model.actions;

import java.util.ArrayList;
import java.util.List;

/**
 * The actions for the list items control.
 */
public enum ListItemsActions implements Actions {
  ADDITEM("addItem", "a"),
  SELECTEDITEM("selectedItem", "s"),
  UNKNOWN("unknown", "u"),
  EXIT("exit", "x");

  private final String name;
  private final String selector;

  ListItemsActions(String name, String selector) {
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
    for (ListItemsActions action : ListItemsActions.values()) {
      selectors.add(action.getSelector());
    }
    return selectors;
  }
}
