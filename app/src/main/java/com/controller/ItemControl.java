package com.controller;

import com.controller.model.AbstractControl;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.controller.model.actions.ItemActions;
import com.controller.model.commands.Command;
import com.controller.model.commands.DeleteItemCommand;
import com.controller.model.commands.EditItemCommand;
import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.Services;
import com.model.lib.BasicItemData;
import com.model.lib.ItemCategory;
import com.view.model.View;
import com.view.model.ViewFactoryProvider;

/**
 * The Item controller.
 */
public class ItemControl extends AbstractControl {
  private static final String BUNDLE_NAME = "ItemView";
  private final Language language;
  private final InputService inputService;
  private Item item;
  private final ViewFactoryProvider viewFactory;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param item         - the item to operate on.
   * @param viewFactory  - the view factory to use.
   */
  public ItemControl(Language language, InputService inputService, Item item, ViewFactoryProvider viewFactory) {
    super(inputService, null, item);
    this.language = language;
    this.inputService = inputService;
    this.item = item;
    this.viewFactory = viewFactory;
  }

  @Override
  public boolean run(Services service) {
    View view = viewFactory.createItemView(language, BUNDLE_NAME, item);
    view.displayMenu(service);
    ItemActions action = getInput(service);

    if (action == ItemActions.EDITITEM) {
      editItem(service);
    } else if (action == ItemActions.DELETEITEM) {
      deleteItem(service);
    }

    return action != ItemActions.EXIT;
  }

  private ItemActions getInput(Services service) {
    View view = viewFactory.createSimplePromptView(language, BUNDLE_NAME);
    view.displayPrompt();

    String input = inputService.readLine();
    if (input == null || input.isEmpty()) {
      return ItemActions.UNKNOWN;
    }

    input = input.trim();

    for (ItemActions action : ItemActions.values()) {
      if (input.equalsIgnoreCase(action.getSelector().trim())) {
        return action;
      }
    }

    return ItemActions.UNKNOWN;
  }

  private void editItem(Services service) {
    View dataView = viewFactory.createSimplePromptView(language, "BasicItemData");

    BasicItemData itemData = getAllItemData(dataView, service, null);
    Command editItem = new EditItemCommand(itemData, item);
    if (editItem.execute(service)) {
      String id = item.getId();
      Member owner = item.getOwner();
      String name = itemData.getName();
      ItemCategory category = itemData.getCategory();
      String description = itemData.getDescription();
      double costPerDay = itemData.getCostPerDay();
      int creationDay = item.getCreationDay();
      Contract currentContract = item.getCurrentContract();

      Item newItem = new Item(id, owner, name, category, description, costPerDay, creationDay, currentContract);
      this.item = newItem;
    }
  }

  private void deleteItem(Services service) {
    Command deleteItem = new DeleteItemCommand(item);

    if (deleteItem.execute(service)) {
      this.item = null;
    }

    refreshItemData(service);
  }

}
