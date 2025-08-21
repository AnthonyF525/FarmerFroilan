// TractorTest.java
package com.zipcodewilmington.froilansfarm.ModelTests;

import com.zipcodewilmington.froilansfarm.model.Tractor;
import com.zipcodewilmington.froilansfarm.model.CornStalk;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class TractorTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Tractor Class ---");
        Tractor tractor = new Tractor("John Deere");
        
        // Test basic operations
        tractor.makeNoise();
        tractor.operateOnFarm();
        
        // Test harvesting
        CornStalk corn = new CornStalk("Corn 1");
        corn.fertilize(); // Must fertilize before harvest
        Edible harvested = tractor.harvest(corn);
        
        if (harvested != null) {
            System.out.println("Harvested: " + harvested.getName());
        } else {
            System.out.println("Nothing to harvest");
        }
        
        System.out.println("Tractor test complete.");
    }
}
