package com.view.model;

import com.controller.model.DisplayDataBundles;

/**
 * The view interface.
 */
public interface View {
  /**
   * Displays the menu.
   *
   * @param displayDataBundle - the data to display.
   */
  void displayMenu(DisplayDataBundles displayDataBundle);

  /**
   * Displays the prompt.
   */
  public void displayPrompt();

  /**
   * Displays the prompt.
   *
   * @param prompt - the prompt to display.
   */
  public void displayPrompt(String prompt);

  /**
   * Displays the prompt with a default value.
   *
   * @param key    - the key of the default value.
   * @param prompt - the prompt to display.
   */
  public void displayPromptWithDefaultValue(String key, String prompt);

  /**
   * Displays the resource prompt.
   *
   * @param prompt - the prompt to display.
   */
  public void displayResourcePrompt(String prompt);

  /**
   * Displays the resource prompt with a default value.
   *
   * @param message - the message to display.
   */
  public void displayError(String message);
}
