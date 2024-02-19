package com.controller;

import com.controller.model.Control;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.model.Item;
import com.model.Member;
import com.view.ViewFactoryProvider;

/**
 * The ControllerFactoryProvider interface.
 */
public interface ControllerFactoryProvider {
  /**
   * Creates a new instance of the ItemControl.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param item         - the item to operate on.
   * @param viewFactory  - the view factory to use.
   * @return the control.
   */
  public Control createItemControl(Language language, InputService inputService, Item item,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactoryProvider);

  /**
   * Creates a new instance of the LendItemControl.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param member       - the member to operate on.
   * @param viewFactory  - the view factory to use.
   * @return the control.
   */
  public Control createLendItemControl(Language language, InputService inputService, Member member,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactoryProvider);

  /**
   * Creates a new instance of the ListItemsControl.
   *
   * @param language                  - the language to use.
   * @param inputService              - the input service to use.
   * @param listAllItems              - true if the list should list all items,
   *                                  false if not.
   * @param member                    - the member to operate on.
   * @param viewFactory               - the view factory to use.
   * @param controllerFactoryProvider - the controller factory provider to use.
   * @return the control.
   */
  public Control createListItemsControl(Language language, InputService inputService, boolean listAllItems,
      Member member,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactoryProvider);

  /**
   * Creates a new instance of the ListMembersControl.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param detailedList - true if the list should be detailed, false if not.
   * @param viewFactory  - the view factory to use.
   * @return the control.
   */
  public Control createListMemberControl(Language language, InputService inputService, boolean detailedList,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactoryProvider);

  /**
   * Creates a new instance of the MainControl.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param viewFactory  - the view factory to use.
   * @return the control.
   */
  public Control createMainControl(Language language, InputService inputService, ViewFactoryProvider viewFactory,
      ControllerFactoryProvider controllerFactoryProvider);

  /**
   * Creates a new instance of the MemberControl.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param member       - the member to operate on.
   * @param viewFactory  - the view factory to use.
   * @return the control.
   */
  public Control createMemberControl(Language language, InputService inputService, Member member,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactoryProvider);
}
