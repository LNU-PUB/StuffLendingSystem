package com.controller.model.commands;

import com.model.Item;
import com.model.Services;
import com.model.lib.BasicItemData;

/**
 * Command to edit an item.
 */
public class EditItemCommand implements Command {
  BasicItemData itemData;
  Item item;

  /**
   * Creates a new instance of the command.
   *
   * @param itemData - the item to edit.
   */
  public EditItemCommand(BasicItemData itemData, Item item) {
    this.itemData = itemData;
    this.item = item;
  }

  @Override
  public boolean execute(Services service) {
    Item newItem = service.updateItem(itemData, item);

    if (newItem == null) {
      return false;
    }

    return (newItem.getId().equals(item.getId()));
  }
}
