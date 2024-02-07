package com.controller.model.actions;

/**
 * The actions for the list items control.
 */
public enum ListItemsActions {
  ADDITEM("addItem", 'a'),
  SELECTEDITEM("selectedItem", 's'),
  UNKNOWN("unknown", 'u'),
  EXIT("exit", 'x');

  private final String name;
  private final char selector;

  ListItemsActions(String name, char selector) {
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
