package com.controller.model.commands;

import com.model.Item;
import com.model.Services;

/**
 * Command to delete an item.
 */
public class DeleteItemCommand implements Command {

  /**
   * Creates a new instance of the command.
   *
   * @param item - the item to delete.
   */
  public DeleteItemCommand(Item item) {
    //TODO Auto-generated constructor stub
  }

  @Override
  public boolean execute(Services memberServ) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'execute'");
  }
  
}
