package com.controller.model.commands;

import com.model.MemberServices;

/**
 * A command for advancing the time.
 */
public class AdvanceTimeCommand implements Command {
  private final MemberServices memberService;

  /**
   * Creates a new instance of the command.
   *
   * @param memberService - the member service.
   */
  public AdvanceTimeCommand(MemberServices memberService) {
    this.memberService = memberService;
  }

  @Override
  public boolean execute() {
    int oldDay = memberService.getDay();
    memberService.advanceDay();
    int newDay = memberService.getDay();

    return oldDay != newDay;
  }
}
