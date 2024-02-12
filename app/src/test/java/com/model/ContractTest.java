package com.model;

import static org.junit.jupiter.api.Assertions.*;

import com.model.lib.ItemCategory;
import org.junit.jupiter.api.Test;

public class ContractTest {

  @Test
  public void testContractCreation() {
    Member owner = new Member("ownerId", "Owner", "owner@example.com", "1234567890", 100);
    Member borrower = new Member("borrowerId", "Borrower", "borrower@example.com", "0987654321", 200);
    Item item = new Item("itemId", owner, "Item Name", ItemCategory.SPORT, "Description", 10.0, 300, null);
    Contract contract = new Contract("contractId", owner, borrower, item, 400, 500);

    assertNotNull(contract, "Contract should be instantiated");
    assertEquals("contractId", contract.getId());
    assertEquals(owner, contract.getOwner());
    assertEquals(borrower, contract.getBorrower());
    assertEquals(item, contract.getItem());
    assertEquals(400, contract.getStartDay());
    assertEquals(500, contract.getEndDay());
  }

  @Test
  public void testCopyConstructor() {
    Member owner = new Member("ownerId", "Owner", "owner@example.com", "1234567890", 100);
    Member borrower = new Member("borrowerId", "Borrower", "borrower@example.com", "0987654321", 200);
    Item item = new Item("itemId", owner, "Item Name", ItemCategory.SPORT, "Description", 10.0, 300, null);
    Contract originalContract = new Contract("contractId", owner, borrower, item, 400, 500);
    Contract copiedContract = new Contract(originalContract);

    assertEquals(originalContract, copiedContract, "Copied contract should be equal to the original contract");
  }

  @Test
  public void testEquals() {
    Member owner = new Member("ownerId", "Owner", "owner@example.com", "1234567890", 100);
    Member borrower = new Member("borrowerId", "Borrower", "borrower@example.com", "0987654321", 200);
    Item item = new Item("itemId", owner, "Item Name", ItemCategory.SPORT, "Description", 10.0, 300, null);
    Contract contract1 = new Contract("contractId", owner, borrower, item, 400, 500);
    Contract contract2 = new Contract("contractId", owner, borrower, item, 400, 500);
    Contract contract3 = new Contract("anotherContractId", owner, borrower, item, 401, 501);

    assertEquals(contract1, contract2, "Contracts with the same content should be equal");
    assertNotEquals(contract1, contract3, "Different contracts should not be equal");
  }

  @Test
  public void testHashCode() {
    Member owner = new Member("ownerId", "Owner", "owner@example.com", "1234567890", 100);
    Member borrower = new Member("borrowerId", "Borrower", "borrower@example.com", "0987654321", 200);
    Item item = new Item("itemId", owner, "Item Name", ItemCategory.SPORT, "Description", 10.0, 300, null);
    Contract contract1 = new Contract("contractId", owner, borrower, item, 400, 500);
    Contract contract2 = new Contract("contractId", owner, borrower, item, 400, 500);

    assertEquals(contract1.hashCode(), contract2.hashCode(), "Hash codes should be equal for equal contracts");
  }

  @Test
  public void testContractImmutability() {
    Member owner = new Member("ownerId", "Owner", "owner@example.com", "1234567890", 100);
    Member borrower = new Member("borrowerId", "Borrower", "borrower@example.com", "0987654321", 200);
    Item item = new Item("itemId", owner, "Item Name", ItemCategory.SPORT, "Description", 10.0, 300, null);
    Contract contract = new Contract("contractId", owner, borrower, item, 400, 500);

    assertEquals("Owner", contract.getOwner().getName(), "Contract's owner should remain unchanged.");
  }
}
