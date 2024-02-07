package com.model.lib;

import com.model.Contract;

/**
 * Contract repository interface.
 */
public interface ContractRepositories {

  Iterable<Contract> getContracts();
}
