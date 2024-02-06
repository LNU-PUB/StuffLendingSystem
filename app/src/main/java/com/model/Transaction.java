package com.model;

import com.model.lib.Identifiable;

/**
 * Represents a transaction.
 */
public class Transaction implements Identifiable {
  private final String id;

  /**
   * Constructor.
   *
   * @param id - the unique id of the transaction.
   */
  public Transaction(String id) {
    this.id = id;
  }

  @Override
  public String getId() {
    return id;
  }
  
}
