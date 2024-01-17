package com.view;

import com.controller.model.Actions;
import com.controller.model.Language;
import com.controller.model.MainActions;
import com.model.Member;
import com.view.model.AbstractView;
import com.view.model.View;
import java.util.List;

/**
 * Responsible for displaying information to the user.
 */
public class MainView extends AbstractView implements View {
  // private Language language;

  /**
   * Constructor.
   *
   * @param language - The language to use.
   */
  public MainView(Language language, String bundleName) {
    super(language, bundleName);
  }

  @Override
  public void displayMenu(List<Member> memberList) {
    displayGreeting();

    System.out.println("- " + texts.getString("title") + " -\n");
    for (MainActions actions : MainActions.values()) {
      if (actions != MainActions.UNKNOWN) {
        System.out.println(actions.getSelector() + " - " + texts.getString(actions.getName()));
      }
    }
  }

  /**
   * Collecting User input.
   */
  @Override
  public Actions getInput() {

    System.out.print(texts.getString("enter") + ": ");
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }

      if (c == MainActions.LISTMEMBERS.getSelector()) {
        return MainActions.LISTMEMBERS;
      } else if (c == MainActions.LISTMEMBERSDETAIL.getSelector()) {
        return MainActions.LISTMEMBERSDETAIL;
      } else if (c == MainActions.ADVANCETIME.getSelector()) {
        return MainActions.ADVANCETIME;
      } else if (c == MainActions.QUIT.getSelector()) {
        return MainActions.QUIT;
      } else if (c == MainActions.QUIT.getSelector()) {
        return MainActions.QUIT;
      } else if (c == MainActions.QUIT.getSelector()) {
        return MainActions.QUIT;
      } else if (c == MainActions.QUIT.getSelector()) {
        return MainActions.QUIT;
      } else if (c == MainActions.QUIT.getSelector()) {
        return MainActions.QUIT;
      } else if (c == MainActions.QUIT.getSelector()) {
        return MainActions.QUIT;
      } else if (c == MainActions.QUIT.getSelector()) {
        return MainActions.QUIT;
      } else if (c == MainActions.QUIT.getSelector()) {
        return MainActions.QUIT;
      } else if (c == MainActions.QUIT.getSelector()) {
        return MainActions.QUIT;
      } else {
        return MainActions.UNKNOWN;
      }
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return MainActions.UNKNOWN;
    }
  }
}
