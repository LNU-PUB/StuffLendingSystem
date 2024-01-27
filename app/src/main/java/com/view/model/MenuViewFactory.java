package com.view.model;

import com.model.Member;

/**
 * Interface for the view factory.
 */
public interface MenuViewFactory {
  public View createMainMenuView(ViewArguments args);

  public View createListMembersView(ViewArguments args, boolean detailedList);

  public View createMemberView(ViewArguments args, Member member);

  public View createSimplePromptView(ViewArguments args);

  public View createEntityCreationView(ViewArguments args);
}
