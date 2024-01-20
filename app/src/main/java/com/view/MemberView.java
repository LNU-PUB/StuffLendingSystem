package com.view;

import com.controller.model.Language;
import com.controller.model.MemberActions;
import com.model.Member;
import com.view.model.AbstractView;
import com.view.model.View;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.ResourceBundle;

/**
 * Responsible for displaying information to the user.
 */
public class MemberView extends AbstractView implements View {
  private ResourceBundle texts;
  private Locale locale;

  /**
   * Creates a new instance of the view.
   *
   * @param language   - The language.
   * @param bundleName - The bundle name.
   */
  public MemberView(Language language, String bundleName) {
    super(language, bundleName);

    try {
      this.locale = new Builder().setLanguage(language.getLanguage()).setRegion(language.getCountry()).build();
      this.texts = ResourceBundle.getBundle("com.view.MemberView", locale);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }


  @Override
  public void displayMenu() {
    displayGreeting();
    
    System.out.println("- " + texts.getString("title") + " -\n");
    for (MemberActions actions : MemberActions.values()) {
      if (actions != MemberActions.UNKNOWN) {
        System.out.println(actions.getSelector() + " - " + texts.getString(actions.getName()));
      }
    }
  }

  /**
   * Collecting User input.
   */
  @Override
  public com.controller.model.Actions getInput() {

    System.out.print("Enter: ");
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }

      switch (c) {
        case 'm':
          return MemberActions.VIEWMEMBER;
        case 'a':
          return MemberActions.ADDMEMBER;
        case 'e':
          return MemberActions.EDITMEMBER;
        case 'd':
          return MemberActions.DELETEMEMBER;
        case 's':
          return MemberActions.SIMPLELISTMEMBERS;
        case 'l':
          return MemberActions.DETAILEDLISTMEMBERS;
        case 'x':
          return MemberActions.EXIT;
        default:
          return MemberActions.UNKNOWN;
      }
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return MemberActions.UNKNOWN;
    }
  }

}
