package com.controller.model.commands;

import com.model.Services;

/**
 * The command interface.
 */
public interface Command {
  public boolean execute(Services memberServ);
}
