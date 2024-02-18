package com.controller;

import com.controller.model.Control;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.model.Item;
import com.model.Member;
import com.model.Services;
import com.view.ListViewProvider;
import com.view.ViewFactoryProvider;
import com.view.ViewProvider;

/**
 * The LendItemControl class.
 */
public class LendItemControl implements Control {
  private static final String BUNDLE_NAME = "MemberView";
  private final InputService inputService;
  private final Language language;
  private Member member;
  private ListViewProvider view;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param member       - the member to operate on.
   */
  public LendItemControl(Language language, InputService inputService, Member member, ViewFactoryProvider viewFactory) {
    this.inputService = inputService;
    this.language = language;
    this.member = member;
    this.view = viewFactory.createListView(language, BUNDLE_NAME, true);
  }

  @Override
  public boolean run(Services service) {
    return createNewLendingContract(service);
  }

  private boolean createNewLendingContract(Services service) {
    // 1) List all items
    // 2) Select item
    // 3) Select time period
    // 4) Check if Item is available for the time period
    // 5) Calculate cost for the time period
    // 6) Check if borrower has enough credits
    // 7) Create transaction for borrower
    // 8) Add the transaction to the list in TransactionRepository
    // 9) Create transaction for lender
    // 10) Add the transaction to the list in TransactionRepository
    // 11) Create a new LendingContract
    // 12) Add the LendingContract to the list in ContractRepository
    // 13) Return true if contract creation is successful else false

    listAllItems(service);
    int itemIndex = getInput("getItem"); // Select item
    int startTime = getInput("startTime"); // Select start time
    int endTime = getInput("endTime"); // Select end time
    // checkItemAvailability(service, item);
    // calculateCost(service, item, startTime, endTime);
    // checkBorrowerCredits(service, cost);
    // createTransaction(service, cost);

    return false; // for development only
  }

  private void listAllItems(Services service) {

    view.displayList(service, service.getAllItems());
  }

  private int getInput(String prompt) {
    view.displayPrompt(prompt);
    String input = inputService.readLine();
    input = input.trim();

    if (input.equals("x")) {
      return -1;
    }

    if (isNumericInteger(input)) {
      return Integer.parseInt(input);
    } else {
      view.displayError("Invalid Input");
      return getInput(prompt);
    }
  }
}
