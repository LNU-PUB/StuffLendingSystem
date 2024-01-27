package com.controller.model.commands;

/**
 * The command executer that executes commands.
 * Will not use this abstraction level in this application but it is here for 
 * possible future use.
 */
public class CommandExecutor {
  
  /**
   * Executes the command.
   *
   * @param command - The command to execute.
   */
  public void executeCommand(Command command) {
    command.execute();
  }
}
