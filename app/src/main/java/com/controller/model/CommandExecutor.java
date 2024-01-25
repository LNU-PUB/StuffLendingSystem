package com.controller.model;

/**
 * The command executer that executes commands.
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
