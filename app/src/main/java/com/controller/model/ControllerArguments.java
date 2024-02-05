package com.controller.model;

import com.model.MemberServices;

/**
 * Class holding common arguments for controllers.
 */
public class ControllerArguments implements ControllerArgumentsProvider {
  private final InputService inputService;
  // private final TimeService timeService;
  private final MemberServices memberServ;
  private final Language language;

  /**
   * Creates a new instance of the controller arguments.
   *
   * @param inputService - The input service.
   * @param memberServ   - The stuff lending system.
   * @param language     - The language.
   */
  public ControllerArguments(MemberServices memberServ, InputService inputService, Language language) {
    this.inputService = inputService;
    this.memberServ = memberServ;
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
  public MemberServices getMemberServices() {
    return memberServ;
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
