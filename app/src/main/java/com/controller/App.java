package com.controller;

import com.controller.model.ControllerFactory;
import com.controller.model.Language;
import com.controller.model.controllers.Control;
import com.controller.model.util.InputService;
import com.model.Services;
import com.model.lib.ContractRepositories;
import com.model.lib.ContractRepository;
import com.model.lib.ItemRepositories;
import com.model.lib.ItemRepository;
import com.model.lib.MemberRepositories;
import com.model.lib.MemberRepository;
import com.model.lib.Service;
import com.model.lib.TimeRepositories;
import com.model.lib.TimeRepository;
import com.model.lib.TransactionRepositories;
import com.model.lib.TransactionRepository;
import com.view.ViewFactoryProvider;
import com.view.model.ViewFactory;
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
  private final ControllerFactoryProvider controllerFactory;

  /**
   * Creates a new instance of the application.
   */
  public App() {
    this.service = createService();
    this.inputService = new InputService();
    this.viewFactory = new ViewFactory();
    this.controllerFactory = new ControllerFactory();
  }

  private Services createService() {
    TimeRepositories timeRepo = new TimeRepository();
    MemberRepositories memberRepo = new MemberRepository();
    ItemRepositories itemRepo = new ItemRepository();
    ContractRepositories contractRepo = new ContractRepository();
    TransactionRepositories transactionRepo = new TransactionRepository();
    return new Service(timeRepo, memberRepo, itemRepo, contractRepo, transactionRepo);
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
    // return Language.SWE; // for testing only
  }

  protected void run(Language language) {
    Control ctrl = controllerFactory.createMainControl(language, inputService, viewFactory, controllerFactory);

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
