package com.view.model;

/**
 * Interface for the view factory.
 */
public interface MenuViewFactory {
  public View createMainMenuView(ViewArguments args);

  public View createListMembersView(ViewArguments args, boolean detailedList);

  public View createMemberView(ViewArguments args);
}
