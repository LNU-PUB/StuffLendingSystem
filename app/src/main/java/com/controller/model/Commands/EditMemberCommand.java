package com.controller.model.commands;

import com.controller.model.ControllerArguments;
import com.model.Member;
import com.model.lib.BasicMemberData;

/**
 * The command for editing a member.
 */
public class EditMemberCommand implements Command {
  private final ControllerArguments args;
  private final BasicMemberData editedMemberData;
  private final Member member;

  /**
   * Creates a new instance of the command.
   *
   * @param args - the arguments for the command.
   */
  public EditMemberCommand(ControllerArguments args, BasicMemberData editedMemberData, Member member) {
    this.args = args;
    this.editedMemberData = editedMemberData;
    this.member = member;
  }

  @Override
  public boolean execute() {
    return args.getMemberRepo().editMember(editedMemberData, member);
  }

}
