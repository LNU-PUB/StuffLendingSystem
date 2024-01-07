package com.controller.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MemberActionsTest {
  
  @Test
  public void testGetName() {
    assertEquals("viewMember", MemberActions.VIEWMEMBER.getName());
    assertEquals("addMember", MemberActions.ADDMEMBER.getName());
    assertEquals("editMember", MemberActions.EDITMEMBER.getName());
    assertEquals("deleteMember", MemberActions.DELETEMEMBER.getName());
    assertEquals("membersSimpleList", MemberActions.SIMPLELISTMEMBERS.getName());
    assertEquals("membersDetailedList", MemberActions.DETAILEDLISTMEMBERS.getName());
  }
}
