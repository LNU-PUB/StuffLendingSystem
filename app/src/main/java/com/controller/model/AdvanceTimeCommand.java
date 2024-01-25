package com.controller.model;

import com.model.TimeService;

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
  public void execute() {
    timeService.advanceDay();
    System.out.println("New day: " + timeService.getTime());
  }
}
