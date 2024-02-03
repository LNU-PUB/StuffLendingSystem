package com.model.lib;

import com.model.Contract;
import java.util.List;

// We should provide methods to retrieve contracts based on on Member, Category, Status, and Item.
/**
 * Contract Service interface.
 */
public interface ContractServices {
  /**
   * Get a list of all Contracts.
   *
   * @return - list of all Contracts.
   */
  public List<Contract> getAllContracts();

  /**
   * Get an Contract by id.
   *
   * @param id - id for Contract
   * @return - Contract
   */
  public Contract getContractById(String id);

  /**
   * Add a new Contract.
   *
   * @param contract - data for new Contract
   * @return - new Contract
   */
  public Contract newContract(Contract contract);

  /**
   * Delete a Contract.
   *
   * @param contract - contract to delete.
   * @return - true if deleted, false otherwise.
   */
  public boolean deleteContract(Contract contract);
}
