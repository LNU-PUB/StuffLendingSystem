package com.view.model;

/**
 * Responsible for displaying information to the user.
 */
public interface View {
  public void displayMenu();
  
  public void displayPrompt();

  public void displayError(String message);
}
