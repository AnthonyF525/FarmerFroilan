package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class specifically for morning routine functionality
 */
class MorningRoutineTest extends BaseFarmtest { // Fixed: was "BaseFarmtest"

    @Test
    @DisplayName("Morning routine should complete without exceptions")
    void testMorningRoutineCompletesSuccessfully() {
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runMorningRoutine());
    }

    @Test
    @DisplayName("Morning routine should include horse riding section")
    void testMorningRoutineIncludesHorseRiding() {
        farmSimulation.runMorningRoutine();
        String output = getOutput();
        
        // Check for sections and messages that don't have color codes
        assertTrue(output.contains("--- Horse Riding ---"));
        assertTrue(output.contains("Froilan and Froilanda head out to ride the horses!"));
        
        // Check for completion message (may have color codes)
        assertTrue(output.contains("Morning rides complete!"),
            "Should contain 'Morning rides complete!' but output was: " + output);
    }

    @Test
    @DisplayName("Morning routine should include horse feeding section")
    void testMorningRoutineIncludesHorseFeeding() {
        farmSimulation.runMorningRoutine();
        String output = getOutput();
        
        // Check for sections (these don't have color codes)
        assertTrue(output.contains("--- Feeding Horses ---"));
        assertTrue(output.contains("Froilan and Froilanda head out to feed the horses!"));
        
        // Check for completion message (may have color codes)
        assertTrue(output.contains("Feeding complete!"), 
            "Should contain 'Feeding complete!' but output was: " + output);
    }

    @Test
    @DisplayName("Morning routine should alternate riders for horses")
    void testMorningRoutineAlternatesRiders() {
        farmSimulation.runMorningRoutine();
        String output = getOutput();
        
        // Check for mounting and dismounting actions (these may have color codes around names)
        assertTrue(output.contains("mounts"), "Should contain mounting actions");
        assertTrue(output.contains("dismounts"), "Should contain dismounting actions");
        
        // Check that both riders are mentioned
        assertTrue(output.contains("Froilan") && output.contains("Froilanda"),
            "Should mention both Froilan and Froilanda");
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
        
        // Look for the exact patterns from the original code
        int froilanMounts = countOccurrences(output, "Froilan mounts");
        int froilandaMounts = countOccurrences(output, "Froilanda mounts");
        int froilanDismounts = countOccurrences(output, "Froilan dismounts");
        int froilandaDismounts = countOccurrences(output, "Froilanda dismounts");
        
        int totalMounts = froilanMounts + froilandaMounts;
        int totalDismounts = froilanDismounts + froilandaDismounts;
        
        // Debug information
        System.out.println("Froilan mounts: " + froilanMounts + ", Froilanda mounts: " + froilandaMounts);
        System.out.println("Froilan dismounts: " + froilanDismounts + ", Froilanda dismounts: " + froilandaDismounts);
        System.out.println("Total mounts: " + totalMounts + ", Total dismounts: " + totalDismounts);
        
        // Should have 10 horses total (alternating between riders)
        assertTrue(totalMounts >= 10, "Should mount at least 10 horses, found: " + totalMounts);
        assertTrue(totalDismounts >= 10, "Should dismount at least 10 horses, found: " + totalDismounts);
        assertEquals(totalMounts, totalDismounts, "Mount and dismount counts should be equal");
        
        // Verify both riders are active
        assertTrue(froilanMounts >= 4, "Froilan should mount several horses");
        assertTrue(froilandaMounts >= 4, "Froilanda should mount several horses");
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