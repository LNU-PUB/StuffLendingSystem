package com.model.db;

import com.model.Member;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the data.json file.
 */
public class DataJsonHandler implements DataHandlerMember {

  /**
   * Gets the data from the Members.json file in resources.
   *
   * @return - List of Member objects.
   */
  @Override
  public List<Member> getMembers() {
    return (List<Member>) new ArrayList<Member>();
  }

  /**
   * Stores the data in the Members.json file in resources.
   *
   * @param members - List of Member objects.
   * @return - True if successful, false otherwise.
   */
  @Override
  public boolean storeMembers(List<Member> members) {
    return true;
  }
}
