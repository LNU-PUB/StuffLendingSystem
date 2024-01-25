package com.controller.model.Commands;

import com.controller.model.ControllerArguments;
import com.controller.model.InputService;
import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.model.lib.BasicMemberData;
import com.view.ViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;

/**
 * The command for adding a member.
 */
public class AddMemberCommand extends AbstractCommand {
  private final ControllerArguments args;
  private final String BUNDLE_NAME = "AddMemberView";

  /**
   * Creates a new instance of the command.
   * 
   * @param memberRepository - the member repository.
   * @param args             - the view arguments.
   */
  public AddMemberCommand(ControllerArguments args) {
    this.args = args;
  }

  @Override
  public boolean execute() {
    ViewArguments viewArgs = new ViewArguments(args.getMemberRepo(), BUNDLE_NAME,
        args.getLanguage());
    ViewFactory factory = new ViewFactory();
    View view = factory.createEntityCreationView(viewArgs);
    return getAllMemberData(view);
  }

  private boolean getAllMemberData(View view) {
    // data: name, email, mobile, item list, credits.
    String name = getName(view);
    String email = getEmail(view);
    String mobile = getMobile(view);

    BasicMemberData memberData = new BasicMemberData(name, email, mobile);

    return args.getMemberRepo().addNewMember(memberData);
  }

  private String getName(View view) {
    while (true) {
      InputService inputService = args.getInputService();
      view.displayResourcePrompt("name");
      String name = inputService.readLine();

      if (args.getMemberRepo().validateName(name)) {
        return name;
      }

      view.displayError("Invalid Name. Name has to be at least 2 characters long.");
    }
  }

  private String getEmail(View view) {
    while (true) {
      InputService inputService = args.getInputService();
      view.displayResourcePrompt("email");
      String email = inputService.readLine();

      if (args.getMemberRepo().validateEmail(email)) {
        return email;
      }

      view.displayError("Invalid Email. Email has to be unique and valid.");
    }
  }

  private String getMobile(View view) {
    while (true) {
      InputService inputService = args.getInputService();
      view.displayResourcePrompt("mobile");
      String mobile = inputService.readLine();

      if (args.getMemberRepo().validateMobile(mobile)) {
        return mobile;
      }

      view.displayError("Invalid Mobile. Mobile has to be unique and valid.");
    }
  }

  // private int getCredits(View view) {
  //     InputService inputService = args.getInputService();
  //     view.displayResourcePrompt("credits");
  //     String credits = inputService.readLine();

  //     if (isNumericInteger(credits)) {
  //       return Integer.parseInt(credits);
  //     }

  //     return 0;
  // }
}
