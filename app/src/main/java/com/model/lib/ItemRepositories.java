package com.model.lib;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import java.util.List;

/**
 * The item repositories interface.
 */
public interface ItemRepositories {
  // ***** CRUD operations *****

  /**
   * Get a list of all Items.
   *
   * @return - list of all Items.
   */
  public Iterable<Item> getItems();

  /**
   * Get an Item by id.
   *
   * @param id - id for Item
   * @return - Item
   */
  public Item getItemById(String id);

  /**
   * Add a new Item.
   *
   * @param itemData - data for new item.
   * @return - new item
   */
  public Item addItem(BasicItemData itemData);

  /**
   * Update an Item.
   *
   * @param item - item to update.
   * @return - updated item
   */
  public Item updateItem(BasicItemData newItem, Item item);

  /**
   * Delete an Item.
   *
   * @param item - item to delete.
   * @return - true if deleted, false otherwise.
   */
  public boolean deleteItem(Item item);

  /**
   * Get a list of all of a member's items.
   *
   * @param member - member to get items for.
   * @return - list of items for member.
   */
  public Iterable<Item> getItemsByMember(Member member);

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

  // ***** Validation operations *****

  /**
   * Validate item name.
   *
   * @param name - name to validate
   * @return - true if valid, false otherwise
   */
  public boolean validateName(String name);

  /**
   * Validate item description.
   *
   * @param description - description to validate
   * @return - true if valid, false otherwise
   */
  public boolean validateDescription(String description);

  /**
   * Validate cost per day.
   *
   * @param costPerDay - cost per day to validate
   * @return - true if valid, false otherwise
   */
  public boolean validateCostPerDay(double costPerDay);
}
