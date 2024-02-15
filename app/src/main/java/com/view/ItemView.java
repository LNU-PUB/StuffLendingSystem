package com.view;

import com.controller.model.Language;
import com.controller.model.actions.ItemActions;
import com.model.Contract;
import com.model.Item;
import com.model.Services;
import com.view.model.AbstractView;

/**
 * Responsible for displaying information to the user.
 */
public class ItemView extends AbstractView {
  private final Item item;

  /**
   * Creates a new instance of the view.
   *
   * @param language   - the language to use.
   * @param bundleName - the bundle name to use.
   * @param item       - the item to display.
   */
  public ItemView(Language language, String bundleName, Item item) {
    super(language, bundleName);
    this.item = new Item(item);
  }

  @Override
  public void displayMenu(Services service) {
    displayGreeting();
    System.out.println("- " + texts.getString("title") + " -\n");
    displayItemDetails(service);

    for (ItemActions actions : ItemActions.values()) {
      if (actions != ItemActions.UNKNOWN) {
        System.out.println(actions.getSelector() + " - " + texts.getString(actions.getName()));
      }
    }
  }

  private void displayItemDetails(Services service) {
    // Contract contract = item.getCurrentContract();
    Iterable<Contract> contracts = service.getContractsByItem(item);

    System.out.println(texts.getString("name") + ": " + item.getName());
    System.out.println(texts.getString("id") + ": " + item.getId());
    System.out.println(texts.getString("description") + ": " + item.getDescription());
    System.out.println(texts.getString("category") + ": " + item.getCategory().getDisplayName());
    System.out.println(texts.getString("costPerDay") + ": " + item.getCostPerDay());
    System.out.println(texts.getString("creationDay") + ": " + item.getCreationDay());
    System.out.println(texts.getString("contracts") + ": ");
    for (Contract contract : contracts) {
      System.out.println("Contract id: " + contract.getId()
          + " - Start Day: " + contract.getStartDay()
          + ", End Day: " + contract.getEndDay());
    }
    System.out.println("\n---\n");
  }
}
