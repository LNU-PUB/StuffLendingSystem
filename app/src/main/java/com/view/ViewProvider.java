package com.view;

import com.model.Services;
import com.view.model.ViewCommonProvider;

/**
 * The view interface.
 */
public interface ViewProvider extends ViewCommonProvider {
  /**
   * Displays the menu.
   *
   * @param service - the service to use.
   */
  // void displayMenu(DisplayDataBundles displayDataBundle);
  void displayMenu(Services service);
}
