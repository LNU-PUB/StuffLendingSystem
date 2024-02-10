package com.model.lib;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.model.Item;
import com.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

  private ItemRepository sut;
  private BasicItemData validItemData;
  private Member member;

  @BeforeEach
  void setUp() {
    sut = new ItemRepository();
    member = mock(Member.class);
    validItemData = new BasicItemData(member, "item name", ItemCategory.TOOL, "item description", 1.23, 1);
  }

  @Test
  void testAddItem() {
    Item addedItem = sut.addItem(validItemData);

    assertNotNull(addedItem);
    assertEquals(validItemData.getOwner().getId(), addedItem.getOwner().getId());
    assertEquals(validItemData.getName(), addedItem.getName());
    assertEquals(validItemData.getCategory(), addedItem.getCategory());
    assertEquals(validItemData.getDescription(), addedItem.getDescription());
    assertEquals(validItemData.getCostPerDay(), addedItem.getCostPerDay());
    assertEquals(validItemData.getCreationDay(), addedItem.getCreationDay());
  }

  // Note: Testing for invalid input => other inputs are valid implicitly.
  @Test
  void testValidateNameWithInvalidName() {
    assertFalse(sut.validateName(""));
    assertFalse(sut.validateName(null));
    Item addedItem = sut.addItem(validItemData);
    assertFalse(sut.validateName(addedItem.getName()));
  }

  @Test
  void testValidateDescriptionWithInvalidDescription() {
    assertFalse(sut.validateDescription(null));
    assertFalse(sut.validateDescription(""));
  }

  @Test
  void testValidateCostPerDayWithInvalidCost() {
    assertFalse(sut.validateCostPerDay(-1));
  }

  @Test
  void testUpdateItem() {
    Item originalItem = sut.addItem(validItemData);
    BasicItemData updatedData = new BasicItemData(member, "updated item name", ItemCategory.GAME,
        "item description updated", 12.23, 1);
    Item updatedItem = sut.updateItem(updatedData, originalItem);

    assertNotNull(updatedItem);
    assertEquals(updatedData.getName(), updatedItem.getName());
    assertEquals(updatedData.getCategory(), updatedItem.getCategory());
    assertEquals(updatedData.getDescription(), updatedItem.getDescription());
    assertEquals(updatedData.getCostPerDay(), updatedItem.getCostPerDay());
  }

  @Test
  void testGetItemsByMember() {
    Member newMember = new Member("id", "name", "email", "mobile", 1);
    sut.addItem(validItemData);
    BasicItemData newItemData = new BasicItemData(newMember, "new item name", ItemCategory.SPORT,
        "new item description", 10.5, 0);
    sut.addItem(newItemData);

    Iterable<Item> items = sut.getItemsByMember(newMember);
    assertTrue(items.iterator().hasNext());
    Item testItem = items.iterator().next();
    assertEquals(newItemData.getName(), testItem.getName());
    assertEquals(newItemData.getCategory(), testItem.getCategory());
    assertEquals(newItemData.getDescription(), testItem.getDescription());
    assertEquals(newItemData.getCostPerDay(), testItem.getCostPerDay());
    assertEquals(newItemData.getOwner().getId(), testItem.getOwner().getId());
    assertEquals(newItemData.getCreationDay(), testItem.getCreationDay());
  }

  @Test
  void testDeleteExistingItem() {
    Item addedItem = sut.addItem(validItemData);
    assertNotNull(addedItem, "The item should be added successfully");

    boolean deleteResult = sut.deleteItem(addedItem);
    assertTrue(deleteResult, "Deleting an existing item should return true");

    // Verify the item is no longer in the repository.
    Item shouldBeNull = sut.getItemById(addedItem.getId());
    assertNull(shouldBeNull, "The deleted item should no longer exist in the repository");
  }

  @Test
  void testDeleteNonExistentItem() {
    // Create an item that is not in the repository.
    Item nonExistentItem = new Item("non-existent-id", member, "Non-Existent Item", ItemCategory.TOOL,
        "Does not exist", 0.0, 0, null);

    boolean deleteResult = sut.deleteItem(nonExistentItem);
    assertFalse(deleteResult, "Attempting to delete a non-existent item should return false");
  }

  @Test
  void testDeleteNullItem() {
    boolean deleteResult = sut.deleteItem(null);
    assertFalse(deleteResult, "Attempting to delete a null item should return false");
  }

}
