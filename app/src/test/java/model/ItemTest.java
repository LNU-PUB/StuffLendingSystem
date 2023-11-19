package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ItemTest {

  @Test
  public void shouldReturnCorrectDataFromGetters() {
    // Given
    ItemCategories category = ItemCategories.GAME;
    String name = "Test Name";
    String description = "Test Description";
    int creationDay = 1;
    int dailyLendingCost = 2;
    Item item = new Item(category, name, description, creationDay, dailyLendingCost);

    ItemCategories actualCategory = item.getCategory();
    String actualName = item.getName();
    String actualDescription = item.getDescription();
    int actualCreationDay = item.getCreationDay();
    int actualDailyLendingCost = item.getDailyLendingCost();

    assertAll("item",
        () -> assertEquals(actualCategory, category),
        () -> assertEquals(actualName, name),
        () -> assertEquals(actualDescription, description),
        () -> assertEquals(actualCreationDay, creationDay),
        () -> assertEquals(actualDailyLendingCost, dailyLendingCost));
  }

  @Test
  public void shouldThrowExceptionWhenCreationDayIsNegative() {
    // Given
    ItemCategories category = ItemCategories.GAME;
    String name = "Test Name";
    String description = "Test Description";
    int creationDay = -1;
    int dailyLendingCost = 2;

    assertThrows(IllegalArgumentException.class,
        () -> new Item(category, name, description, creationDay, dailyLendingCost));
  }

  @Test
  public void shouldThrowExceptionWhenDailyLendingCostIsNegative() {
    // Given
    ItemCategories category = ItemCategories.GAME;
    String name = "Test Name";
    String description = "Test Description";
    int creationDay = 1;
    int dailyLendingCost = -2;

    assertThrows(IllegalArgumentException.class,
        () -> new Item(category, name, description, creationDay, dailyLendingCost));
  }
}
