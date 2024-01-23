package com.view;

import com.view.model.AbstractView;
import com.view.model.ViewArguments;

public class SimplePromptView extends AbstractView {

  public SimplePromptView(ViewArguments args) {
    super(args.getLanguage(), args.getBundleName());
  }

  /**
   * displayMenu is not supported in this view.
   */
  @Override
  public void displayMenu() {
    throw new UnsupportedOperationException("Unimplemented method 'displayMenu'");
  }
  
}
