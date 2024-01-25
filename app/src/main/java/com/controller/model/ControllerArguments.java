package com.controller.model;

import com.model.MemberRepository;
import com.model.TimeService;

/**
 * Class holding common arguments for controllers.
 */
public class ControllerArguments {
  private final InputService inputService;
  private final TimeService timeService;
  private final MemberRepository memberRepo;
  private final Language language;

  /**
   * Creates a new instance of the controller arguments.
   *
   * @param inputService - The input service.
   * @param memberRepo   - The stuff lending system.
   * @param language     - The language.
   */
  public ControllerArguments(MemberRepository memberRepo, TimeService timeService,
      InputService inputService, Language language) {
    this.inputService = inputService;
    this.timeService = timeService;
    this.memberRepo = memberRepo;
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
   * Gets the time service.
   *
   * @return - The time service.
   */
  public TimeService getTimeService() {
    return timeService;
  }

  /**
   * Gets the stuff lending system.
   *
   * @return - The stuff lending system.
   */
  public MemberRepository getMemberRepo() {
    return memberRepo;
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
