package com.controller.model;

import com.model.Item;
import com.model.Member;
import com.model.Services;
import com.model.lib.BasicItemData;
import com.model.lib.BasicMemberData;
import com.model.lib.ItemCategory;
import com.view.model.View;

/**
 * Abstract class for Member Controls.
 */
public abstract class AbstractControl implements Control {
  private Member member;
  private Item item;
  private InputService inputService;
  private static final int MAX_ATTEMPTS = 3;

  protected AbstractControl(InputService inputService) {
    this.inputService = inputService;
    this.member = null;
    this.item = null;
  }

  protected AbstractControl(InputService inputService, Member member) {
    this.inputService = inputService;
    this.member = member;
    this.item = null;
  }

  protected AbstractControl(InputService inputService, Member member, Item item) {
    this.inputService = inputService;
    this.member = member;
    this.item = item;
  }

  protected BasicMemberData getAllMemberData(View dataView, Services service) {
    // data: name, email, mobile, item list, credits.
    String name = null;
    try {
      int counter = 0;
      while (counter < MAX_ATTEMPTS && name == null) {
        if (member == null) {
          dataView.displayResourcePrompt("name");
        } else {
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

  protected BasicItemData getAllItemData(View dataView, Services service, Member member) {
    // data: name, category, description, cost_per_day.
    String name = null;
    try {
      int counter = 0;
      while (name == null && counter < MAX_ATTEMPTS) {
        if (item == null) {
          dataView.displayResourcePrompt("name");
        } else {
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

  private String getName(View dataView, Services service) {

    String name = inputService.readLine();
    if (name == null || name.isEmpty()) {
      name = "";
    } else {
      name = name.trim();
    }

    return name;
  }

  // ***** Member Specific Data *****

  private String getEmail(View dataView, Services service) {
    int counter = 0;

    while (counter < MAX_ATTEMPTS) {
      if (member == null) {
        dataView.displayResourcePrompt("email");
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

  private String getMobile(View dataView, Services service) {
    int counter = 0;

    while (counter < MAX_ATTEMPTS) {
      if (member == null) {
        dataView.displayResourcePrompt("mobile");
      } else {
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

  private ItemCategory getItemCategory(View dataView, Services service) {
    int counter = 0;

    while (counter < MAX_ATTEMPTS) {
      int index = 0;
      dataView.displayPrompt("\n");
      for (ItemCategory category : ItemCategory.values()) {
        dataView.displayPrompt(index + ". " + category.getDisplayName() + "\n");
        index++;
      }

      if (item != null) {
        dataView.displayPromptWithDefaultValue("category", item.getCategory().getDisplayName());
      } else {
        dataView.displayResourcePrompt("category");
      }

      String categoryId = inputService.readLine();

      if (categoryId == null || categoryId.isEmpty()) {
        categoryId = "";
      } else {
        categoryId = categoryId.trim();
        if (isNumericInteger(categoryId)) {
          int categoryIndex = Integer.parseInt(categoryId);
          if (categoryIndex >= 0 && categoryIndex < ItemCategory.values().length) {
            return ItemCategory.values()[categoryIndex];
          }
        }
      }
      counter++;
    }

    dataView.displayError("Invalid Category. Category has to be valid.");
    return ItemCategory.OTHER;

  }

  private String getDescription(View dataView, Services service) {
    int counter = 0;

    while (counter < MAX_ATTEMPTS) {
      if (item == null) {
        dataView.displayResourcePrompt("description");
      } else {
        dataView.displayPromptWithDefaultValue("description", item.getDescription());
      }
      String description = inputService.readLine();
      if (description == null || description.isEmpty()) {
        description = "";
      } else {
        description = description.trim();
      }

      if (service.validateItemDescription(description)) {
        return description;
      }

      counter++;
    }

    throw new RuntimeException("Failed to get description.");
  }

  private double getCostPerDay(View dataView, Services service) {
    int counter = 0;

    while (counter < MAX_ATTEMPTS) {
      if (item == null) {
        dataView.displayResourcePrompt("costPerDay");
      } else {
        dataView.displayPromptWithDefaultValue("costPerDay", String.valueOf(item.getCostPerDay()));
      }
      String costPerDay = inputService.readLine();
      if (costPerDay == null || costPerDay.isEmpty()) {
        costPerDay = "0";
      } else {
        costPerDay = costPerDay.trim();
      }

      if (isNumericDouble(costPerDay)) {
        double cost = Double.parseDouble(costPerDay);
        if (service.validateItemCostPerDay(cost)) {
          return cost;
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
