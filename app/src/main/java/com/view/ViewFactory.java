package com.view;

import com.controller.model.Language;
import com.model.Member;
import com.view.model.MenuViewFactory;
import com.view.model.View;

/**
 * Responsible for creating views.
 */
public class ViewFactory implements MenuViewFactory {

  @Override
  public View createMainMenuView(Language language, String bundleName) {
    return new MainView(language, bundleName);
  }

  @Override
  public ListMembersView createListMembersView(Language language, String bundleName, boolean detailedList) {
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
}
