package com.controller.model.commands;

import com.model.Member;
import com.model.MemberServices;
import com.model.lib.BasicMemberData;

/**
 * The command for editing a member.
 */
public class EditMemberCommand implements Command {
  private final BasicMemberData editedMemberData;
  private final Member member;

  /**
   * Creates a new instance of the command.
   *
   * @param editedMemberData - the edited member data.
   * @param member           - the member to edit.
   */
  public EditMemberCommand(BasicMemberData editedMemberData, Member member) {
    this.editedMemberData = editedMemberData;
    this.member = member;
  }

  @Override
  public boolean execute(MemberServices memberServ) {
    Member newMember = memberServ.updateMember(editedMemberData, member);

    return newMember.getId().equals(member.getId());
  }

}
