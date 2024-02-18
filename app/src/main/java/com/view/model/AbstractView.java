package com.view.model;

import com.controller.model.Language;
import com.util.DataFormatter;
import java.util.Collection;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.ResourceBundle;

/**
 * Input interface.
 */
public abstract class AbstractView implements ViewProvider {
  protected ResourceBundle texts;
  protected DataFormatter dataFormatter;
  private Locale locale;

  /**
   * Constructs a new instance.
   *
   * @param language - the language
   * @param bundleName - the bundle name
   */
  protected AbstractView(Language language, String bundleName) {
    this.dataFormatter = new DataFormatter();
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

  protected int getSizeOfList(Iterable<?> list) {
    if (list instanceof Collection<?>) {
      return ((Collection<?>) list).size();
    } else {
      int size = 0;
      for (Object element : list) {
        size++;
      }
      return size;
    }
  }

  @Override
  public void displayPrompt() {
    System.out.print(texts.getString("enter") + ": ");
  }

  @Override
  public void displayPrompt(String prompt) {
    System.out.print(prompt);
  }

  @Override
  public void displayPromptWithDefaultValue(String key, String prompt) {
    System.out.print(texts.getString(key) + " (" + prompt + "): ");
  }

  @Override
  public void displayResourcePrompt(String prompt) {
    System.out.print(texts.getString(prompt));
  }

  // protected void setResourceBundle(Language language) {
  //   this.locale = new Builder().setLanguage(language.getLanguage()).setRegion(language.getCountry()).build();
  //   this.texts = ResourceBundle.getBundle("com.view." + bundleName, locale);
  // }
}
