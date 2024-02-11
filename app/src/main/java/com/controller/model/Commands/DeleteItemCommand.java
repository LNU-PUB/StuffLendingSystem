package com.controller.model.commands;

import com.model.Item;
import com.model.Services;

/**
 * Command to delete an item.
 */
public class DeleteItemCommand implements Command {
  private final Item item;

  /**
   * Creates a new instance of the command.
   *
   * @param item - the item to delete.
   */
  public DeleteItemCommand(Item item) {
    this.item = item;
  }

  @Override
  public boolean execute(Services service) {
    return service.deleteItem(item);
  }
  
}
