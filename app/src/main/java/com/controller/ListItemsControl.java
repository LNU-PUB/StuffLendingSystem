package com.controller;

import com.controller.model.Control;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.model.MemberServices;
import com.view.model.MenuViewFactory;

/**
 * The ListItems controller.
 */
public class ListItemsControl implements Control {
  private static final String BUNDLE_NAME = "ListItemsView";
  private final Language language;
  private final InputService inputService;
  private final boolean detailedList;
  private final MenuViewFactory viewFactory;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListItemsControl(Language language, InputService inputService,
      boolean detailedList, MenuViewFactory viewFactory) {
    this.language = language;
    this.inputService = inputService;
    this.detailedList = detailedList;
    this.viewFactory = viewFactory;
  }

  @Override
  public boolean run(MemberServices memberService) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'run'");
  }

}
