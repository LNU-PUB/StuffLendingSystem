package com.controller.model.commands;

import com.model.Item;
import com.model.Member;
import com.model.lib.BasicItemData;
import com.model.lib.BasicMemberData;

/**
 * A factory for creating commands.
 */
public class CommandFactory {
  /**
   * Creates a new AddItemCommand.
   *
   * @param itemData - the item data. 
   * @return - the new command.
   */
  public Command createAddItemCommand(BasicItemData itemData) {
    return new AddItemCommand(itemData);
  }

  /**
   * Creates a new AddMemberCommand.
   *
   * @param memberData - the member data.
   * @return - the new command.
   */
  public Command createAddMemberCommand(BasicMemberData memberData) {
    return new AddMemberCommand(memberData);
  }

  /**
   * Creates a new AdvanceTimeCommand.
   *
   * @return - the new command.
   */
  public Command createAdvanceTimeCommand() {
    return new AdvanceTimeCommand();
  }

  /**
   * Creates a new DeleteItemCommand.
   *
   * @param item - the item to delete.
   * @return - the new command.
   */
  public Command createDeleteItemCommand(Item item) {
    return new DeleteItemCommand(item);
  }

  /**
   * Creates a new DeleteMemberCommand.
   *
   * @param member - the member to delete.
   * @return - the new command.
   */
  public Command createDeleteMemberCommand(Member member) {
    return new DeleteMemberCommand(member);
  }

  /**
   * Creates a new EditItemCommand.
   *
   * @param itemData - the new item data.
   * @param item - the item to edit.
   * @return - the new command.
   */
  public Command createEditItemCommand(BasicItemData itemData, Item item) {
    return new EditItemCommand(itemData, item);
  }

  /**
   * Creates a new EditMemberCommand.
   *
   * @param memberData - the new member data.
   * @param member - the member to edit.
   * @return - the new command.
   */
  public Command createEditMemberCommand(BasicMemberData memberData, Member member) {
    return new EditMemberCommand(memberData, member);
  }
}
