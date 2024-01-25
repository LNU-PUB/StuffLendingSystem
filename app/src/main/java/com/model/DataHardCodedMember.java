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
    // Creating items for John Doe
    Item hammer = new Item("Hammer", "Tools", "A hammer", 1.0, 1);
    Item screwdriver = new Item("Screwdriver", "Tools", "A screwdriver", 1.0, 1);
    List<Item> johnItems = new ArrayList<>();
    johnItems.add(hammer);
    johnItems.add(screwdriver);

    // Creating member John Doe
    Member johnDoe = new Member("123abc", "John Doe", "jon@doe.sss", "12345678", johnItems, 0, 100);

    // Creating items for Jane Doe
    Item drill = new Item("Drill", "Tools", "A drill", 1.0, 1);
    Item saw = new Item("Saw", "Tools", "A saw", 1.0, 1);
    List<Item> janeItems = new ArrayList<>();
    janeItems.add(drill);
    janeItems.add(saw);

    // Creating member Jane Doe
    Member janeDoe = new Member("456def", "Jane Doe", "jane@doe.sss", "87654321", janeItems, 1, 201);

    // Creating member Alex Smith with no items
    Member alexSmith = new Member("789ghi", "Alex Smith", "alex@smith.sss", "11223344", new ArrayList<>(), 0, 50);

    // Creating contracts
    Contract contract = new Contract(johnDoe, hammer, janeDoe, 1, 2);

    // Assigning the contract to the item and the members
    hammer.setCurrentContract(contract);
    johnDoe.addContract(contract);
    janeDoe.addContract(contract);

    // Adding members to the list
    List<Member> members = new ArrayList<>();
    members.add(johnDoe);
    members.add(janeDoe);
    members.add(alexSmith);

    return members;
  }

  @Override
  public boolean storeMembers(List<Member> members) {
    return true;
  }
}
