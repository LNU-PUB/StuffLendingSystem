package com.controller;

import com.controller.model.Control;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.model.Item;
import com.model.Member;
import com.model.Services;
import com.model.lib.BasicContractData;
import com.model.lib.BasicTransactionData;
import com.view.ListViewProvider;
import com.view.ViewFactoryProvider;

/**
 * The LendItemControl class.
 */
public class LendItemControl implements Control {
  private static final String BUNDLE_NAME = "NewContractView";
  private final InputService inputService;
  private Member member;
  private ListViewProvider view;
  private static final int MAX_COUNT = 3;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param member       - the member to operate on.
   */
  public LendItemControl(Language language, InputService inputService, Member member, ViewFactoryProvider viewFactory) {
    this.inputService = inputService;
    this.member = member;
    this.view = viewFactory.createListView(language, BUNDLE_NAME, true);
  }

  @Override
  public boolean run(Services service) {
    return createNewLendingContract(service);
  }

  private boolean createNewLendingContract(Services service) {
    boolean collectData = true;
    int counter = 0;
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

    int itemIndex = -2;
    while (collectData && counter < MAX_COUNT) {
      if (itemIndex < 0) {
        listAllItems(service);
        itemIndex = getInput("get_item"); // Select item
      }

      if (itemIndex == -1) {
        return false;
      } else if (itemIndex >= 0) {
        Item selectedItem = getItem(service, itemIndex);
        view.displayResourcePrompt("period", "", "\n");
        int startTime = getInput("start_time"); // Select start time
        int endTime = getInput("end_time"); // Select end time
        if (checkItemAvailability(service, selectedItem, startTime, endTime)) {
          double cost = calculateCost(service, selectedItem, startTime, endTime);
          if (cost < 0) {
            view.displayError("Invalid cost");
            counter = 3;
          }
          if (checkBorrowerCredits(service, cost)) {
            createTransactions(service, selectedItem, cost);
            createContract(service, selectedItem, startTime, endTime);
          }
          // createTransaction(service, cost);
        }
      }
      counter++;
    }

    return false; // for development only change to true for production
  }

  private Item getItem(Services service, int itemIndex) {
    Item selectedItem = null;

    int index = 0;
    for (Item item : service.getAllItems()) {
      if (index == itemIndex) {
        selectedItem = item;
        break;
      }
      index++;
    }

    return selectedItem;
  }

  private void listAllItems(Services service) {
    view.cleanScreen();
    view.displayGreeting();
    view.displayTitle("title");
    view.displayList(service, service.getAllItems());
  }

  private int getInput(String prompt) {
    view.displayResourcePrompt(prompt, "", ": ");
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

  private boolean checkItemAvailability(Services service, Item selectedItem, int startTime, int endTime) {
    if (selectedItem != null && service.isItemAvailable(selectedItem, startTime, endTime)) {
      return true;
    } else {
      view.displayString("\nItem not available for the selected time period\n");
      return false;
    }
  }

  private double calculateCost(Services service, Item selectedItem, int startTime, int endTime) {
    if (selectedItem != null) {
      double costPerDay = selectedItem.getCostPerDay();
      int days = endTime - startTime;
      return costPerDay * days;
    }

    return -1;
  }

  private boolean checkBorrowerCredits(Services service, double cost) {

    if (service.getMemberBalance(member) >= cost) {
      return true;
    } else {
      view.displayError("Insufficient funds");
      return false;
    }
  }

  private void createTransactions(Services service, Item selectedItem, double cost) {

    BasicTransactionData lenderTransaction = new BasicTransactionData(member, cost, service.getDay());
    service.addNewTransaction(lenderTransaction);
    BasicTransactionData borrowerTransaction = new BasicTransactionData(selectedItem.getOwner(), -cost,
        service.getDay());
    service.addNewTransaction(borrowerTransaction);
  }

  private void createContract(Services service, Item selectedItem, int startTime, int endTime) {
    BasicContractData contract = new BasicContractData(selectedItem.getOwner(), member, selectedItem, startTime,
        endTime);
    service.addNewContract(contract);
  }
}
