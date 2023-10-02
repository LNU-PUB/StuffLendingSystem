package model.lib;

import model.Member;
import java.util.List;


public interface DataHandlingStrategy {
  
  public List<Member> loadMembers();

  public void persistMembersBeforeExit(List<Member> members);
}
