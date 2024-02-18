package com.view;

import com.model.Services;
import com.view.model.ViewCommonProvider;

/**
 * List view interface for displaying a list of items dynamic typing.
 */
public interface ListViewProvider extends ViewCommonProvider {
  /**
   * Displays a list of object.
   *
   * @param service - the service to use.
   * @param list    - the list to display.
   */
  void displayList(Services service, Iterable<?> list);
}
