package com.controller.model.controllers;

import com.controller.ControllerFactoryProvider;
import com.controller.model.Language;
import com.controller.model.actions.ItemActions;
import com.controller.model.commands.Command;
import com.controller.model.commands.CommandFactory;
import com.controller.model.util.InputService;
import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.Services;
import com.model.lib.BasicItemData;
import com.model.lib.ItemCategory;
import com.view.ViewFactoryProvider;
import com.view.ViewProvider;

/**
 * The Item controller.
 */
public class ItemControl extends AbstractControl {
  private static final String BUNDLE_NAME = "ItemView";
  private final Language language;
  private final InputService inputService;
  private Item item;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param item         - the item to operate on.
   * @param viewFactory  - the view factory to use.
   */
  public ItemControl(Language language, InputService inputService, Item item,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    super(inputService, null, item, viewFactory, controllerFactory);
    this.language = language;
    this.inputService = inputService;
    this.item = item;
  }

  @Override
  public boolean run(Services service) {
    ViewFactoryProvider factory = getViewFactory();
    ViewProvider view = factory.createItemView(language, BUNDLE_NAME, item);
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
    ViewFactoryProvider factory = getViewFactory();
    ViewProvider view = factory.createSimplePromptView(language, BUNDLE_NAME);
    view.displayEnterPrompt();

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
    ViewFactoryProvider factory = getViewFactory();
    ViewProvider dataView = factory.createSimplePromptView(language, "BasicItemData");

    BasicItemData itemData = getAllItemData(dataView, service, null);
    CommandFactory cmdFactory = new CommandFactory();
    Command editItem = cmdFactory.createEditItemCommand(itemData, item); // new EditItemCommand(itemData, item);
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
    CommandFactory cmdFactory = new CommandFactory();
    Command deleteItem = cmdFactory.createDeleteItemCommand(item); // new DeleteItemCommand(item);

    if (deleteItem.execute(service)) {
      this.item = null;
    }

    refreshItemData(service);
  }

}
