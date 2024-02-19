package com.view.model;

/**
 * The view common provider interface.
 * Defines all the common functionalities for views.
 */
public interface ViewCommonProvider {

  /**
   * Creates a 50 line break.
   */
  public void cleanScreen();

  /**
   * Displays a greeting to the user.
   */
  public void displayGreeting();

  /**
   * Displays the title.
   *
   * @param prompt - the prompt for the title in the resources.
   */
  public void displayTitle(String prompt);

  /**
   * Displays the enter prompt.
   */
  public void displayEnterPrompt();

  /**
   * Displays the provided string.
   *
   * @param string - the string to display.
   */
  public void displayString(String string);

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
  public void displayResourcePrompt(String prompt, String prepend, String append);

  /**
   * Displays the resource prompt with a default value.
   *
   * @param message - the message to display.
   */
  public void displayError(String message);
}
