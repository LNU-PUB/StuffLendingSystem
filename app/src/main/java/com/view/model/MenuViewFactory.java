package com.view.model;

import com.view.MainView;

/**
 * Interface for the view factory.
 */
public interface MenuViewFactory {
  public View createMainMenuView(ViewArguments args);

  public View createListMembersView(ViewArguments args, boolean detailedList);

  public View createMemberView(ViewArguments args, int memberIndex);

  public View createSimplePromptView(ViewArguments args);

  public View createEntityCreationView(ViewArguments args);
}
