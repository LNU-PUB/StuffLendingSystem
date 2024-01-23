package com.view.model;

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
    cleanScreen();
    System.out.println("*** Stuff Lending System ***\n");
  }

  /**
   * Creates a 50 line break.
   */
  public void cleanScreen() {
    for (int i = 0; i < 50; i++) {
      System.out.println("");
    }
  }

  public void displayError(String error) {
    System.out.println("\n*** " + texts.getString("error") + ": " + error + "\n");
  }

  @Override
  public void displayPrompt() {
    System.out.print(texts.getString("enter") + ": ");
  }

  @Override
  public void displayPrompt(String prompt) {
    System.out.print(prompt);
  }

  // protected boolean isNumericInteger(String str) {
  //   return str.matches("\\d+");
  // }

  // protected String getInput(String text) {
  //   System.out.print(text + ": ");
  //   StringBuilder inputBuilder = new StringBuilder();
  //   try {
  //     int c = System.in.read();
  //     while (c != '\n' && c != -1) {
  //       inputBuilder.append((char) c);
  //       c = System.in.read();
  //     }
  //   } catch (Exception e) {
  //     System.out.println("Error: " + e.getMessage());
  //   }
  //   return inputBuilder.toString();
  // }
}
