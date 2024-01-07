package com.view.model;

import com.model.Member;
import java.util.List;

/**
 * Responsible for displaying information to the user.
 */
public interface View {
  public void displayMenu(List<Member> memberList);

  public com.controller.model.Actions getInput();
}
