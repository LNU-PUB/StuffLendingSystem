package model.lib;

import java.util.List;
import model.Member;

/**
 * Responsible for performing operations on members.
 */ 
public interface DataHandlingStrategy {
  
  public List<Member> loadMembers();

  public void persistMembersBeforeExit(List<Member> members);
}
