package com.controller;

import com.controller.model.AbstractControl;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.controller.model.ListItemsResponse;
import com.controller.model.actions.ListItemsActions;
import com.controller.model.commands.AddItemCommand;
import com.controller.model.commands.Command;
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
  private final boolean detailedList;
  private final ViewFactoryProvider viewFactory;
  private final Member member;
  private final ViewProvider view;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListItemsControl(Language language, InputService inputService,
      boolean detailedList, ViewFactoryProvider viewFactory, Member member) {
    super(inputService);
    this.language = language;
    this.inputService = inputService;
    this.detailedList = detailedList;
    this.viewFactory = viewFactory;
    this.member = member;
    this.view = viewFactory.createListItemsView(language, BUNDLE_NAME, detailedList, member);
  }

  @Override
  public boolean run(Services service) {
    // DisplayDataBundle bundle = member != null
    // ? new DisplayDataBundle(null, service.getItemsByMember(member), null, null)
    // : new DisplayDataBundle(null, service.getAllItems(), null, null);
    // view.displayMenu(bundle);
    view.displayMenu(service);
    ListItemsActions action = ListItemsActions.UNKNOWN;

    if (detailedList || !detailedList) {
      try {
        ListItemsResponse response = getInput(service);
        action = response.getAction();

        if (action == ListItemsActions.ADDITEM) {
          addItem(service);
        } else if (action == ListItemsActions.SELECTEDITEM) {
          Item item = getItemByIndex(service.getItemsByMember(member),
              response.getIndex());
          viewItem(service, item);
          // Item item = getItemByIndex(service.getItemsByMember(member),
          // response.getIndex());
          // itemControl(service, item);
        }
      } catch (Exception e) {
        view.displayError(e.getMessage());
      }
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

    ItemControl itemControl = new ItemControl(language, inputService, item, viewFactory);
    while (itemControl.run(service)) {
    }
  }

  private void addItem(Services service) {
    ViewFactory factory = new ViewFactory();
    ViewProvider dataView = factory.createEntityCreationView(language, "BasicItemData");

    BasicItemData itemData = getAllItemData(dataView, service, this.member);
    Command addItem = new AddItemCommand(itemData);
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
