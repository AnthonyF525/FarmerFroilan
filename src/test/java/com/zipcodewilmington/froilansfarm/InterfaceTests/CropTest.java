package com.zipcodewilmington.froilansfarm.InterfaceTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.zipcodewilmington.froilansfarm.model.CornStalk;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class CropTest {
    
    @Test
    public void testCropLifecycle() {
        System.out.println("\n--- Testing Crop Lifecycle ---");
        
        CornStalk corn = new CornStalk("Corn Plant 1");
        
        // Test initial state
        assertFalse(corn.isHasBeenFertilized(), "Crop should start unfertilized");
        assertFalse(corn.isHasBeenHarvested(), "Crop should start unharvested");
        
        // Try to harvest before fertilizing
        Edible produce1 = corn.yieldProduce();
        assertNull(produce1, "Should not harvest unfertilized crop");
        
        // Fertilize and harvest
        corn.fertilize();
        assertTrue(corn.isHasBeenFertilized(), "Crop should be fertilized");
        
        Edible produce2 = corn.yieldProduce();
        assertNotNull(produce2, "Should harvest fertilized crop");
        assertEquals("Corn", produce2.getName(), "Should produce corn");
        assertTrue(corn.isHasBeenHarvested(), "Crop should be marked as harvested");
        
        // Try to harvest again
        Edible produce3 = corn.yieldProduce();
        assertNull(produce3, "Should not harvest already harvested crop");
        
        System.out.println("Crop lifecycle test complete.");
    }
}