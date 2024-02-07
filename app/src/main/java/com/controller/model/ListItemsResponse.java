package com.controller.model;

import com.controller.model.actions.ListItemsActions;

/**
 * The response to a list items control.
 */
public class ListItemsResponse {
  private ListItemsActions action;
  private int index;

  /**
   * Constructor.
   *
   * @param action - the action to be performed.
   * @param index - the index of the member to be acted upon.
   */
  public ListItemsResponse(ListItemsActions action, int index) {
    this.action = action;
    this.index = index;
  }

  public ListItemsActions getAction() {
    return action;
  }

  public int getIndex() {
    return index;
  }
}
