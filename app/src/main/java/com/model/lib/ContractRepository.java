package com.model.lib;

import com.model.Contract;
import com.model.TimeRepository;
import com.model.db.DataHandler;
import com.model.db.DataHardCodedMember;
import java.util.LinkedList;

/**
 * Contract repository.
 */
public class ContractRepository implements ContractRepositories {
  private final LinkedList<Contract> contracts;
  private final DataHandler dataHandler;

  public ContractRepository() {
    this.dataHandler = new DataHardCodedMember();
    this.contracts = new LinkedList<Contract>(dataHandler.getContracts());
  }

  public ContractRepository(LinkedList<Contract> allContracts) {
    this.contracts = createContractList(allContracts);
    this.dataHandler = null;
  }

  private LinkedList<Contract> createContractList(LinkedList<Contract> allContracts) {
    LinkedList<Contract> outContractList = new LinkedList<Contract>();
    for (Contract contract : allContracts) {
      outContractList.add(contract);
    }
    return outContractList;
  }

  @Override
  public Iterable<Contract> getContracts() {
    return new LinkedList<Contract>(contracts);
  }
}
