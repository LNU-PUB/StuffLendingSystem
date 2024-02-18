package com.view.model;

import com.controller.model.Language;
import com.model.Item;
import com.model.Member;
import com.view.ListViewProvider;
import com.view.ViewFactoryProvider;
import com.view.ViewProvider;

// Note: Consider refactoring the entire view package to utilize the two 
// interfaces ViewProvider and ListViewProvider. This will allow for a more
// consistent and maintainable codebase.
// Now I have to try and get this together first before I can start refactoring.
// It's very limited time left.

/**
 * The view factory.
 */
public class ViewFactory implements ViewFactoryProvider {

  @Override
  public ViewProvider createMainMenuView(Language language, String bundleName) {
    return new MainView(language, bundleName);
  }

  @Override
  public ViewProvider createListMembersView(Language language, String bundleName, boolean detailedList) {
    return new ListMembersView(language, bundleName, detailedList);
  }

  @Override
  public ViewProvider createMemberView(Language language, String bundleName, Member member) {
    return new MemberView(language, bundleName, member);
  }

  @Override
  public ViewProvider createSimplePromptView(Language language, String bundleName) {
    return new SimplePromptView(language, bundleName);
  }

  @Override
  public ViewProvider createEntityCreationView(Language language, String bundleName) {
    return new EntityCreationView(language, bundleName);
  }

  @Override
  public ViewProvider createListItemsView(Language language, String bundleName, boolean detailedList, Member member) {
    return new ListItemsView(language, bundleName, detailedList, member);
  }

  @Override
  public ViewProvider createItemView(Language language, String bundleName, Item item) {
    return new ItemView(language, bundleName, item);
  }

  @Override
  public ListViewProvider createListView(Language language, String bundleName, boolean isIndexed) {
    return new ListView(language, bundleName, isIndexed);
  }
}
