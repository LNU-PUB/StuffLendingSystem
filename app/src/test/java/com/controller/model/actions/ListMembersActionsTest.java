package com.controller.model.actions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ListMembersActionsTest {
  
  @Test
  public void testGetName() {
    assertEquals("addMember", ListMembersActions.ADDMEMBER.getName());
    assertEquals("selectedMember", ListMembersActions.SELECTEDMEMBER.getName());
    assertEquals("unknown", ListMembersActions.UNKNOWN.getName());
    assertEquals("exit", ListMembersActions.EXIT.getName());
  }

  @Test
  public void testGetSelector() {
    assertEquals("a", ListMembersActions.ADDMEMBER.getSelector().trim());
    assertEquals("s", ListMembersActions.SELECTEDMEMBER.getSelector().trim());
    assertEquals("u", ListMembersActions.UNKNOWN.getSelector().trim());
    assertEquals("x", ListMembersActions.EXIT.getSelector().trim());
  }
}
