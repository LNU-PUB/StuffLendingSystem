package com.view.model;

import com.model.MemberServices;

/**
 * Responsible for displaying information to the user.
 */
public interface View {
  public void displayMenu(MemberServices memberServ);
  
  public void displayPrompt();

  public void displayPrompt(String prompt);

  public void displayPromptWithDefaultValue(String key, String prompt);

  public void displayResourcePrompt(String prompt);

  public void displayError(String message);
}
