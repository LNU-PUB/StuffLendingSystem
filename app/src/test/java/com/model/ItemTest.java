package com.model;

import static org.junit.jupiter.api.Assertions.*;

import com.model.lib.ItemCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ItemTest {
  Member borrower;
  Item noContractItem;

  @BeforeEach
  public void setUp() {
    Member owner1 = new Member("ownerId", "Owner Name", "owner@example.com", "1234567890", 100);
    this.borrower = new Member("borrowerId", "Borrower Name", "borrower@test.com", "0987654321", 101);
    this.noContractItem = new Item("1", owner1, "Item Name", ItemCategory.SPORT, "Description", 10.0, 200, null);
  }

  @Test
  public void testItemCreation() {
    Member owner = new Member("ownerId", "Owner Name", "owner@example.com", "1234567890", 100);
    Contract contract = new Contract("contract1", owner, noContractItem, borrower, 200, 201);
    Item item = new Item("1", owner, "Item Name", ItemCategory.TOOL, "Description", 10.0, 200, contract);

    assertNotNull(item, "Item should be instantiated");
    assertEquals("1", item.getId(), "ID should match");
    assertEquals(owner, item.getOwner(), "Owner should match");
    assertEquals("Item Name", item.getName(), "Name should match");
    assertEquals(ItemCategory.TOOL, item.getCategory(), "Category should match");
    assertEquals("Description", item.getDescription(), "Description should match");
    assertEquals(10.0, item.getCostPerDay(), "Cost per day should match");
    assertEquals(200, item.getCreationDay(), "Creation day should match");
    assertEquals(contract, item.getCurrentContract(), "Contract should match");
  }

  @Test
  public void testCopyConstructor() {
    Member owner = new Member("ownerId", "Owner Name", "owner@example.com", "1234567890", 100);
    Contract contract = new Contract("contract1", owner, noContractItem, borrower, 200, 201);
    Item originalItem = new Item("1", owner, "Item Name", ItemCategory.SPORT, "Description", 10.0, 200, contract);
    Item copiedItem = new Item(originalItem);

    assertEquals(originalItem, copiedItem, "Copied item should be equal to the original item");
  }

  @Test
  public void testEquals() {
    Member owner = new Member("ownerId", "Owner Name", "owner@example.com", "1234567890", 100);
    Contract contract = new Contract("contract1", owner, noContractItem, borrower, 200, 201); // Initialize
                                                                                              // appropriately
    Item item1 = new Item("1", owner, "Item Name", ItemCategory.SPORT, "Description", 10.0, 200, contract);
    Item item2 = new Item("1", owner, "Item Name", ItemCategory.SPORT, "Description", 10.0, 200, contract);
    Item item3 = new Item("2", owner, "Another Item", ItemCategory.TOOL, "Another Description", 15.0, 201, contract);

    assertTrue(item1.equals(item2), "Items with the same content should be equal");
    assertFalse(item1.equals(item3), "Different items should not be equal");
  }

  @Test
  public void testHashCode() {
    Member owner = new Member("ownerId", "Owner Name", "owner@example.com", "1234567890", 100);
    Contract contract = new Contract("contract1", owner, noContractItem, borrower, 200, 201); // Initialize
                                                                                              // appropriately
    Item item1 = new Item("1", owner, "Item Name", ItemCategory.SPORT, "Description", 10.0, 200, contract);
    Item item2 = new Item("1", owner, "Item Name", ItemCategory.SPORT, "Description", 10.0, 200, contract);

    assertEquals(item1.hashCode(), item2.hashCode(), "Hash codes should be equal for equal items");
  }

  @Test
    public void testItemImmutabilityWithAdditionalChecks() {
        Member owner = new Member("ownerId", "Owner", "owner@example.com", "1234567890", 100);
        Contract contract = new Contract("contractId", owner, new Item("item2Id", owner, "Another Item", ItemCategory.TOOL, "Another Description", 15.0, 300, null), owner, 400, 500); 
        Item item = new Item("itemId", owner, "Item Name", ItemCategory.SPORT, "Description", 10.0, 300, contract);

        // Check for defensive copying in returned Member instances
        Member fetchedOwner = item.getOwner();
        assertNotSame(owner, fetchedOwner, "Fetched owner should be a defensive copy.");
        assertEquals(owner.getId(), fetchedOwner.getId(), "Fetched owner's ID should match original.");
        // Assuming Member class fields are final and there are no setter methods,
        // there's no need to check for modifications to fetchedOwner affecting item's owner.

        // Check for defensive copying in returned Contract instances
        Contract fetchedContract = item.getCurrentContract();
        assertNotSame(contract, fetchedContract, "Fetched contract should be a defensive copy.");
        // Verify fetchedContract modifications do not affect the original item's contract
        // This step is conceptual because Contract class fields are final; direct modification isn't possible without setters.

        // Verify Item immutability does not expose mutable internal state
        assertEquals("Item Name", item.getName(), "Item name should remain unchanged.");
        assertEquals(ItemCategory.SPORT, item.getCategory(), "Item category should remain unchanged.");
        assertEquals("Description", item.getDescription(), "Item description should remain unchanged.");
        assertEquals(10.0, item.getCostPerDay(), "Item cost per day should remain unchanged.");
        assertEquals(300, item.getCreationDay(), "Item creation day should remain unchanged.");

        // Additional checks could include testing the immutability of the Member and Contract classes themselves,
        // as their immutability directly affects the immutability of the Item class.
        // For example, attempting to modify the 'owner' after fetching it from 'item' should not be possible
        // if Member is truly immutable. Similar checks would apply to Contract if it contained mutable references.
    }
}
