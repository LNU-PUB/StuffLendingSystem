package com.model.lib;

import com.model.Contract;
import com.model.Item;
import com.model.Member;

/**
 * Contract repository interface.
 */
public interface ContractRepositories {
  /**
   * Gets all contracts.
   *
   * @return - all contracts.
   */
  Iterable<Contract> getContracts();

  /**
   * Gets all contracts by owner.
   *
   * @param owner - the owner.
   * @return - all contracts by owner.
   */
  Iterable<Contract> getContractsByOwner(Member owner);

  /**
   * Gets all contracts by borrower.
   *
   * @param borrower - the borrower.
   * @return - all contracts by borrower.
   */
  Iterable<Contract> getContractsByBorrower(Member borrower);

  /**
   * Gets all contracts by item.
   *
   * @param item - the item.
   * @return - all contracts by item.
   */
  Iterable<Contract> getContractsByItem(Item item);

  /**
   * Adds a new contract.
   *
   * @param contractData - the contract data.
   * @return - the new contract.
   */
  Contract addNewContract(BasicContractData contractData);

  /**
   * Updates a contract.
   *
   * @param newContractData - the new contract data.
   * @param oldContract     - the old contract.
   * @return - the updated contract.
   */
  Contract updateContract(BasicContractData newContractData, Contract oldContract);

  /**
   * Deletes a contract.
   *
   * @param contractToDelete - the contract to delete.
   * @return - true if the contract was deleted, false otherwise.
   */
  boolean deleteContract(Contract contractToDelete);
}
