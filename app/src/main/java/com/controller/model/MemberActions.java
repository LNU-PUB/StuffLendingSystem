package com.controller.model;

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
  EXIT("exitMembers", 'x');

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
}
