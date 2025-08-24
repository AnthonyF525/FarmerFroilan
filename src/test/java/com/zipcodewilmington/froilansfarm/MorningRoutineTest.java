package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Test class specifically for morning routine functionality
 */
class MorningRoutineTest extends BaseFarmtest {

    @Test
    @DisplayName("Morning routine should complete without exceptions")
    void testMorningRoutineCompletesSuccessfully() {
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runMorningRoutine());
    }

    @Test
    @DisplayName("Morning routine should include horse riding section")
    void testMorningRoutineIncludesHorseRiding() {
        farmSimulation.runMorningRoutine();
        
        assertOutputContains(
            "--- Horse Riding ---",
            "Froilan and Froilanda head out to ride the horses!",
            "Morning rides complete!"
        );
    }

    @Test
    @DisplayName("Morning routine should include horse feeding section")
    void testMorningRoutineIncludesHorseFeeding() {
        farmSimulation.runMorningRoutine();
        
        assertOutputContains(
            "--- Feeding Horses ---",
            "Froilan and Froilanda head out to feed the horses!",
            "Feeding complete!"
        );
    }

    @Test
    @DisplayName("Morning routine should alternate riders for horses")
    void testMorningRoutineAlternatesRiders() {
        farmSimulation.runMorningRoutine();
        
        assertOutputContains(
            "Froilan mounts",
            "Froilanda mounts",
            "dismounts"
        );
    }

    @Test
    @DisplayName("Morning routine should feed horses with corn")
    void testMorningRoutineFeedsHorses() {
        farmSimulation.runMorningRoutine();
        
        assertOutputContains("are feeding");
    }

    @Test
    @DisplayName("Morning routine should have proper section formatting")
    void testMorningRoutineFormatting() {
        farmSimulation.runMorningRoutine();
        String output = getOutput();
        
        // Check for proper section dividers
        assertTrue(output.contains("------------------------"));
        
        // Check that both main sections are present
        assertTrue(output.contains("--- Horse Riding ---"));
        assertTrue(output.contains("--- Feeding Horses ---"));
    }

    @Test
    @DisplayName("Morning routine should handle all horses")
    void testMorningRoutineHandlesAllHorses() {
        farmSimulation.runMorningRoutine();
        String output = getOutput();
        
        // Should have multiple mount/dismount pairs (10 horses total)
        int mountCount = countOccurrences(output, "mounts");
        int dismountCount = countOccurrences(output, "dismounts");
        
        assertTrue(mountCount >= 10, "Should mount at least 10 horses");
        assertTrue(dismountCount >= 10, "Should dismount at least 10 horses");
        assertEquals(mountCount, dismountCount, "Mount and dismount counts should be equal");
    }

    @Test
    @DisplayName("Morning routine should include horse names")
    void testMorningRoutineIncludesHorseNames() {
        farmSimulation.runMorningRoutine();
        String output = getOutput();
        
        // Should contain some of the horse names from the predefined list
        boolean containsHorseNames = output.contains("Jasper") || 
                                   output.contains("Spirit") || 
                                   output.contains("Daisy") ||
                                   output.contains("Lucky");
        
        assertTrue(containsHorseNames, "Output should contain horse names");
    }
}