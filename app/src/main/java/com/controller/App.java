package com.controller;

import com.controller.model.ControllerArguments;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.model.MemberRepository;
import com.model.TimeService;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

// import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * The application.
 */
public class App {
  private InputService inputService;
  private final MemberRepository memberRepo;
  private final TimeService timeService;

  /**
   * Creates a new instance of the application.
   */
  public App() {
    this.memberRepo = createMemberRepo();
    this.inputService = createInputService();
    this.timeService = createTimeService();
  }

  protected MemberRepository createMemberRepo() {
    return new MemberRepository();
  }

  protected InputService createInputService() {
    return new InputService();
  }

  protected TimeService createTimeService() {
    return new TimeService();
  }

  Language setLanguage(String[] args) {
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
    // View view = createMainView(memberRepo, inputService, language, "MainView");
    ControllerArguments controllerArgs = new ControllerArguments(memberRepo, timeService, inputService,
        language);
    MainControl ctrl = new MainControl(controllerArgs);

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
      // return; // return will terminate the application. Now it will continue but
      // without UTF-8 support.
    }
    App app = new App();
    Language lang = app.setLanguage(args);
    app.run(lang);
    app.exit();
  }
}
