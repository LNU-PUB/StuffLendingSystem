package com.controller.model.commands;

import com.controller.model.ControllerArguments;
import com.controller.model.ControllerArgumentsProvider;
import com.model.Member;

/**
 * The DeleteMember command.
 */
public class DeleteMemberCommand implements Command {
  private final ControllerArgumentsProvider args;
  private final Member member;

  /**
   * Creates a new instance of the command.
   *
   * @param member - the member to delete.
   */
  public DeleteMemberCommand(ControllerArgumentsProvider args, Member member) {
    this.args = args;
    this.member = member;
  }

  @Override
  public boolean execute() {
    return args.getMemberServices().deleteMember(member);
  }
  
}
