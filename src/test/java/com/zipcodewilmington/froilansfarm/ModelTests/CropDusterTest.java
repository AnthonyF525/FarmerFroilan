// CropDusterTest.java
package com.zipcodewilmington.froilansfarm.ModelTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.zipcodewilmington.froilansfarm.model.CropDuster;
import com.zipcodewilmington.froilansfarm.structures.CropRow;
import com.zipcodewilmington.froilansfarm.model.CornStalk;

public class CropDusterTest {
    
    @Test
    public void testCropDusterOperations() {
        System.out.println("\n--- Testing CropDuster Class ---");
        CropDuster duster = new CropDuster("Crop Master");
        
        assertNotNull(duster, "CropDuster should be created");
        assertEquals("Crop Master", duster.getName(), "CropDuster name should match");
        
        duster.makeNoise();
        duster.fly();
        
        System.out.println("CropDuster test complete.");
    }
    
    @Test
    public void testCropDusterFertilizing() {
        CropDuster duster = new CropDuster("Crop Master");
        CropRow row = new CropRow("Row 1");
        CornStalk corn = new CornStalk("Corn 1");
        row.addCrop(corn);
        
        // Test fertilizing
        assertFalse(corn.isHasBeenFertilized(), "Crop should start unfertilized");
        duster.fertilize(row);
        assertTrue(corn.isHasBeenFertilized(), "Crop should be fertilized after dusting");
        
        System.out.println("CropDuster fertilizing test complete.");
    }
}
