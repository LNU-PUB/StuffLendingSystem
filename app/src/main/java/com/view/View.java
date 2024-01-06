package com.view;

/**
 * Responsible for displaying information to the user.
 */
public interface View {
  public void displayMenu();

  public com.controller.model.Actions getInput();
}
