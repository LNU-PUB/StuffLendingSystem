package com.view.model;

import com.controller.model.InputService;
import com.controller.model.Language;
import com.model.StuffLendingSystem;

/**
 * Class holding common arguments for views.
 */
public class ViewArguments {
  private final InputService inputService;
  private final String bundleName;
  private final Language language;
  private final StuffLendingSystem stuffSystem;

  /**
   * Creates a new instance of the view arguments.
   *
   * @param inputService - The input service.
   * @param bundleName   - The bundle name.
   * @param language     - The language.
   */
  public ViewArguments(StuffLendingSystem stuffSystem, InputService inputService, String bundleName, Language language) {
    this.inputService = inputService;
    this.bundleName = bundleName;
    this.language = language;
    this.stuffSystem = stuffSystem;
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
   * Gets the bundle name.
   *
   * @return - The bundle name.
   */
  public String getBundleName() {
    return bundleName;
  }

  /**
   * Gets the language.
   *
   * @return - The language.
   */
  public Language getLanguage() {
    return language;
  }

  /**
   * Gets the stuff system.
   *
   * @return - The stuff system.
   */
  public StuffLendingSystem getStuffSystem() {
    return stuffSystem;
  }

}
