package com.view.model;

import com.model.Services;

/**
 * The view interface.
 */
public interface ViewProvider {
  /**
   * Displays the menu.
   *
   * @param service - the service to use.
   */
  // void displayMenu(DisplayDataBundles displayDataBundle);
  void displayMenu(Services service);

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
