package com.zipcodewilmington.froilansfarm.StructureTests;

import com.zipcodewilmington.froilansfarm.structures.Stable;
import com.zipcodewilmington.froilansfarm.model.Horse;

public class StableTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Stable Class ---");
        Stable stable = new Stable("Main Stable");
        
        // Test basic operations
        System.out.println("Stable name: " + stable.getName());
        
        // Add horses (assuming Horse class exists)
        // Horse horse1 = new Horse("Thunder");
        // stable.addHorse(horse1);
        
        System.out.println("Number of horses: " + stable.getHorses().size());
        stable.cleanStructure();
        
        System.out.println("Stable test complete.");
    }
}
