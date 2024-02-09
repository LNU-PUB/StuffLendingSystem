package com.controller.model.actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum representing the actions that can be performed on an item.
 */
public enum ItemActions implements Actions {
  EDITITEM("editItem", "e"),
  DELETEITEM("deleteItem", "d"),
  UNKNOWN("unknown", "u"),
  EXIT("exit", "x");

  private final String name;
  private final String selector;

  ItemActions(String name, String selector) {
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
    for (ItemActions action : ItemActions.values()) {
      selectors.add(action.getSelector());
    }
    return selectors;
  }
}
