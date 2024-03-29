package com.view.model;

import com.controller.model.Language;
import com.model.Services;

/**
 * View for adding Members.
 */
public class EntityCreationView extends AbstractView {
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
  public void displayResourcePrompt(String prompt, String prepend, String append) {
    String viewPrompt = prepend + texts.getString(prompt) + append;

    System.out.print(viewPrompt);
  }
}
