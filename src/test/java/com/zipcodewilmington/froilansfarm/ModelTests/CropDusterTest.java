// CropDusterTest.java
package com.zipcodewilmington.froilansfarm.ModelTests;

import com.zipcodewilmington.froilansfarm.model.CropDuster;
import com.zipcodewilmington.froilansfarm.structures.CropRow;
import com.zipcodewilmington.froilansfarm.model.CornStalk;

public class CropDusterTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing CropDuster Class ---");
        CropDuster duster = new CropDuster("Crop Master");
        
        // Create a crop row with crops
        CropRow row = new CropRow("Row 1");
        row.addCrop(new CornStalk("Corn 1"));
        row.addCrop(new CornStalk("Corn 2"));
        
        // Test operations
        duster.makeNoise();
        duster.fly();
        duster.fertilize(row);
        
        System.out.println("CropDuster test complete.");
    }
}
