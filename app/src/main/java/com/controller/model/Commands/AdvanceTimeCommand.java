package com.controller.model.commands;

import com.model.MemberServices;

/**
 * A command for advancing the time.
 */
public class AdvanceTimeCommand implements Command {

  @Override
  public boolean execute(MemberServices memberServ) {
    int oldDay = memberServ.getDay();
    memberServ.advanceDay();
    int newDay = memberServ.getDay();

    return oldDay != newDay;
  }
}
