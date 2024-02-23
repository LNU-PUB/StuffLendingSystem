package com.controller.model.controllers;

import com.controller.ControllerFactoryProvider;
import com.controller.model.Language;
import com.controller.model.util.FailedToCreateLendingContractException;
import com.controller.model.util.InputService;
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
public class LendItemControl extends AbstractControl {
  private static final String BUNDLE_NAME = "NewContractView";
  private final InputService inputService;
  private Member member;
  private Language language;
  private static final int MAX_COUNT = 3;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param member       - the member to operate on.
   */
  public LendItemControl(Language language, InputService inputService, Member member,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactoryProvider) {
    super(inputService, member, viewFactory, controllerFactoryProvider);
    this.inputService = inputService;
    this.member = member;
    this.language = language;
  }

  @Override
  public boolean run(Services service) {
    try {
      return createNewLendingContract(service);
    } catch (IllegalArgumentException e) {
      getViewFactory().createListView(language, BUNDLE_NAME, true).displayError(e.getMessage());
      return false;
    } catch (FailedToCreateLendingContractException e) {
      getViewFactory().createListView(language, BUNDLE_NAME, true).displayError(e.getMessage());
      return false;
    }
  }

  private boolean createNewLendingContract(Services service) throws FailedToCreateLendingContractException {
    ViewFactoryProvider factory = getViewFactory();
    ListViewProvider view = factory.createListView(language, BUNDLE_NAME, true);
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

    view.cleanScreen();
    view.displayGreeting();
    view.displayTitle("title");
    
    // Select Item
    boolean collectData = true;
    int itemIndex = -2;
    int counter = 0;
    Item selectedItem = null;
    while (collectData && counter < MAX_COUNT) {
      try {
        if (itemIndex < 0) {
          listAllItems(service, view);
          itemIndex = getInput("get_item", view);
          if (itemIndex == -1) {
            return false;
          } else if (itemIndex >= 0) {
            selectedItem = getItem(service, itemIndex);
            collectData = false;
          }
        }
      } catch (IllegalArgumentException e) {
        view.displayError(e.getMessage());
      }
      counter++;
    }

    if (counter > MAX_COUNT) {
      return false;
    }

    // Select time period
    view.displayResourcePrompt("period", "", "\n");

    // Select start time
    counter = 0;
    int startTime = -1;
    collectData = true;
    while (collectData && counter < MAX_COUNT) {
      try {
        startTime = getInput("start_time", view);
        if (startTime < service.getDay()) {
          throw new IllegalArgumentException(
              "Invalid start time: " + startTime + " - must be greater than or equal to " + service.getDay() + "\n");
        }
        collectData = false;
      } catch (IllegalArgumentException e) {
        view.displayError(e.getMessage());
      }
      counter++;
    }

    if (counter > MAX_COUNT) {
      return false;
    }

    // Select end time
    counter = 0;
    int endTime = -1;
    collectData = true;
    while (collectData && counter < MAX_COUNT) {
      try {
        endTime = getInput("end_time", view);
        if (endTime <= startTime) {
          throw new IllegalArgumentException(
              "Invalid end time: " + endTime + " - must be greater than " + startTime + "\n");
        }
        collectData = false;
      } catch (IllegalArgumentException e) {
        view.displayError(e.getMessage());
      }
      counter++;
    }

    if (counter > MAX_COUNT) {
      return false;
    }

    if (checkItemAvailability(service, selectedItem, startTime, endTime, view)) {
      double cost = calculateCost(service, selectedItem, startTime, endTime);

      if (checkBorrowerCredits(service, cost, view)) {
        createTransactions(service, selectedItem, cost);
        createContract(service, selectedItem, startTime, endTime);
      } else {
        throw new FailedToCreateLendingContractException(
            "Insufficient funds contract value: " + cost + " member balance: " + service.getMemberBalance(member));
      }
    }

    return false;
  }

  //

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

  private void listAllItems(Services service, ListViewProvider view) throws IllegalArgumentException {
    view.displayList(service, service.getAllItems());
  }

  private int getInput(String prompt, ListViewProvider view) {
    view.displayResourcePrompt(prompt, "", ": ");
    String input = inputService.readLine();

    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("Invalid Input");
    }

    input = input.trim();

    if (input.equals("x")) {
      return -1;
    }

    if (isNumericInteger(input)) {
      int numInput = Integer.parseInt(input);
      if (numInput < 0) {
        throw new IllegalArgumentException("Invalid Input");
      }
      return numInput;
    } else {
      throw new IllegalArgumentException("Invalid Input");
    }
  }

  private boolean checkItemAvailability(Services service, Item selectedItem,
      int startTime, int endTime, ListViewProvider view) {
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

  private boolean checkBorrowerCredits(Services service, double cost, ListViewProvider view) {

    if (service.getMemberBalance(member) >= cost) {
      return true;
    } else {
      view.displayError("Insufficient funds");
      return false;
    }
  }

  private void createTransactions(Services service, Item selectedItem, double cost) {

    BasicTransactionData lenderTransaction = new BasicTransactionData(selectedItem.getOwner(), cost, service.getDay());
    service.addNewTransaction(lenderTransaction);
    BasicTransactionData borrowerTransaction = new BasicTransactionData(member, -cost,
        service.getDay());
    service.addNewTransaction(borrowerTransaction);
  }

  private void createContract(Services service, Item selectedItem, int startTime, int endTime) {
    BasicContractData contract = new BasicContractData(selectedItem.getOwner(), member, selectedItem, startTime,
        endTime);
    service.addNewContract(contract);
  }
}
