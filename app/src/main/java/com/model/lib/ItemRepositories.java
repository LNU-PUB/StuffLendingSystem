package com.model.lib;

import java.util.List;

import com.model.Item;

public interface ItemRepositories {
  public List<Item> getItems();

  public Item getItemById(String id);

  public Item addNewItem(Item item);

  public Item updateItem(Item item);

  public boolean deleteItem(Item item);
}
