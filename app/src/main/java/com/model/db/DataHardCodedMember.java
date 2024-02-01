package com.model.db;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Data handler for members.
 */
public class DataHardCodedMember implements DataHandlerMember {

  @Override
  public List<Member> getMembers() {
    // Items for John and Jane Doe
    Item hammer = new Item("Hammer", "Tools", "A hammer", 1.0, 1, null);
    // Item screwdriver = new Item("Screwdriver", "Tools", "A screwdriver", 1.0, 1,
    // null);
    Item drill = new Item("Drill", "Tools", "A drill", 1.0, 1, null);
    // Item saw = new Item("Saw", "Tools", "A saw", 1.0, 1, null);

    // Members
    Member johnDoe = new Member("123abc", "John Doe", "jon@doe.sss", "12345678",
        Collections.singletonList(hammer), 0, 100);
    Member janeDoe = new Member("456def", "Jane Doe", "jane@doe.sss", "87654321",
        Collections.singletonList(drill), 1, 201);

    // Contract (assuming start and end day are integers representing some time
    // unit)
    Contract contract = new Contract(johnDoe, hammer, janeDoe, 1, 2);

    // Updating the Item instances with the contract
    Item updatedHammer = new Item("Hammer", "Tools", "A hammer", 1.0, 1, contract);

    // Updating the Member instances with the updated items and contracts
    List<Item> johnItems = new ArrayList<>();
    johnItems.add(updatedHammer);
    List<Contract> johnContracts = new ArrayList<>();
    johnContracts.add(contract);
    johnDoe = new Member("123abc", "John Doe", "jon@doe.sss", "12345678",
        johnItems, 0, 100, johnContracts);

    Item updatedDrill = new Item("Drill", "Tools", "A drill", 1.0, 1, null);
    List<Item> janeItems = new ArrayList<>();
    janeItems.add(updatedDrill);
    List<Contract> janeContracts = new ArrayList<>();
    janeContracts.add(contract);
    janeDoe = new Member("456def", "Jane Doe", "jane@doe.sss", "87654321",
        janeItems, 1, 201, janeContracts);

    // Member Alex Smith with no items
    Member alexSmith = new Member("789ghi", "Alex Smith",
        "alex@smith.sss", "11223344", Collections.emptyList(),
        0, 50, Collections.emptyList());

    // List of members
    List<Member> members = new ArrayList<>();
    members.add(johnDoe);
    members.add(janeDoe);
    members.add(alexSmith);

    return members;
  }

  @Override
  public boolean storeMembers(List<Member> members) {
    // Implementation to store members
    return true;
  }
}
