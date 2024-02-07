package com.controller;

import com.controller.model.InputService;
import com.controller.model.Language;
import com.model.Services;
import com.model.lib.ItemRepositories;
import com.model.lib.ItemRepository;
import com.model.lib.MemberRepositories;
import com.model.lib.MemberRepository;
import com.model.lib.Service;
import com.model.lib.TimeRepositories;
import com.model.lib.TimeRepository;
import com.view.model.ViewFactory;
import com.view.model.ViewFactoryProvider;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

// import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * The application.
 */
public class App {
  private final Services service;
  private final InputService inputService;
  private final ViewFactoryProvider viewFactory;

  /**
   * Creates a new instance of the application.
   */
  public App() {
    this.service = createService();
    this.inputService = new InputService();
    this.viewFactory = new ViewFactory();
  }

  private Services createService() {
    TimeRepositories timeRepo = new TimeRepository();
    MemberRepositories memberRepo = new MemberRepository();
    ItemRepositories itemRepo = new ItemRepository();
    return new Service(timeRepo, memberRepo, itemRepo);
  }

  protected Language setLanguage(String[] args) {
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
    MainControl ctrl = new MainControl(language, inputService, viewFactory);

    while (ctrl.run(this.service)) {
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
      // return; // return will terminate the application. Now it will continue but
      // without UTF-8 support.
    }
    App app = new App();
    Language lang = app.setLanguage(args);
    app.run(lang);
    app.exit();
  }
}
