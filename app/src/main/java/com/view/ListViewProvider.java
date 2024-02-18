package com.view;

import com.model.Services;

/**
 * List view interface for displaying a list of items dynamic typing.
 */
public interface ListViewProvider {
  /**
   * Displays a list of object.
   *
   * @param service - the service to use.
   * @param list    - the list to display.
   */
  void displayList(Services service, Iterable<?> list);
}
