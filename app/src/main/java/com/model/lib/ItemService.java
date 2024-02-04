package com.model.lib;

import com.model.Contract;
import com.model.Item;
import com.model.Member;

import java.util.List;

/**
 * Item Service.
 */
public class ItemService implements ItemServices {
  private final ItemRepositories itemRepo;

  /**
   * Constructor.
   *
   * @param itemRepo - item repository
   */
  public ItemService(ItemRepositories itemRepo) {
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

  @Override
  public List<Item> getItemsByMember(Member member) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getItemsByMember'");
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
