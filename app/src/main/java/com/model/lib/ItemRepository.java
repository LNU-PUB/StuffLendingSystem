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

  /**
   * Constructor.
   */
  public ItemRepository() {
    this.dataHandler = new HardCodedData();
    this.items = new LinkedList<Item>(dataHandler.getItems());
  }

  /**
   * Constructor.
   *
   * @param allItems    - all items
   */
  public ItemRepository(Iterable<Item> allItems) {
    this.items = createItemList(allItems);
    this.dataHandler = null;
  }

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
  public Item addItem(Item item) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addNewItem'");
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
}
