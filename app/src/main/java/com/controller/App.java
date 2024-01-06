package com.controller;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import com.controller.model.Language;
import com.model.StuffLendingSystem;
import com.view.MainView;
import com.view.View;

// import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * The application.
 */
public class App {

  protected MainView createMainView(Language language) {
    return new MainView(language);
  }

  protected StuffLendingSystem createStuffSystem() {
    return new StuffLendingSystem();
  }

  private Language setLanguage(String[] args) {
    Language lang = Language.ENG;
    if (args.length > 0) {
      try {
        lang = Language.valueOf(args[0].toUpperCase());
      } catch (IllegalArgumentException e) {
        System.out.println("Unknown language: " + args[0]);
        System.out.println("Using default language: " + lang);
      }
    }
    return lang;
  }

  protected void run(Language language) {
    StuffLendingSystem stuffSystem = createStuffSystem();
    View view = createMainView(language);
    StuffControl ctrl = new StuffControl(stuffSystem, view);

    while (ctrl.run()) {
    }
  }

  private void exit() {
    System.out.println("\nApplication is closing ...");
    System.exit(0);
  }

  /**
   * The main method.
   *
   * @param args - The arguments.
   */
  public static void main(String[] args) {
    // Solves the problem with UTF-8 encoding in Windows console.
    try {
      PrintStream utf8Out = new PrintStream(System.out, true, "UTF-8");
      System.setOut(utf8Out);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      // return; // return will terminate the application. Now it will continue but without UTF-8 support.
    }
    App app = new App();
    Language lang = app.setLanguage(args);
    app.run(lang);
    app.exit();
  }
}
