package com.controller.model.controllers;

import com.controller.ControllerFactoryProvider;
import com.controller.model.util.InputService;
import com.model.Item;
import com.model.Member;
import com.model.Services;
import com.model.lib.BasicItemData;
import com.model.lib.BasicMemberData;
import com.model.lib.ItemCategory;
import com.util.DataFormatter;
import com.view.ViewFactoryProvider;
import com.view.ViewProvider;

/**
 * Abstract class for Member Controls.
 */
public abstract class AbstractControl implements Control {
  private Member member;
  private Item item;
  private InputService inputService;
  private static final int MAX_ATTEMPTS = 3;
  protected DataFormatter dataFormatter = new DataFormatter();
  private ViewFactoryProvider viewFactory;
  private ControllerFactoryProvider controllerFactory;

  protected AbstractControl(InputService inputService, ViewFactoryProvider viewFactory,
      ControllerFactoryProvider controllerFactory) {
    this.inputService = inputService;
    this.member = null;
    this.item = null;
    this.viewFactory = viewFactory;
    this.controllerFactory = controllerFactory;
  }

  protected AbstractControl(InputService inputService, Member member,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    this.inputService = inputService;
    this.member = member;
    this.item = null;
    this.viewFactory = viewFactory;
    this.controllerFactory = controllerFactory;
  }

  protected AbstractControl(InputService inputService, Member member, Item item,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    this.inputService = inputService;
    this.member = member;
    this.item = item;
    this.viewFactory = viewFactory;
    this.controllerFactory = controllerFactory;
  }

  protected ViewFactoryProvider getViewFactory() {
    return viewFactory;
  }

  protected ControllerFactoryProvider getControllerFactory() {
    return controllerFactory;
  }

  protected Member getMember() {
    return member;
  }

  protected Item getItem() {
    return item;
  }

  protected void resetMember() {
    this.member = null;
  }

  protected void setMember(Member member) {
    this.member = member;
  }

  protected BasicMemberData getAllMemberData(ViewProvider dataView, Services service) {
    // data: name, email, mobile, item list, credits.
    String name = null;
    try {
      int counter = 0;
      while (counter < MAX_ATTEMPTS && name == null) {
        if (member == null) {
          // add new member
          dataView.displayResourcePrompt("name", "", ": ");
        } else {
          // edit member
          dataView.displayPromptWithDefaultValue("name", member.getName());
        }
        name = getName(dataView, service);

        if (member != null && (name.isEmpty() || name.equals(member.getName()))) {
          name = member.getName();
        } else if (name.isEmpty() || !service.validateMemberName(name)) {
          name = null;
        }

        counter++;
      }
      String email = getEmail(dataView, service);
      String mobile = getMobile(dataView, service);

      return new BasicMemberData(name, email, mobile, service.getDay());
    } catch (Exception e) {
      dataView.displayError(e.getMessage());
      return null;
    }
  }

  protected BasicItemData getAllItemData(ViewProvider dataView, Services service, Member member) {
    // data: name, category, description, cost_per_day.
    String name = null;
    try {
      int counter = 0;
      while (name == null && counter < MAX_ATTEMPTS) {
        if (item == null) {
          // add new item
          dataView.displayResourcePrompt("name", "", ": ");
        } else {
          // edit item
          dataView.displayPromptWithDefaultValue("name", item.getName());
        }
        name = getName(dataView, service);

        if (item != null && (name.isEmpty() || name.equals(item.getName()))) {
          name = item.getName();
        } else if (name.isEmpty() || !service.validateItemName(name)) {
          name = null;
        }

        counter++;
      }

      if (name == null) {
        throw new RuntimeException("Failed to get a valid name.");
      }

      ItemCategory category = getItemCategory(dataView, service);
      String description = getDescription(dataView, service);
      double costPerDay = getCostPerDay(dataView, service);

      return new BasicItemData(member, name, category, description, costPerDay, service.getDay());
    } catch (Exception e) {
      dataView.displayError(e.getMessage());
      return null;
    }
  }

  // ***** Common Data *****

  private String getName(ViewProvider dataView, Services service) {

    String name = inputService.readLine();
    if (name == null || name.isEmpty()) {
      name = "";
    } else {
      name = name.trim();
    }

    return name;
  }

  // ***** Member Specific Data *****

  private String getEmail(ViewProvider dataView, Services service) {
    int counter = 0;

    while (counter < MAX_ATTEMPTS) {
      if (member == null) {
        dataView.displayResourcePrompt("email", "", ": ");
      } else {
        dataView.displayPromptWithDefaultValue("email", member.getEmail());
      }
      String email = inputService.readLine();
      if (email == null || email.isEmpty()) {
        email = "";
      } else {
        email = email.trim();
      }

      if (member == null) {
        if (service.validateEmail(email)) {
          return email;
        }
      } else {
        if (email.length() > 0) {
          if (email.equals(member.getEmail())) {
            return member.getEmail();
          } else {
            if (service.validateEmail(email)) {
              return email;
            }
          }
        } else {
          return member.getEmail();
        }
      }

      dataView.displayError("Invalid Email. Email has to be unique and valid.");
      counter++;
    }

    throw new RuntimeException("Failed to get email.");
  }

  private String getMobile(ViewProvider dataView, Services service) {
    int counter = 0;

    while (counter < MAX_ATTEMPTS) {
      if (member == null) {
        // add new member
        dataView.displayResourcePrompt("mobile", "", ": ");
      } else {
        // edit member
        dataView.displayPromptWithDefaultValue("mobile", member.getMobile());
      }
      String mobile = inputService.readLine();
      if (mobile == null || mobile.isEmpty()) {
        mobile = "";
      } else {
        mobile = mobile.trim();
      }

      if (member == null) {
        if (service.validateMobile(mobile)) {
          return mobile;
        }
      } else {
        if (mobile.length() > 0) {
          if (mobile.equals(member.getMobile())) {
            return member.getMobile();
          } else {
            if (service.validateMobile(mobile)) {
              return mobile;
            }
          }
        } else {
          return member.getMobile();
        }
      }

      dataView.displayError("Invalid Mobile. Mobile has to be unique and valid.");
      counter++;
    }

    throw new RuntimeException("Failed to get mobile.");
  }

  protected void refreshMemberData(Services service) {
    if (this.member != null) {
      this.member = service.getMemberById(this.member.getId());
    }
  }

  // ***** Item Specific Data *****

  private ItemCategory getItemCategory(ViewProvider dataView, Services service) {
    int counter = 0;

    while (counter < MAX_ATTEMPTS) {
      int index = 0;
      dataView.displayString("\n");
      for (ItemCategory category : ItemCategory.values()) {
        dataView.displayString(index + ". " + category.getDisplayName() + "\n");
        index++;
      }

      if (item != null) {
        // edit item
        dataView.displayPromptWithDefaultValue("category", item.getCategory().getDisplayName());
      } else {
        // add new item
        dataView.displayResourcePrompt("category", "", ": ");
      }

      String categoryIndx = inputService.readLine();

      if (categoryIndx == null || categoryIndx.isEmpty()) {
        return item.getCategory();
      } else {
        if (isNumericInteger(categoryIndx)) {
          int categoryIndex = Integer.parseInt(categoryIndx);
          if (categoryIndex >= 0 && categoryIndex < ItemCategory.values().length) {
            return ItemCategory.values()[categoryIndex];
          }
        }
      }
      counter++;
    }

    dataView.displayError("Invalid Category.");
    return item.getCategory(); // Warn that it's an invalid category and return the current category.
  }

  private String getDescription(ViewProvider dataView, Services service) {

    if (item == null) {
      // add new item
      dataView.displayResourcePrompt("description", "", ": ");
    } else {
      // edit item
      dataView.displayPromptWithDefaultValue("description", item.getDescription());
    }
    String description = inputService.readLine();

    if (description == null || description.isEmpty()) {
      return item.getDescription();
    } else {
      description = description.trim();
      return description;
    }
  }

  private double getCostPerDay(ViewProvider dataView, Services service) {
    int counter = 0;

    while (counter < MAX_ATTEMPTS) {
      if (item == null) {
        // add new item
        dataView.displayResourcePrompt("costPerDay", "", ": ");
      } else {
        // edit item
        dataView.displayPromptWithDefaultValue("costPerDay", String.valueOf(item.getCostPerDay()));
      }

      String costPerDay = inputService.readLine();

      if (costPerDay == null || costPerDay.isEmpty()) {
        return item.getCostPerDay();
      } else {
        costPerDay = costPerDay.trim();

        if (isNumericDouble(costPerDay)) {
          double cost = Double.parseDouble(costPerDay);
          if (service.validateItemCostPerDay(cost)) {
            return cost;
          }
        }
      }

      counter++;
    }

    throw new RuntimeException("Failed to get cost per day.");
  }

  protected void refreshItemData(Services service) {
    if (this.item != null) {
      this.item = service.getItemById(this.item.getId());
    }
  }
}
