package com.controller.model.commands;

import com.model.Item;
import com.model.Services;
import com.model.lib.BasicItemData;

/**
 * A command for adding an item.
 */
public class AddItemCommand implements Command {
  private final BasicItemData itemData;

  /**
   * Creates a new instance of the command.
   *
   * @param language - the language to use.
   */
  public AddItemCommand(BasicItemData itemData) {
    this.itemData = itemData;
  }

  @Override
  public boolean execute(Services service) {
    Item newItem = service.addItem(itemData);

    return newItem != null;
  }

}
