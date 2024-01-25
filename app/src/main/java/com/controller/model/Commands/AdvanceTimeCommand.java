package com.controller.model.commands;

import com.model.TimeService;

/**
 * A command for advancing the time.
 */
public class AdvanceTimeCommand implements Command {
  private final TimeService timeService;

  /**
   * Creates a new instance of the command.
   *
   * @param timeService - The time service.
   */
  public AdvanceTimeCommand(TimeService timeService) {
    this.timeService = timeService;
  }

  @Override
  public boolean execute() {
    int oldDay = timeService.getDay();
    timeService.advanceDay();
    int newDay = timeService.getDay();

    return oldDay != newDay;
  }
}
