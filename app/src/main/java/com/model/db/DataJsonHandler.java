package com.model.db;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the data.json file.
 */
public class DataJsonHandler implements DataHandler {

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

  @Override
  public List<Item> getItems() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getItems'");
  }

  @Override
  public List<Contract> getContracts() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getContracts'");
  }

  @Override
  public boolean storeItems(List<Item> items) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'storeItems'");
  }

  @Override
  public boolean storeContracts(List<Contract> contracts) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'storeContracts'");
  }

  @Override
  public List<Transaction> getTransactions() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getTransactions'");
  }
}
