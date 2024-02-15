package com.model.db;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.Transaction;
import com.model.lib.ItemCategory;
import java.util.ArrayList;
import java.util.List;

/**
 * Data handler for members.
 */
public class HardCodedData implements DataHandler {

  // Members
  Member johnDoe = new Member("123abc", "John Doe", "jon@doe.sss", "12345678", 0);
  Member janeDoe = new Member("456def", "Jane Doe", "jane@doe.sss", "87654321", 1);
  Member alexSmith = new Member("789ghi", "Alex Smith", "alex@smith.sss", "11223344", 0);

  Item hammer = new Item("abc123", johnDoe, "Hammer", ItemCategory.TOOL, "A hammer", 1.0, 1, null);
  Item screwdriver = new Item("aaa741", johnDoe, "Screwdriver", ItemCategory.TOOL, "A screwdriver", 1.0, 1, null);
  Item drill = new Item("def456", janeDoe, "Drill", ItemCategory.TOOL, "A drill", 1.0, 1, null);
  Item saw = new Item("ghi789", johnDoe, "Saw", ItemCategory.TOOL, "A saw", 1.0, 1, null);

  @Override
  public List<Member> getMembers() {

    // List of members
    List<Member> members = new ArrayList<>();
    members.add(johnDoe);
    members.add(janeDoe);
    members.add(alexSmith);

    return members;
  }

  @Override
  public List<Item> getItems() {
    // Items for John and Jane Doe

    // List of items
    List<Item> items = new ArrayList<>();
    items.add(hammer);
    items.add(drill);
    items.add(saw);
    items.add(screwdriver);
    return items;
  }

  @Override
  public List<Contract> getContracts() {
    Contract contract = new Contract("aaa111", johnDoe, janeDoe, hammer, 1, 4);
    Contract contract2 = new Contract("aaa222", janeDoe, johnDoe, drill, 2, 5);
    Contract contract3 = new Contract("aaa333", johnDoe, alexSmith, saw, 3, 6);
    Contract contract4 = new Contract("aaa123", johnDoe, alexSmith, hammer, 6, 7);

    // List of contracts
    List<Contract> contracts = new ArrayList<>();
    contracts.add(contract);
    contracts.add(contract2);
    contracts.add(contract3);
    contracts.add(contract4);
    return contracts;
  }

  @Override
  public List<Transaction> getTransactions() {
    // Create  an initial amount of credits for each member of 200.
    Transaction transaction = new Transaction("ccc123", johnDoe, 200, johnDoe.getMemberCreationDay());
    Transaction transaction2 = new Transaction("ccc124", janeDoe, 200, janeDoe.getMemberCreationDay());
    Transaction transaction3 = new Transaction("ccc125", alexSmith, 200, alexSmith.getMemberCreationDay());

    // List of transactions
    List<Transaction> transactions = new ArrayList<>();
    transactions.add(transaction);
    transactions.add(transaction2);
    transactions.add(transaction3);

    return transactions;
  }

  @Override
  public boolean storeMembers(List<Member> members) {
    // Implementation to store members
    return true; // only for development.
  }

  @Override
  public boolean storeItems(List<Item> items) {
    // Implementation to store items
    return true; // only for development.
  }

  @Override
  public boolean storeContracts(List<Contract> contracts) {
    // Implementation to store contracts
    return true; // only for development.
  }
}
