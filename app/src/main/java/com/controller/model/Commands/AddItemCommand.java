package com.controller.model.commands;

import com.controller.model.Language;
import com.model.MemberServices;
import com.view.ViewFactory;
import com.view.model.View;

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
  public boolean execute(MemberServices memberServ) {
    ViewFactory factory = new ViewFactory();
    View view = factory.createEntityCreationView(language, BUNDLE_NAME);
    view.displayMenu(memberServ);

    return true; // for development purposes only.
  }

}
