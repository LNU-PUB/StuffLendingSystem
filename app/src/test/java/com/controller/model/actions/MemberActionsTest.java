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
    assertEquals("unknown", MemberActions.UNKNOWN.getName());
    assertEquals("exit", MemberActions.EXIT.getName());
  }

  @Test
  public void testGetSelector() {
    assertEquals('e', MemberActions.EDITMEMBER.getSelector());
    assertEquals('d', MemberActions.DELETEMEMBER.getSelector());
    assertEquals('c', MemberActions.ADDCREDITS.getSelector());
    assertEquals('n', MemberActions.NEWCONTRACT.getSelector());
    assertEquals('l', MemberActions.LISTITEMS.getSelector());
    assertEquals('u', MemberActions.UNKNOWN.getSelector());
    assertEquals('x', MemberActions.EXIT.getSelector());
  }
}
