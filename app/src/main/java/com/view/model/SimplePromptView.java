package com.view.model;

import com.controller.model.Language;
import com.model.Services;

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
