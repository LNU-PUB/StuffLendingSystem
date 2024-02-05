package com.model.lib;

import com.model.Item;
import java.util.LinkedList;
import java.util.List;

/**
 * Item Repository.
 */
public class ItemRepository implements ItemRepositories {
  private final LinkedList<Item> items;

  /**
   * Constructor.
   *
   * @param items - list of items
   */
  public ItemRepository(List<Item> items) {
    this.items = items == null ? new LinkedList<>() : new LinkedList<Item>(items);
  }

  public Iterable<Item> getItems() {
    return new LinkedList<Item>(items);
  }

  public Item getItemById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getItemById'");
  }

  public Item addNewItem(Item item) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addNewItem'");
  }

  public Item updateItem(Item item) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateItem'");
  }

  public boolean deleteItem(Item item) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteItem'");
  }

}
