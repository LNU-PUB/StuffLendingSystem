package com.controller.model.commands;

import com.controller.model.DisplayDataBundle;
import com.controller.model.DisplayDataBundles;
import com.controller.model.Language;
import com.model.Services;
import com.view.model.View;
import com.view.model.ViewFactory;

/**
 * A command for adding an item.
 */
public class AddItemCommand extends AbstractCommand {
  private static final String BUNDLE_NAME = "AddItemView";
  private final Language language;

  /**
   * Creates a new instance of the command.
   *
   * @param language - the language to use.
   */
  public AddItemCommand(Language language) {
    super();
    this.language = language;
  }

  @Override
  public boolean execute(Services memberServ) {
    ViewFactory factory = new ViewFactory();
    View view = factory.createEntityCreationView(language, BUNDLE_NAME);
    DisplayDataBundles bundle = new DisplayDataBundle(memberServ.getAllMembers(), null, null, null);
    view.displayMenu(bundle);

    return true; // for development purposes only.
  }

}
