package com.zipcodewilmington.froilansfarm.StructureTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.zipcodewilmington.froilansfarm.structures.Stable;
import com.zipcodewilmington.froilansfarm.model.Horse;

public class StableTest {
    
    @Test
    public void testStableOperations() {
        System.out.println("\n--- Testing Stable Class ---");
        Stable stable = new Stable("Main Stable");
        
        assertNotNull(stable, "Stable should be created");
        assertEquals("Main Stable", stable.getName(), "Stable name should match");
        assertEquals(0, stable.getHorses().size(), "Stable should start empty");
        
        // Test adding horses
        Horse horse1 = new Horse("Thunder");
        stable.addHorse(horse1);
        assertEquals(1, stable.getHorses().size(), "Should have 1 horse after adding");
        
        stable.cleanStructure();
        System.out.println("Stable test complete.");
    }
}
