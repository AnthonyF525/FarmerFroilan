// AircraftTest.java
package com.zipcodewilmington.froilansfarm.ModelTests;

import com.zipcodewilmington.froilansfarm.model.Aircraft;

public class AircraftTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Aircraft Class ---");
        Aircraft aircraft = new Aircraft("Sky Cruiser");
        
        // Test basic vehicle operations
        System.out.println("Aircraft name: " + aircraft.getName());
        aircraft.makeNoise();
        aircraft.fly();
        aircraft.performMaintenance();
        
        System.out.println("Aircraft test complete.");
    }
}