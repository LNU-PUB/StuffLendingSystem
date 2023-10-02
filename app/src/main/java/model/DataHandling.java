package model;

import java.util.List;
import model.lib.DataHandlingStrategy;

public class DataHandling {
  private DataHandlingStrategy strategy;

  public DataHandling(DataHandlingStrategy strategy) {
    this.strategy = strategy;
  }

  public List<Member> loadMembers() {
    return strategy.loadMembers();
  }


  public void persistMembers(List<Member> members) {
    strategy.persistMembersBeforeExit(members);
  }
}
