package com.model.lib;

import com.model.Item;
import java.util.List;

/**
 * Item Service interface.
 */
public interface ItemServices {
  /**
   * Get a list of all Items.
   *
   * @return - list of all Items.
   */
  public List<Item> getAllItems();

  /**
   * Get an Item by id.
   *
   * @param id - id for Item
   * @return - Item
   */
  public Item getById(String id);

  /**
   * Add a new Item.
   *
   * @param item - data for new Item
   * @return - new Item
   */
  public Item addItem(Item item);

  /**
   * Update an Item.
   *
   * @param item - item to update.
   * @return - updated item
   */
  public Item updateItem(Item item);

  /**
   * Delete an item <Item>.
   *
   * @param item - item to delete.
   * @return - true if deleted, false otherwise.
   */
  public boolean delete(Item item);
}
