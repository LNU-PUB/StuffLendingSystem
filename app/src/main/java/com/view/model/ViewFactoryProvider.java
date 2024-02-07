package com.view.model;

import com.controller.model.Language;
import com.model.Member;

/**
 * Interface for the view factory.
 */
public interface ViewFactoryProvider {
  public View createMainMenuView(Language language, String bundleName);

  public View createListMembersView(Language language, String bundleName, boolean detailedList);

  public View createMemberView(Language language, String bundleName, Member member);

  public View createSimplePromptView(Language language, String bundleName);

  public View createEntityCreationView(Language language, String bundleName);

  public View createListItemsView(Language language, String bundleName, boolean detailedList, Member member);
}
