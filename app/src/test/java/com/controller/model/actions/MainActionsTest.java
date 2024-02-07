package com.controller.model.actions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainActionsTest {

    @Test
    void testGetName() {
        assertEquals("listMembers", MainActions.LISTMEMBERS.getName());
        assertEquals("listMembersDetail", MainActions.LISTMEMBERSDETAIL.getName());
        assertEquals("time", MainActions.ADVANCETIME.getName());
        assertEquals("Unknown", MainActions.UNKNOWN.getName());
        assertEquals("quit", MainActions.QUIT.getName());
    }

    @Test
    void testGetSelector() {
        assertEquals("l", MainActions.LISTMEMBERS.getSelector().trim());
        assertEquals("ld", MainActions.LISTMEMBERSDETAIL.getSelector().trim());
        assertEquals("a", MainActions.ADVANCETIME.getSelector().trim());
        assertEquals("u", MainActions.UNKNOWN.getSelector().trim());
        assertEquals("x", MainActions.QUIT.getSelector().trim());
    }
}
