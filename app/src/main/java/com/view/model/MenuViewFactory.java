package com.view.model;

import com.view.MainView;

/**
 * Interface for the view factory.
 */
public interface MenuViewFactory {
  public MainView createMainMenuView(ViewArguments args);

  public View createListMembersView(ViewArguments args, boolean detailedList);

  public View createMemberView(ViewArguments args);
}
