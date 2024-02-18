package com.view.model;

/**
 * The view common provider interface.
 * Defines all the common functionalities for views.
 */
public interface ViewCommonProvider {

  /**
   * Displays a greeting to the user.
   */
  public void displayGreeting();

  /**
   * Creates a 50 line break.
   */
  public void cleanScreen();

  /**
   * Gets the size of a list.
   *
   * @param list - the list to get the size of.
   * @return - the size of the list.
   */
  public int getSizeOfList(Iterable<?> list);

  /**
   * Displays the enter prompt.
   */
  public void displayEnterPrompt();

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
