package com.controller.model;

import com.model.Member;
import com.model.Services;
import com.model.lib.BasicMemberData;
import com.view.model.View;

/**
 * Abstract class for Member Controls.
 */
public abstract class AbstractMemberControl implements Control {
  private Member member;
  private InputService inputService;

  protected AbstractMemberControl(InputService inputService) {
    this.inputService = inputService;
    this.member = null;
  }

  protected AbstractMemberControl(InputService inputService, Member member) {
    this.inputService = inputService;
    this.member = member;
  }

  protected BasicMemberData getAllMemberData(View dataView, Services service) {
    // data: name, email, mobile, item list, credits.
    try {
      String name = getName(dataView, service);
      String email = getEmail(dataView, service);
      String mobile = getMobile(dataView, service);

      // BasicMemberData memberData = new BasicMemberData(name, email, mobile);

      // return args.getMemberRepo().addNewMember(memberData);

      return new BasicMemberData(name, email, mobile, service.getDay());
    } catch (Exception e) {
      dataView.displayError(e.getMessage());
      return null;
    }
  }

  private String getName(View dataView, Services service) {
    int counter = 0;

    while (counter < 3) {
      if (member == null) {
        dataView.displayResourcePrompt("name");
      } else {
        dataView.displayPromptWithDefaultValue("name", member.getName());
      }
      String name = inputService.readLine();
      if (name == null || name.isEmpty()) {
        name = "";
      } else {
        name = name.trim();
      }

      if (member == null) {
        if (service.validateName(name)) {
          return name;
        }
      } else {
        if (name.length() > 0) {
          if (name.equals(member.getName())) {
            return member.getName();
          } else {
            if (service.validateName(name)) {
              return name;
            }
          }
        } else {
          return member.getName();
        }
      }

      dataView.displayError("Invalid Name. Name has to be at least 2 characters long.");
      counter++;
    }

    throw new RuntimeException("Failed to get name.");
  }

  private String getEmail(View dataView, Services service) {
    int counter = 0;

    while (counter < 3) {
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

    while (counter < 3) {
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
}
