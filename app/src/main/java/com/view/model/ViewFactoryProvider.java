package com.view.model;

import com.controller.model.Language;
import com.model.Item;
import com.model.Member;
import com.view.ListViewProvider;

/**
 * Interface for the view factory.
 */
public interface ViewFactoryProvider {
  /**
   * Creates the main menu view.
   *
   * @param language   - the language to use.
   * @param bundleName - the bundle name to use.
   * @return - the view.
   */
  public ViewProvider createMainMenuView(Language language, String bundleName);

  /**
   * Creates the member list view.
   *
   * @param language    - the language to use.
   * @param bundleName  - the bundle name to use.
   * @param detailedList - true if the list should be detailed, false if not.
   * @return - the view.
   */
  public ViewProvider createListMembersView(Language language, String bundleName, boolean detailedList);

  /**
   * Creates the member view.
   *
   * @param language   - the language to use.
   * @param bundleName - the bundle name to use.
   * @param member     - the member to display.
   * @return - the view.
   */
  public ViewProvider createMemberView(Language language, String bundleName, Member member);

  /**
   * Creates the item view.
   *
   * @param language   - the language to use.
   * @param bundleName - the bundle name to use.
   * @return - the view.
   */
  public ViewProvider createSimplePromptView(Language language, String bundleName);

  /**
   * Creates the entity creation view.
   *
   * @param language   - the language to use.
   * @param bundleName - the bundle name to use.
   * @return - the view.
   */
  public ViewProvider createEntityCreationView(Language language, String bundleName);

  /**
   * Creates the list items view.
   *
   * @param language    - the language to use.
   * @param bundleName  - the bundle name to use.
   * @param detailedList - true if the list should be detailed, false if not.
   * @param member      - the member to display items for.
   * @return - the view.
   */
  public ViewProvider createListItemsView(Language language, String bundleName, boolean detailedList, Member member);

  /**
   * Creates the item view.
   *
   * @param language   - the language to use.
   * @param bundleName - the bundle name to use.
   * @param item       - the item to display.
   * @return - the view.
   */
  public ViewProvider createItemView(Language language, String bundleName, Item item);

  public ListViewProvider createListView(Language language, String bundleName, boolean isIndexed);
}
