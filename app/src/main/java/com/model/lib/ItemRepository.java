package com.model.lib;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.db.DataHandler;
import com.model.db.HardCodedData;
import java.util.LinkedList;
import java.util.List;

/**
 * Item Repository.
 */
public class ItemRepository implements ItemRepositories {
  private final LinkedList<Item> items;
  private final DataHandler dataHandler;
  private final IdGenerator<Item> idGenerator;

  /**
   * Constructor.
   */
  public ItemRepository() {
    this.dataHandler = new HardCodedData();
    this.items = new LinkedList<Item>(dataHandler.getItems());
    this.idGenerator = new IdGenerator<Item>();
  }

  /**
   * Constructor.
   *
   * @param allItems    - all items
   */
  public ItemRepository(Iterable<Item> allItems) {
    this.items = createItemList(allItems);
    this.dataHandler = null;
    this.idGenerator = new IdGenerator<Item>();
  }

  // ***** CRUD operations *****

  private LinkedList<Item> createItemList(Iterable<Item> allItems) {
    LinkedList<Item> items = new LinkedList<Item>();
    for (Item item : allItems) {
      items.add(item);
    }
    return items;
  }

  @Override
  public Iterable<Item> getItems() {
    return new LinkedList<Item>(items);
  }

  @Override
  public Item getItemById(String id) {
    for (Item item : items) {
      if (item.getId().equals(id)) {
        return item;
      }
    }
    return null;
  }

  @Override
  public Item addItem(BasicItemData itemData) {
    if (itemData == null) {
      return null;
    }
    String id = idGenerator.generateId(items); // generates for items list a unique id
    Member owner = itemData.getOwner();
    String name = itemData.getName();
    ItemCategory category = itemData.getCategory();
    String description = itemData.getDescription();
    double costPerDay = itemData.getCostPerDay();
    int creationDay = itemData.getCreationDay();
    Contract currentContract = itemData.getCurrentContract();

    Item newItem = new Item(id, owner, name, category, description, costPerDay, creationDay, currentContract);
    items.add(newItem);
    return new Item(newItem);
  }

  @Override
  public Item updateItem(Item item) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateItem'");
  }

  @Override
  public boolean deleteItem(Item item) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteItem'");
  }

  @Override
  public Iterable<Item> getItemsByMember(Member member) {
    LinkedList<Item> memberItems = new LinkedList<Item>();
    for (Item item : items) {
      if (item.getOwner().equals(member) || member.getId().equals(item.getOwner().getId())) {
        memberItems.add(item);
      }
    }

    return memberItems;
  }

  @Override
  public List<Item> getItemsByCategory(ItemCategory category) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getItemsByCategory'");
  }

  @Override
  public Item getItemByContract(Contract contract) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getItemByContract'");
  }

  @Override
  public List<Item> getItemsByStatus(ItemStatus status) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getItemsByStatus'");
  }

  // ***** Validation operations *****

  /**
   * Contains the rules for validating the item name.
   *
   * @param name - name to validate
   * @return - true if valid, false otherwise
   */
  @Override
  public boolean validateName(String name) {
    // Rules: 1. Name cannot be null. 
    //        2. Name must be at least 1 character long.
    return name != null && name.length() > 0;
  }

  @Override
  public boolean validateDescription(String description) {
    // Rules: 1. Description cannot be null.
    //        2. Description must not be empty.
    return description != null && !description.isEmpty();
  }

  /**
   * Contains the rules for validating the cost per day.
   *
   * @param costPerDay - cost per day to validate
   * @return - true if valid, false otherwise
   */
  @Override
  public boolean validateCostPerDay(double costPerDay) {
    // Rules: 1. cost per day must not be negative.
    return !(costPerDay < 0);
  }
}
