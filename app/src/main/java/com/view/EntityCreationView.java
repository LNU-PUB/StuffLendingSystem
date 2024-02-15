package com.view;

import com.controller.model.Language;
import com.model.Services;
import com.view.model.AbstractView;
import com.view.model.AddDataView;

/**
 * View for adding Members.
 */
public class EntityCreationView extends AbstractView implements AddDataView {
  // private final ViewArguments args;

  /**
   * Constructor.
   *
   * @param language   - the language to use.
   * @param bundleName - the bundle name to use.
   */
  public EntityCreationView(Language language, String bundleName) {
    super(language, bundleName);
    // this.args = args;
  }

  @Override
  public void displayMenu(Services service) {
    displayGreeting();
    System.out.println("- " + texts.getString("title") + " -\n");
  }

  @Override
  public void displayResourcePrompt(String prompt) {
    String viewPrompt = texts.getString(prompt);

    System.out.print(viewPrompt + ": ");
  }
}
