package com.model.lib;

import com.model.Item;
import java.util.List;

/**
 * Item Service.
 */
public class ItemService implements ItemServices{
  private final ItemRepository itemRepo;

  /**
   * Constructor.
   *
   * @param itemRepo - item repository
   */
  public ItemService(ItemRepository itemRepo) {
    this.itemRepo = itemRepo;
  }

  @Override
  public List<Item> getAllItems() {
    return itemRepo.getItems();
  }

  @Override
  public Item getById(String id) {
    return itemRepo.getItemById(id);
  }

  @Override
  public Item addItem(Item item) {
    return itemRepo.addNewItem(item);
  }

  @Override
  public Item updateItem(Item item) {
    return itemRepo.updateItem(item);
  }

  @Override
  public boolean delete(Item item) {
    return itemRepo.deleteItem(item);
  }
  
}
