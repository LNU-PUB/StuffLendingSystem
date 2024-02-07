package com.model.lib;

import com.model.Member;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Basic item data test.
 */
public class BasicItemDataTest {

    @Test
    public void testConstructorAndFieldInitialization() {
        Member mockedOwner = mock(Member.class); 
        String name = "Test Item";
        ItemCategory category = ItemCategory.GAME;
        String description = "Test Description";
        double costPerDay = 1.5;
        int creationDay = 100;

        BasicItemData itemData = new BasicItemData(mockedOwner, name, category, description, costPerDay, creationDay);

        assertEquals(mockedOwner, itemData.getOwner(), "Owner does not match.");
        assertEquals(name, itemData.getName(), "Name does not match.");
        assertEquals(category, itemData.getCategory(), "Category does not match.");
        assertEquals(description, itemData.getDescription(), "Description does not match.");
        assertEquals(costPerDay, itemData.getCostPerDay(), "Cost per day does not match.");
        assertEquals(creationDay, itemData.getCreationDay(), "Creation day does not match.");
        assertEquals(null, itemData.getCurrentContract(), "Current contract should be null.");
    }
}
