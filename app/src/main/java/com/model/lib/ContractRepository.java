package com.model.lib;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.db.DataHandler;
import com.model.db.HardCodedData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Contract repository.
 */
public class ContractRepository implements ContractRepositories {
  private final LinkedList<Contract> contracts;
  private final DataHandler dataHandler;

  /**
   * Creates a new ContractRepository object.
   */
  public ContractRepository() {
    this.dataHandler = new HardCodedData();
    this.contracts = new LinkedList<Contract>(dataHandler.getContracts());
  }

  /**
   * Creates a new ContractRepository object.
   *
   * @param allContracts - all contracts.
   */
  public ContractRepository(LinkedList<Contract> allContracts) {
    this.contracts = createContractList(allContracts);
    this.dataHandler = null;
  }

  @Override
  public Iterable<Contract> getContracts() {
    return new LinkedList<Contract>(contracts);
  }

  @Override
  public Iterable<Contract> getContractsByOwner(Member owner) {
    List<Contract> outList = new ArrayList<>();

    for (Contract contract : contracts) {
      if (contract.getOwner().equals(owner)) {
        outList.add(contract);
      }
    }

    return outList;
  }

  @Override
  public Iterable<Contract> getContractsByBorrower(Member borrower) {
    List<Contract> outList = new ArrayList<>();

    for (Contract contract : contracts) {
      if (contract.getBorrower().equals(borrower)) {
        outList.add(contract);
      }
    }

    return outList;
  }

  @Override
  public Iterable<Contract> getContractsByItem(Item item) {
    List<Contract> outList = new ArrayList<>();

    for (Contract contract : contracts) {
      if (contract.getItem().equals(item)) {
        outList.add(contract);
      }
    }

    return outList;
  }

  @Override
  public Contract addNewContract(BasicContractData contractData) {
    IdGenerator<Contract> generator = new IdGenerator<>();
    String id = generator.generateId(contracts);

    Contract newContract = new Contract(id, contractData.getOwner(), contractData.getBorrower(),
        contractData.getItem(), contractData.getStartDay(), contractData.getEndDay());

    synchronized (this) {
      contracts.add(newContract);
    }

    return new Contract(newContract);
  }

  @Override
  public Contract updateContract(BasicContractData newContractData, Contract oldContract) {
    Item item = newContractData.getItem();
    int startDay = newContractData.getStartDay();
    int endDay = newContractData.getEndDay();

    synchronized (this) {
      String id = oldContract.getId();
      Member owner = oldContract.getOwner();
      Member borrower = oldContract.getBorrower();

      Contract updatedContract = new Contract(id, owner, borrower, item, startDay, endDay);
      replaceContractInList(updatedContract, oldContract);

      return new Contract(updatedContract);
    }

  }

  @Override
  public boolean deleteContract(Contract contractToDelete) {
    for (Contract c : contracts) {
      if (c.equals(contractToDelete)) {
        contracts.remove(c);
        return true;
      }
    }

    return false;
  }

  // ***** Helper functions *****

  private LinkedList<Contract> createContractList(LinkedList<Contract> allContracts) {
    LinkedList<Contract> outContractList = new LinkedList<Contract>();
    for (Contract contract : allContracts) {
      outContractList.add(new Contract(contract));
    }
    return outContractList;
  }

  private void replaceContractInList(Contract updatedContract, Contract oldContract) {
    for (int i = 0; i < contracts.size(); i++) {
      if (contracts.get(i).equals(oldContract)) {
        contracts.set(i, updatedContract);
        return;
      }
    }
  }
}
