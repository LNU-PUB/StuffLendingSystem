package com.model.lib;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import java.util.List;


// We should provide methods to retrieve items based on on Member, Category, Status, and Contract.
// 
/**
 * Item Service interface.
 */
public interface ItemServices {
  /**
   * Get a list of all Items.
   *
   * @return - list of all Items.
   */
  public Iterable<Item> getAllItems();

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
   * Delete an Item.
   *
   * @param item - item to delete.
   * @return - true if deleted, false otherwise.
   */
  public boolean delete(Item item);

  /**
   * Get a list of all of a member's items.
   *
   * @param member - member to get items for.
   * @return - list of items for member.
   */
  public List<Item> getItemsByMember(Member member);

  /**
   * Get a list of all items in a category.
   *
   * @param category - category to get items for.
   * @return - list of items in category.
   */
  public List<Item> getItemsByCategory(ItemCategory category);

  /**
   * Get the Item that is rented in this contract.
   *
   * @param contract - contract to get the item for.
   * @return - list of items in contract.
   */
  public Item getItemByContract(Contract contract);

  /**
   * Get a list of all items with a given status.
   *
   * @param status - status to get items for.
   * @return - list of items with status.
   */
  public List<Item> getItemsByStatus(ItemStatus status);
}
