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
   * @param allItems - all items
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

    if (!validateName(itemData.getName())) {
      return null;
    }

    if (!validateDescription(itemData.getDescription())) {
      return null;
    }

    if (!validateCostPerDay(itemData.getCostPerDay())) {
      return null;
    }

    synchronized (this) {
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
  }

  @Override
  public Item updateItem(BasicItemData newItem, Item item) {
    final String name = newItem.getName();
    final ItemCategory category = newItem.getCategory();
    final String description = newItem.getDescription();
    final double costPerDay = newItem.getCostPerDay();

    if (!name.equals(item.getName())) {
      if (!validateName(name)) {
        return null;
      }
    }

    if (!description.equals(item.getDescription())) {
      if (!validateDescription(description)) {
        return null;
      }
    }

    if (costPerDay != item.getCostPerDay()) {
      if (!validateCostPerDay(costPerDay)) {
        return null;
      }
    }

    synchronized (this) {
      final String id = item.getId();
      final Member owner = item.getOwner();
      final int creationDay = item.getCreationDay();
      final Contract currentContract = item.getCurrentContract();

      Item updatedItem = new Item(id, owner, name, category, description, costPerDay, creationDay, currentContract);
      replaceItemInList(item, updatedItem);

      return new Item(updatedItem);
    }
  }

  @Override
  public boolean deleteItem(Item itemToDelete) {
    if (itemToDelete == null) {
      return false;
    }
    
    synchronized (this) {
      for (Item item : items) {
        if (item == itemToDelete || item.getId().equals(itemToDelete.getId())) {
          items.remove(item);
          return true;
        }
      }
    }
    return false;
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
    // Rules: 1. Name cannot be null or empty.
    // 2. Name must be at least 3 character long.
    // 3. Name must be unique within items.
    if (name == null || name.isEmpty()) {
      return false;
    }

    if (name.length() < 3) {
      return false;
    }

    return isUniqueName(name);
  }

  @Override
  public boolean validateDescription(String description) {
    // Rules: 1. Description cannot be null.
    // 2. Description must not be empty.
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

  // ***** Helper functions *****

  private boolean isUniqueName(String name) {
    for (Item item : items) {
      if (item.getName().equals(name)) {
        return false;
      }
    }
    return true;
  }

  private void replaceItemInList(Item item, Item updatedItem) {
    for (int i = 0; i < items.size(); i++) {
      if (items.get(i).getId().equals(item.getId())) {
        items.set(i, updatedItem);
        return;
      }
    }
  }
}
