package com.controller.model.actions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ListItemsActionsTest {

  @Test
  void testGetName() {
    assertEquals("addItem", ListItemsActions.ADDITEM.getName());
    assertEquals("selectedItem", ListItemsActions.SELECTEDITEM.getName());
    assertEquals("unknown", ListItemsActions.UNKNOWN.getName());
    assertEquals("exit", ListItemsActions.EXIT.getName());
  }

  @Test
  void testGetSelector() {
    assertEquals("a", ListItemsActions.ADDITEM.getSelector().trim());
    assertEquals("s", ListItemsActions.SELECTEDITEM.getSelector().trim());
    assertEquals("u", ListItemsActions.UNKNOWN.getSelector().trim());
    assertEquals("x", ListItemsActions.EXIT.getSelector().trim());
  }
}
