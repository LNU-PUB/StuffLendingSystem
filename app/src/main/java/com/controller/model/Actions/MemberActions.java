package com.controller.model.actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the actions that can be performed on a member.
 */
public enum MemberActions implements Actions {
  EDITMEMBER("editMember", "e "),
  DELETEMEMBER("deleteMember", "d "),
  ADDCREDITS("addCredits", "ac"),
  NEWCONTRACT("newContract", "nc"),
  LISTITEMS("listItems", "l "),
  LISTALLITEMS("listAllItems", "la"),
  UNKNOWN("unknown", "u "),
  EXIT("exit", "x ");

  private final String name;
  private final String selector;

  MemberActions(String name, String selector) {
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
    for (MemberActions action : MemberActions.values()) {
      selectors.add(action.getSelector());
    }
    return selectors;
  }
}
