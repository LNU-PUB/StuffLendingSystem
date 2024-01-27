package com.controller.model.commands;

import com.controller.model.ControllerArguments;
import com.model.Member;
import com.model.lib.BasicMemberData;

public class EditMemberCommand implements Command {
  private final ControllerArguments args;
  private final BasicMemberData editedMemberData;
  private final Member member;

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
