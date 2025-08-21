// AircraftTest.java
package com.zipcodewilmington.froilansfarm.ModelTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.zipcodewilmington.froilansfarm.model.Aircraft;

public class AircraftTest {
    
    @Test
    public void testAircraftOperations() {
        System.out.println("\n--- Testing Aircraft Class ---");
        Aircraft aircraft = new Aircraft("Sky Cruiser");
        
        // Test basic vehicle operations
        assertNotNull(aircraft, "Aircraft should be created");
        assertEquals("Sky Cruiser", aircraft.getName(), "Aircraft name should match");
        
        aircraft.makeNoise();
        aircraft.fly();
        aircraft.performMaintenance();
        
        System.out.println("Aircraft test complete.");
    }
}