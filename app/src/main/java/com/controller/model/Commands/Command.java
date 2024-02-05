package com.controller.model.commands;

import com.model.MemberServices;

/**
 * The command interface.
 */
public interface Command {
  public boolean execute(MemberServices memberServ);
}
