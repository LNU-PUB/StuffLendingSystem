package com.controller;

import com.controller.model.Control;
import com.controller.model.DisplayDataBundle;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.controller.model.actions.ListItemsActions;
import com.model.Member;
import com.model.Services;
import com.view.model.View;
import com.view.model.ViewFactoryProvider;

/**
 * The ListItems controller.
 */
public class ListItemsControl implements Control {
  private static final String BUNDLE_NAME = "ListItemsView";
  private final Language language;
  private final InputService inputService;
  private final boolean detailedList;
  private final ViewFactoryProvider viewFactory;
  private final Member member;
  private final View view;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListItemsControl(Language language, InputService inputService,
      boolean detailedList, ViewFactoryProvider viewFactory, Member member) {
    this.language = language;
    this.inputService = inputService;
    this.detailedList = detailedList;
    this.viewFactory = viewFactory;
    this.member = member;
    this.view = viewFactory.createListItemsView(language, BUNDLE_NAME, detailedList, member);
  }

  @Override
  public boolean run(Services service) {
    DisplayDataBundle bundle = new DisplayDataBundle(null, service.getItemsByMember(member), null, null);
    view.displayMenu(bundle);

    ListItemsActions action = getInput(service);

    return action != ListItemsActions.EXIT;
  }

  private ListItemsActions getInput(Services service) {
    String input = inputService.readLine();
    ListItemsActions action = ListItemsActions.UNKNOWN;

    if (input.equalsIgnoreCase("a")) {
      action = ListItemsActions.ADDITEM;
    } else if (input.equalsIgnoreCase("x")) {
      action = ListItemsActions.EXIT;
    } else {
      try {
        int index = Integer.parseInt(input);
        action = ListItemsActions.SELECTEDITEM;
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please try again.");
      }
    }

    return action;
  }

}
