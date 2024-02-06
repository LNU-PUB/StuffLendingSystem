package com.view.model;

import com.controller.model.Language;
import com.model.Member;
import com.view.EntityCreationView;
import com.view.ListItemsView;
import com.view.ListMembersView;
import com.view.MainView;
import com.view.MemberView;
import com.view.SimplePromptView;

/**
 * The view factory.
 */
public class ViewFactory implements MenuViewFactory {

  @Override
  public View createMainMenuView(Language language, String bundleName) {
    return new MainView(language, bundleName);
  }

  @Override
  public View createListMembersView(Language language, String bundleName, boolean detailedList) {
    return new ListMembersView(language, bundleName, detailedList);
  }

  @Override
  public View createMemberView(Language language, String bundleName, Member member) {
    return new MemberView(language, bundleName, member);
  }

  @Override
  public View createSimplePromptView(Language language, String bundleName) {
    return new SimplePromptView(language, bundleName);
  }

  @Override
  public View createEntityCreationView(Language language, String bundleName) {
    return new EntityCreationView(language, bundleName);
  }

  @Override
  public View createListItemsView(Language language, String bundleName, boolean detailedList) {
    return new ListItemsView(language, bundleName, detailedList);
  }
  
}
