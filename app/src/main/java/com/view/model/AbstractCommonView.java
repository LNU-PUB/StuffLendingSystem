package com.view.model;

import com.controller.model.Language;
import com.util.DataFormatter;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.ResourceBundle;

/**
 * Implements all common methods for views.
 */
public class AbstractCommonView implements ViewCommonProvider {
  protected ResourceBundle texts;
  protected ResourceBundle baseTexts;
  protected DataFormatter dataFormatter;
  private Locale locale;

  /**
   * Constructs a new instance.
   *
   * @param language   - the language
   * @param bundleName - the bundle name
   */
  public AbstractCommonView(Language language, String bundleName) {
    this.dataFormatter = new DataFormatter();
    try {
      this.locale = new Builder().setLanguage(language.getLanguage()).setRegion(language.getCountry()).build();
      this.texts = ResourceBundle.getBundle("com.view." + bundleName, locale);
      this.baseTexts = ResourceBundle.getBundle("com.view.BaseView", locale);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Creates a 50 line break.
   */
  @Override
  public void cleanScreen() {
    for (int i = 0; i < 50; i++) {
      System.out.println("");
    }
  }

  /**
   * Displays a greeting to the user.
   */
  @Override
  public void displayGreeting() {
    System.out.println("*** Stuff Lending System ***\n");
  }

  /**
   * Displays the title.
   *
   * @param prompt - the prompt for the title in the resources.
   */
  @Override
  public void displayTitle(String prompt) {
    System.out.println("--- " + texts.getString(prompt) + " ---");
  }

  @Override
  public void displayError(String error) {
    System.out.println("\n*** " + baseTexts.getString("error") + ": " + error + "\n");
  }

  @Override
  public void displayEnterPrompt() {
    System.out.print(baseTexts.getString("enter") + ": ");
  }

  @Override
  public void displayString(String string) {
    System.out.print(string);
  }

  @Override
  public void displayPromptWithDefaultValue(String key, String prompt) {
    System.out.print(texts.getString(key) + " (" + prompt + "): ");
  }

  @Override
  public void displayResourcePrompt(String prompt, String prepend, String append) {
    System.out.print(prepend + texts.getString(prompt) + append);
  }
}
