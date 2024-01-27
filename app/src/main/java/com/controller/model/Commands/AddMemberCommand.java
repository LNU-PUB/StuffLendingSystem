package com.controller.model.commands;

import com.controller.model.ControllerArguments;
import com.model.lib.BasicMemberData;

/**
 * The command for adding a member.
 */
public class AddMemberCommand extends AbstractCommand {
  private final ControllerArguments args;
  private final BasicMemberData memberData;
  /**
   * Creates a new instance of the command.
   *
   * @param args - the arguments for the command.
   */
  public AddMemberCommand(ControllerArguments args, BasicMemberData memberData) {
    this.args = args;
    this.memberData = memberData;
  }

  @Override
  public boolean execute() {
    return args.getMemberRepo().addNewMember(memberData);
  }
}
