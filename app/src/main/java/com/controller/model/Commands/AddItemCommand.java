package com.controller.model.commands;

import com.controller.model.ControllerArguments;
import com.view.ViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;

/**
 * A command for adding an item.
 */
public class AddItemCommand extends AbstractCommand {
  private final ControllerArguments args;
  private static final String BUNDLE_NAME = "AddItemView";

  /**
   * Creates a new instance of the command.
   *
   * @param args - the arguments for the command.
   */
  public AddItemCommand(ControllerArguments args) {
    this.args = args;
  }

  @Override
  public boolean execute() {
    ViewArguments viewArgs = new ViewArguments(args.getMemberServices(), BUNDLE_NAME,
        args.getLanguage());
    ViewFactory factory = new ViewFactory();
    View view = factory.createEntityCreationView(viewArgs);
    view.displayMenu();

    return true; // for development purposes only.
  }

}
