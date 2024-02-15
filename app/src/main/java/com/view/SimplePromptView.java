package com.view;

import com.controller.model.DisplayDataBundles;
import com.controller.model.Language;
import com.model.Services;
import com.view.model.AbstractView;

/**
 * Responsible for displaying information to the user.
 */
public class SimplePromptView extends AbstractView {

  public SimplePromptView(Language language, String bundleName) {
    super(language, bundleName);
  }

  /**
   * displayMenu is not supported in this view.
   */
  @Override
  public void displayMenu(Services service) {
    throw new UnsupportedOperationException("Unimplemented method 'displayMenu'");
  }
}
