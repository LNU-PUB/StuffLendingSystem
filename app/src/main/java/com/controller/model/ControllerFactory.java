package com.controller.model;

import com.controller.ControllerFactoryProvider;
import com.model.Item;
import com.model.Member;
import com.view.ViewFactoryProvider;

/**
 * The ControllerFactory class.
 */
public class ControllerFactory implements ControllerFactoryProvider {

  @Override
  public Control createItemControl(Language language, InputService inputService, Item item,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    return new ItemControl(language, inputService, item, viewFactory, controllerFactory);
  }

  @Override
  public Control createLendItemControl(Language language, InputService inputService, Member member,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    return new LendItemControl(language, inputService, member, viewFactory, controllerFactory);
  }

  @Override
  public Control createListItemsControl(Language language, InputService inputService, boolean listAllItems,
      Member member, ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    return new ListItemsControl(language, inputService, listAllItems, member, viewFactory, controllerFactory);
  }

  @Override
  public Control createListMemberControl(Language language, InputService inputService, boolean detailedList,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    return new ListMemberControl(language, inputService, detailedList, viewFactory, controllerFactory);
  }

  @Override
  public Control createMainControl(Language language, InputService inputService,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    return new MainControl(language, inputService, viewFactory, controllerFactory);
  }

  @Override
  public Control createMemberControl(Language language, InputService inputService, Member member,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    return new MemberControl(language, inputService, member, viewFactory, controllerFactory);
  }

}
