package com.model.lib;

import com.model.Item;

/**
 * The item repositories interface.
 */
public interface ItemRepositories {
  /**
   * Gets all items.
   *
   * @return - the list of items.
   */
  public Iterable<Item> getItems();

  /**
   * Gets an item by its id.
   *
   * @param id - the item id.
   * @return - the item.
   */
  public Item getItemById(String id);

  /**
   * Adds a new item.
   *
   * @param item - the item to add.
   * @return - the added item.
   */
  public Item addNewItem(Item item);

  /**
   * Updates an item.
   *
   * @param item - the item to update.
   * @return - the updated item.
   */
  public Item updateItem(Item item);

  /**
   * Deletes an item.
   *
   * @param item - the item to delete.
   * @return - true if the item was deleted, false otherwise.
   */
  public boolean deleteItem(Item item);
}
