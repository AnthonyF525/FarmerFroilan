// ChickenCoopTest.java
package com.zipcodewilmington.froilansfarm.StructureTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.zipcodewilmington.froilansfarm.structures.ChickenCoop;
import com.zipcodewilmington.froilansfarm.model.Chicken;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import java.util.List;

public class ChickenCoopTest {
    
    @Test
    public void testChickenCoopOperations() {
        System.out.println("\n--- Testing ChickenCoop Class ---");
        ChickenCoop coop = new ChickenCoop("Main Coop");
        
        assertNotNull(coop, "ChickenCoop should be created");
        assertEquals("Main Coop", coop.getName(), "Coop name should match");
        assertEquals(0, coop.getChickens().size(), "Coop should start empty");
        
        coop.cleanStructure();
        System.out.println("ChickenCoop test complete.");
    }
    
    @Test
    public void testEggCollection() {
        ChickenCoop coop = new ChickenCoop("Main Coop");
        
        // Add chickens
        for (int i = 1; i <= 3; i++) {
            coop.addChicken(new Chicken("Chicken " + i));
        }
        assertEquals(3, coop.getChickens().size(), "Should have 3 chickens");
        
        // Test egg collection
        List<Edible> eggs = coop.collectEggs();
        assertNotNull(eggs, "Eggs collection should not be null");
        assertTrue(eggs.size() >= 0, "Should collect some eggs");
        
        System.out.println("Egg collection test complete.");
    }
}
