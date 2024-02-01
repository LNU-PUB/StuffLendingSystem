package com.model.lib;

import com.model.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Item Repository.
 */
public class ItemRepository {
  private final List<Item> items;

  /**
   * Constructor.
   *
   * @param items - list of items
   */
  public ItemRepository(List<Item> items) {
    this.items = items;
  }

  public List<Item> getItems() {
    return Collections.unmodifiableList(new ArrayList(items));
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
