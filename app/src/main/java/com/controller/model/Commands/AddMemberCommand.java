package com.controller.model.commands;

import com.model.Member;
import com.model.Services;
import com.model.lib.BasicMemberData;

/**
 * The command for adding a member.
 */
public class AddMemberCommand implements Command {
  private final BasicMemberData memberData;

  /**
   * Creates a new instance of the command.
   *
   * @param memberData - the member data to add.
   */
  public AddMemberCommand(BasicMemberData memberData) {
    this.memberData = memberData;
  }

  @Override
  public boolean execute(Services service) {
    Member newMember = service.addMember(memberData);
    return newMember != null;
  }
}
