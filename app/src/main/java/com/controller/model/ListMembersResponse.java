package com.controller.model;

import com.controller.model.Actions.ListMembersActions;

/**
 * Represents the response object from getInput() selection in ListMemberView.
 */
public class ListMembersResponse {
  
  private ListMembersActions action;
  private int index;

  /**
   * Constructor.
   *
   * @param action - the action to be performed.
   * @param index - the index of the member to be acted upon.
   */
  public ListMembersResponse(ListMembersActions action, int index) {
    this.action = action;
    this.index = index;
  }

  public ListMembersActions getAction() {
    return action;
  }

  public int getIndex() {
    return index;
  }
}
