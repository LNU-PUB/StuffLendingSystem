package com.controller.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the actions that can be performed on a member.
 */
public enum MemberActions implements Actions {
  VIEWMEMBER("viewMember", 'v'),
  ADDMEMBER("addMember", 'a'),
  EDITMEMBER("editMember", 'e'),
  DELETEMEMBER("deleteMember", 'd'),
  SIMPLELISTMEMBERS("membersSimpleList", 's'),
  DETAILEDLISTMEMBERS("membersDetailedList", 'l'),
  UNKNOWN("unknown", 'u'),
  EXIT("exit", 'x');

  private final String name;
  private final char selector;

  MemberActions(String name, char selector) {
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
    for (MemberActions action : MemberActions.values()) {
      selectors.add(action.getSelector());
    }
    return selectors;
  }
}
