package com.view.model;

import com.controller.model.Language;
import com.model.Services;
import com.view.ListViewProvider;

/**
 * The ListView class.
 */
public class ListView extends AbstractView implements ListViewProvider {
  private boolean isIndexed;

  /**
   * Creates a new instance of the view.
   *
   * @param language    - the language to use.
   * @param bundleName  - the name of the bundle to use.
   * @param isIndexed   - true if the list is indexed, false otherwise.
   */
  public ListView(Language language, String bundleName, boolean isIndexed) {
    super(language, bundleName);
    this.isIndexed = isIndexed;
  }

  @Override
  public void displayList(Services service, Iterable<?> list) {
    if (isIndexed) {
      displayListIndexed(service, list);
    } else {
      displayListUnindexed(service, list);
    }
  }

  private void displayListUnindexed(Services service, Iterable<?> list) {
    for (Object item : list) {
      System.out.println(item.toString());
    }
  }

  private void displayListIndexed(Services service, Iterable<?> list) {
    int index = 0;
    
    for (Object item : list) {
      System.out.println(index + " - " + item.toString());
      index++;
    }
  }

  @Override
  public void displayMenu(Services service) {
    throw new UnsupportedOperationException("Unimplemented method 'displayMenu'");
  }
}
