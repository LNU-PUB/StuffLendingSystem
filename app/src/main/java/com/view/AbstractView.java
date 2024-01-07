package com.view;

import com.controller.model.Language;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.ResourceBundle;

/**
 * Input interface.
 */
public abstract class AbstractView implements View {
  protected ResourceBundle texts;
  private Locale locale;

  /**
   * Constructs a new instance.
   *
   * @param language - the language
   * @param bundleName - the bundle name
   */
  public AbstractView(Language language, String bundleName) {
    try {
      this.locale = new Builder().setLanguage(language.getLanguage()).setRegion(language.getCountry()).build();
      this.texts = ResourceBundle.getBundle("com.view." + bundleName, locale);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Displays a greeting to the user.
   */
  public void displayGreeting() {
    for (int i = 0; i < 50; i++) {
      System.out.println("");
    }
    System.out.println("*** Stuff lending System ***\n");
  }

}
