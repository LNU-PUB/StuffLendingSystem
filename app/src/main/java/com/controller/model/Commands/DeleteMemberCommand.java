package com.controller.model.commands;

import com.model.Member;
import com.model.Services;

/**
 * The DeleteMember command.
 */
public class DeleteMemberCommand implements Command {
  private final Member member;

  /**
   * Creates a new instance of the command.
   *
   * @param member - the member to delete.
   */
  public DeleteMemberCommand(Member member) {
    this.member = member;
  }

  @Override
  public boolean execute(Services memberServ) {
    return memberServ.deleteMember(member);
  }
  
}
