package com.view;

import com.controller.model.Language;
import com.controller.model.Actions.Actions;
import com.view.model.AbstractView;
import com.view.model.AddDataView;
import com.view.model.View;
import com.view.model.ViewArguments;

/**
 * View for adding Members.
 */
public class EntityCreationView extends AbstractView implements AddDataView {
  private final ViewArguments args;

  /**
   * Constructor.
   *
   * @param language   - The language to use.
   * @param bundleName - The bundle name to use.
   */
  public EntityCreationView(ViewArguments args) {
    super(args.getLanguage(), args.getBundleName());
    this.args = args;
  }

  @Override
  public void displayMenu() {
    displayGreeting();
    System.out.println("- " + texts.getString("title") + " -\n");
  }

  @Override
  public void displayResourcePrompt(String prompt) {
    String viewPrompt = texts.getString(prompt);

    System.out.print(viewPrompt + ": ");
  }
}
