package com.controller.model.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MemberActionsTest {
  
  @Test
  public void testGetName() {
    assertEquals("editMember", MemberActions.EDITMEMBER.getName());
    assertEquals("deleteMember", MemberActions.DELETEMEMBER.getName());
    assertEquals("addCredits", MemberActions.ADDCREDITS.getName());
    assertEquals("newContract", MemberActions.NEWCONTRACT.getName());
    assertEquals("listItems", MemberActions.LISTITEMS.getName());
    assertEquals("listAllItems", MemberActions.LISTALLITEMS.getName());
    assertEquals("unknown", MemberActions.UNKNOWN.getName());
    assertEquals("exit", MemberActions.EXIT.getName());
  }

  @Test
  public void testGetSelector() {
    assertEquals("e", MemberActions.EDITMEMBER.getSelector().trim());
    assertEquals("d", MemberActions.DELETEMEMBER.getSelector().trim());
    assertEquals("ac", MemberActions.ADDCREDITS.getSelector().trim());
    assertEquals("nc", MemberActions.NEWCONTRACT.getSelector().trim());
    assertEquals("l", MemberActions.LISTITEMS.getSelector().trim());
    assertEquals("la", MemberActions.LISTALLITEMS.getSelector().trim());
    assertEquals("u", MemberActions.UNKNOWN.getSelector().trim());
    assertEquals("x", MemberActions.EXIT.getSelector().trim());
  }
}
