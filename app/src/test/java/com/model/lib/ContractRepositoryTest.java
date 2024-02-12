package com.model.lib;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.db.DataHandler;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContractRepositoryTest {

  private ContractRepository contractRepository;
  private Member owner, borrower;
  private Item item;
  private Contract contract;
  private Contract contract2;
  private BasicContractData basicContractData;
  private DataHandler dataHandler; // Assuming DataHandler is an interface or class that can be mocked.

  @BeforeEach
  void setUp() {
    // Mock dependencies
    dataHandler = mock(DataHandler.class);
    owner = mock(Member.class);
    borrower = mock(Member.class);
    item = mock(Item.class);
    contract = mock(Contract.class);
    contract2 = mock(Contract.class);
    basicContractData = mock(BasicContractData.class);

    // Stubbing for your mocked objects
    when(dataHandler.getContracts()).thenReturn(new LinkedList<>()); // Assuming getContracts returns a List
    when(contract.getId()).thenReturn("aaa123");
    when(contract.getOwner()).thenReturn(owner);
    when(contract.getBorrower()).thenReturn(borrower);
    when(contract.getItem()).thenReturn(item);
    when(contract.getStartDay()).thenReturn(4);
    when(contract.getEndDay()).thenReturn(6);
    when(contract2.getId()).thenReturn("bbb123");
    when(contract2.getOwner()).thenReturn(owner);
    when(contract2.getBorrower()).thenReturn(borrower);
    when(contract2.getItem()).thenReturn(item);
    when(contract2.getStartDay()).thenReturn(1);
    when(contract2.getEndDay()).thenReturn(3);
    when(basicContractData.getOwner()).thenReturn(owner);
    when(basicContractData.getBorrower()).thenReturn(borrower);
    when(basicContractData.getItem()).thenReturn(item);
    when(basicContractData.getStartDay()).thenReturn(400);
    when(basicContractData.getEndDay()).thenReturn(500);
    when(basicContractData.getOwner()).thenReturn(owner);
    when(basicContractData.getBorrower()).thenReturn(borrower);
    when(basicContractData.getItem()).thenReturn(item);
    when(basicContractData.getStartDay()).thenReturn(400);
    when(basicContractData.getEndDay()).thenReturn(500);

    // Use the real object for the repository but initialized with mocked contracts
    // list
    contractRepository = new ContractRepository(new LinkedList<>(List.of(contract, contract2)));
  }

  @Test
  void testGetContracts() {
    Iterable<Contract> contracts = contractRepository.getContracts();
    assertNotNull(contracts);
    assertTrue(contracts.iterator().hasNext());
  }

  @Test
  void testGetContractsByOwner() {
    Iterable<Contract> contracts = contractRepository.getContractsByOwner(owner);
    assertTrue(contracts.iterator().hasNext());
    for (Contract c : contracts) {
      assertEquals(owner, c.getOwner());
    }
  }

  @Test
  void testGetContractsByBorrower() {
    Iterable<Contract> contracts = contractRepository.getContractsByBorrower(borrower);
    assertTrue(contracts.iterator().hasNext());
    for (Contract c : contracts) {
      assertEquals(borrower, c.getBorrower());
    }
  }

  @Test
  void testGetContractsByItem() {
    Iterable<Contract> contracts = contractRepository.getContractsByItem(item);
    assertTrue(contracts.iterator().hasNext());
    for (Contract c : contracts) {
      assertEquals(item, c.getItem());
    }
  }

  @Test
  void testAddNewContract() {
    when(basicContractData.getStartDay()).thenReturn(600);
    when(basicContractData.getEndDay()).thenReturn(700);

    Contract newContract = contractRepository.addNewContract(basicContractData);
    assertNotNull(newContract);
    assertEquals(600, newContract.getStartDay());
    assertEquals(700, newContract.getEndDay());
  }

  @Test
  void testUpdateContract() {
    when(basicContractData.getStartDay()).thenReturn(800);
    when(basicContractData.getEndDay()).thenReturn(900);

    Contract updatedContract = contractRepository.updateContract(basicContractData, contract);
    assertNotNull(updatedContract);
    assertEquals(800, updatedContract.getStartDay());
    assertEquals(900, updatedContract.getEndDay());
  }

  @Test
  void testDeleteContractSuccess() {
    Member owner = mock(Member.class);
    Member borrower = mock(Member.class);
    Item item = mock(Item.class);
    Contract contract = new Contract("bbb123", owner, borrower, item, 4, 6);
    Contract contract2 = new Contract("aaa123", owner, borrower, item, 1, 3);

    contractRepository = new ContractRepository(new LinkedList<>(List.of(contract, contract2)));

    boolean result = contractRepository.deleteContract(contract);
    assertTrue(result);
  }

  @Test
  void testDeleteContractFailure() {
    Member owner = mock(Member.class);
    Member borrower = mock(Member.class);
    Item item = mock(Item.class);
    Contract contract = new Contract("bbb123", owner, borrower, item, 4, 6);
    Contract contract2 = new Contract("aaa123", owner, borrower, item, 1, 3);
    Contract contract3 = new Contract("ccc123", owner, borrower, item, 1, 3);

    contractRepository = new ContractRepository(new LinkedList<>(List.of(contract, contract2)));

    boolean result = contractRepository.deleteContract(contract3);
    assertFalse(result);
  }
}
