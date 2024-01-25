package com.view;

import com.view.model.MenuViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;

/**
 * Responsible for creating views.
 */
public class ViewFactory implements MenuViewFactory {

  @Override
  public View createMainMenuView(ViewArguments args) {
    return new MainView(args);
  }

  @Override
  public ListMembersView createListMembersView(ViewArguments args, boolean detailedList) {
    return new ListMembersView(args, detailedList);
  }

  @Override
  public View createMemberView(ViewArguments args, int memberIndex) {
    return new MemberView(args, memberIndex);
  }

  @Override
  public View createSimplePromptView(ViewArguments args) {
    return new SimplePromptView(args);
  }

  @Override
  public View createEntityCreationView(ViewArguments args) {
    return new EntityCreationView(args);
  }
}
