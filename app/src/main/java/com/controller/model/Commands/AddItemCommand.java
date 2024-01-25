package com.controller.model.Commands;

import com.controller.model.ControllerArguments;
import com.view.ViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;

public class AddItemCommand extends AbstractCommand{
  private final ControllerArguments args;
  private final String BUNDLE_NAME = "AddItemView";

  /**
   * Creates a new instance of the command.
   * 
   * @param memberRepository - the member repository.
   * @param args             - the view arguments.
   */
  public AddItemCommand(ControllerArguments args) {
    this.args = args;
  }

  @Override
  public boolean execute() {
    ViewArguments viewArgs = new ViewArguments(args.getMemberRepo(), BUNDLE_NAME,
        args.getLanguage());
    ViewFactory factory = new ViewFactory();
    View view = factory.createEntityCreationView(viewArgs);

    return true; // for development purposes only.
  }
  
}
