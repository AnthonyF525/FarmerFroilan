package com.zipcodewilmington.froilansfarm.InterfaceTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.zipcodewilmington.froilansfarm.model.*;

public class EdibleTest {
    
    @Test
    public void testEdibleItems() {
        System.out.println("\n--- Testing Edible Classes ---");
        
        EdibleEgg egg = new EdibleEgg();
        EarCorn corn = new EarCorn();
        Tomato tomato = new Tomato();
        
        // Test names
        assertEquals("Egg", egg.getName(), "Egg name should be correct");
        assertEquals("Corn", corn.getName(), "Corn name should be correct");
        assertEquals("Tomato", tomato.getName(), "Tomato name should be correct");
        
        // Test nutritional values
        assertEquals(5, egg.getNutritionalValue(), "Egg nutrition should be 5");
        assertEquals(4, corn.getNutritionalValue(), "Corn nutrition should be 4");
        assertEquals(2, tomato.getNutritionalValue(), "Tomato nutrition should be 2");
        
        // Test calories
        assertTrue(egg.getNutritionalValue() > 0, "Egg should have calories");
        assertTrue(corn.getNutritionalValue() > 0, "Corn should have calories");
        assertTrue(tomato.getNutritionalValue() > 0, "Tomato should have calories");
        
        System.out.println("Edible test complete.");
    }
}