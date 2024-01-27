package com.controller.model;

import com.model.lib.BasicMemberData;
import com.view.model.View;

public abstract class AbstractMemberControl implements Control {
  ControllerArguments args;

  protected AbstractMemberControl(ControllerArguments args) {
    this.args = args;
  }


  protected BasicMemberData getAllMemberData(View dataView) {
    // data: name, email, mobile, item list, credits.
    String name = getName(dataView);
    String email = getEmail(dataView);
    String mobile = getMobile(dataView);

    // BasicMemberData memberData = new BasicMemberData(name, email, mobile);

    // return args.getMemberRepo().addNewMember(memberData);

    return new BasicMemberData(name, email, mobile);
  }

  private String getName(View dataView) {
    while (true) {
      InputService inputService = args.getInputService();
      dataView.displayResourcePrompt("name");
      String name = inputService.readLine();

      if (args.getMemberRepo().validateName(name)) {
        return name;
      }

      dataView.displayError("Invalid Name. Name has to be at least 2 characters long.");
    }
  }

  private String getEmail(View dataView) {
    while (true) {
      InputService inputService = args.getInputService();
      dataView.displayResourcePrompt("email");
      String email = inputService.readLine();

      if (args.getMemberRepo().validateEmail(email)) {
        return email;
      }

      dataView.displayError("Invalid Email. Email has to be unique and valid.");
    }
  }

  private String getMobile(View dataView) {
    while (true) {
      InputService inputService = args.getInputService();
      dataView.displayResourcePrompt("mobile");
      String mobile = inputService.readLine();

      if (args.getMemberRepo().validateMobile(mobile)) {
        return mobile;
      }

      dataView.displayError("Invalid Mobile. Mobile has to be unique and valid.");
    }
  }
}
