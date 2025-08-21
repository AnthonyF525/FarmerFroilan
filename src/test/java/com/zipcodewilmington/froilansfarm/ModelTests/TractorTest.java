// TractorTest.java
package com.zipcodewilmington.froilansfarm.ModelTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.zipcodewilmington.froilansfarm.model.Tractor;
import com.zipcodewilmington.froilansfarm.model.CornStalk;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class TractorTest {
    
    @Test
    public void testTractorOperations() {
        System.out.println("\n--- Testing Tractor Class ---");
        Tractor tractor = new Tractor("John Deere");
        
        // Test basic operations
        assertNotNull(tractor, "Tractor should be created");
        tractor.makeNoise();
        tractor.operateOnFarm();
        
        System.out.println("Tractor test complete.");
    }
    
    @Test
    public void testTractorHarvesting() {
        Tractor tractor = new Tractor("John Deere");
        CornStalk corn = new CornStalk("Corn 1");
        
        // Test harvesting unfertilized crop
        Edible harvested1 = tractor.harvest(corn);
        assertNull(harvested1, "Should not harvest unfertilized crop");
        
        // Test harvesting fertilized crop
        corn.fertilize();
        Edible harvested2 = tractor.harvest(corn);
        assertNotNull(harvested2, "Should harvest fertilized crop");
        assertEquals("Corn", harvested2.getName(), "Should produce corn");
        
        System.out.println("Tractor harvesting test complete.");
    }
}
