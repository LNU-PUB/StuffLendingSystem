package com.controller.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MemberActionsTest {
  
  @Test
  public void testGetName() {
    assertEquals("View Member", MemberActions.VIEWMEMBER.getName());
    assertEquals("Add Member", MemberActions.ADDMEMBER.getName());
    assertEquals("Edit Member", MemberActions.EDITMEMBER.getName());
    assertEquals("Delete Member", MemberActions.DELETEMEMBER.getName());
    assertEquals("Members Simple List", MemberActions.SIMPLELISTMEMBERS.getName());
    assertEquals("Members Detailed List", MemberActions.DETAILEDLISTMEMBERS.getName());
  }
}
