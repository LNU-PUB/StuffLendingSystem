package com.controller.model;

import com.model.StuffLendingSystem;

/**
 * Class holding common arguments for controllers.
 */
public class ControllerArguments {
  private final InputService inputService;
  private final StuffLendingSystem stuffLendingSystem;
  private final Language language;

  /**
   * Creates a new instance of the controller arguments.
   *
   * @param inputService       - The input service.
   * @param stuffLendingSystem - The stuff lending system.
   * @param language           - The language.
   */
  public ControllerArguments(StuffLendingSystem stuffLendingSystem, InputService inputService, Language language) {
    this.inputService = inputService;
    this.stuffLendingSystem = stuffLendingSystem;
    this.language = language;
  }

  /**
   * Gets the input service.
   *
   * @return - The input service.
   */
  public InputService getInputService() {
    return inputService;
  }

  /**
   * Gets the stuff lending system.
   *
   * @return - The stuff lending system.
   */
  public StuffLendingSystem getStuffLendingSystem() {
    return stuffLendingSystem;
  }

  /**
   * Gets the language.
   *
   * @return - The language.
   */
  public Language getLanguage() {
    return language;
  }
}
