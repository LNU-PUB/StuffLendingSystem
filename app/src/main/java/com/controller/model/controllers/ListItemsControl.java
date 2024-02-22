package com.controller.model.controllers;

import com.controller.ControllerFactoryProvider;
import com.controller.model.Language;
import com.controller.model.actions.ListItemsActions;
import com.controller.model.commands.Command;
import com.controller.model.commands.CommandFactory;
import com.controller.model.util.InputService;
import com.controller.model.util.ListItemsResponse;
import com.model.Item;
import com.model.Member;
import com.model.Services;
import com.model.lib.BasicItemData;
import com.view.ViewFactoryProvider;
import com.view.ViewProvider;
import com.view.model.ViewFactory;

/**
 * The ListItems controller.
 */
public class ListItemsControl extends AbstractControl {
  private static final String BUNDLE_NAME = "ListItemsView";
  private final Language language;
  private final InputService inputService;
  private final Member member;
  private final ViewProvider view;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param listAllItems - true if the list should list all items, false if not.
   * @param member       - the member to operate on.
   * @param viewFactory  - the view factory to use.
   * @param controllerFactory - the controller factory to use.
   */
  public ListItemsControl(Language language, InputService inputService, boolean listAllItems, Member member,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    super(inputService, member, viewFactory, controllerFactory);
    this.language = language;
    this.inputService = inputService;
    this.member = member;
    this.view = viewFactory.createListItemsView(language, BUNDLE_NAME, listAllItems, member);
  }

  @Override
  public boolean run(Services service) {
    view.displayMenu(service);
    ListItemsActions action = ListItemsActions.UNKNOWN;

    try {
      ListItemsResponse response = getInput(service);
      action = response.getAction();

      if (action == ListItemsActions.ADDITEM) {
        addItem(service);
      } else if (action == ListItemsActions.SELECTEDITEM) {
        Item item = getItemByIndex(service.getItemsByMember(member),
            response.getIndex());
        viewItem(service, item);
      }
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }

    return action != ListItemsActions.EXIT;
  }

  private Item getItemByIndex(Iterable<Item> itemsByMember, int index) {
    int currentIndex = 0;

    for (Item item : itemsByMember) {
      if (currentIndex == index) {
        return item;
      }

      currentIndex++;
    }
    view.displayError("Invalid index: " + index);
    return null;
  }

  private void viewItem(Services service, Item item) {
    if (item == null) {
      return;
    }

    ControllerFactoryProvider factory = getControllerFactory();
    Control ctr = factory.createItemControl(language, inputService, item, getViewFactory(), factory);
    while (ctr.run(service)) {
    }
  }

  private void addItem(Services service) {
    ViewFactory factory = new ViewFactory();
    ViewProvider dataView = factory.createEntityCreationView(language, "BasicItemData");

    BasicItemData itemData = getAllItemData(dataView, service, this.member);
    CommandFactory cmdFactory = new CommandFactory();
    Command addItem = cmdFactory.createAddItemCommand(itemData); //new AddItemCommand(itemData);
    addItem.execute(service);
  }

  private ListItemsResponse getInput(Services service) {
    view.displayEnterPrompt();
    String input = inputService.readLine();

    if (input == null || input.isEmpty()) {
      return new ListItemsResponse(ListItemsActions.UNKNOWN, -1);
    }

    input = input.trim();

    if (isNumericInteger(input)) {
      int index = Integer.parseInt(input);
      return new ListItemsResponse(ListItemsActions.SELECTEDITEM, index);
    }

    for (ListItemsActions action : ListItemsActions.values()) {
      if (input.equalsIgnoreCase(action.getSelector().trim())) {
        return new ListItemsResponse(action, -1);
      }
    }

    return new ListItemsResponse(ListItemsActions.UNKNOWN, -1);
  }

}
