package com.controller.model;

import org.junit.jupiter.api.Test;

import com.controller.model.Actions.MainActions;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals('l', MainActions.LISTMEMBERS.getSelector());
        assertEquals('d', MainActions.LISTMEMBERSDETAIL.getSelector());
        assertEquals('a', MainActions.ADVANCETIME.getSelector());
        assertEquals('u', MainActions.UNKNOWN.getSelector());
        assertEquals('x', MainActions.QUIT.getSelector());
    }
}
