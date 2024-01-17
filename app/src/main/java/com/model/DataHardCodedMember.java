package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The data handler for hard coded members.
 */
public class DataHardCodedMember implements DataHandlerMember {

  @Override
  public List<Member> getMembers() {
    // Create items
    Item item1 = new Item("Item 1", "Tool", "This is a tool", 10.00, 1);
    Item item2 = new Item("Item 2", "Tool", "This is a tool", 10.00, 1);
    Item item3 = new Item("Item 3", "Tool", "This is a tool", 10.00, 1);

    // Create members with items
    Member member1 = new Member("123abc", "John", "john@test.com", "0123121212", new ArrayList<>(Arrays.asList(item1)));
    Member member2 = new Member("456def", "Jane", "jane@test.com", "0123121213", new ArrayList<>(Arrays.asList(item2)));
    Member member3 = new Member("789ghi", "Bob", "bob@test.com", "0123121214", new ArrayList<>(Arrays.asList(item3)));

    // Add members to list
    return new ArrayList<>(Arrays.asList(member1, member2, member3));

  }

  @Override
  public boolean storeMembers(List<Member> members) {
    return true;
  }
}
