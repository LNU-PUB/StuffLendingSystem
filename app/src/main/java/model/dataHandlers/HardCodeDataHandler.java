package model.dataHandlers;

import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.lib.DataHandlingStrategy;
import model.lib.Email;
import model.lib.Id;
import model.lib.Name;
import model.lib.Telephone;

public class HardCodeDataHandler implements DataHandlingStrategy {
  private List<Member> members;

  public HardCodeDataHandler() {
  }

  @Override
  public List<Member> loadMembers() {
    this.members = new ArrayList<>();

    members.add(new Member(new Name("John Doe"), new Email("john@email.com"),
        new Telephone("1234567890"), new Id("asd123"), 0));
    members.add(new Member(new Name("Jane Doe"), new Email("jane@email.com"), new Telephone("1234567899"),
        new Id("asd123"), 1));
    members.add(
        new Member(new Name("Chris"), new Email("chris@email.com"), new Telephone("1234567111"), new Id("asd123"), 2));

    return members;
  }

  @Override
  public void persistMembersBeforeExit(List<Member> members) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'persistMembersBeforeExit'");
  }

}
