package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class specifically for breakfast routine functionality
 */
class BreakfastRoutinetest extends BaseFarmtest {

    @Test
    @DisplayName("Breakfast routine should complete without exceptions")
    void testBreakfastRoutineCompletesSuccessfully() {
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runBreakfastRoutine());
    }

    @Test
    @DisplayName("Breakfast routine should include proper messaging")
    void testBreakfastRoutineIncludesProperMessaging() {
        farmSimulation.runBreakfastRoutine();
        
        assertOutputContains(
            "---Breakfast Routine---",
            "Time to eat breakfast!",
            "Breakfast complete!"
        );
    }

    @Test
    @DisplayName("Breakfast routine should have proper section formatting")
    void testBreakfastRoutineFormatting() {
        farmSimulation.runBreakfastRoutine();
        String output = getOutput();
        
        // Check for proper section dividers
        assertTrue(output.contains("------------------------"));
        assertTrue(output.contains("---Breakfast Routine---"));
    }

    @Test
    @DisplayName("Breakfast routine should be relatively quick")
    void testBreakfastRoutineDuration() {
        long startTime = System.currentTimeMillis();
        farmSimulation.runBreakfastRoutine();
        long duration = System.currentTimeMillis() - startTime;
        
        // Breakfast should complete quickly (less than 1 second)
        assertTrue(duration < 1000, "Breakfast routine should complete quickly");
    }

    @Test
    @DisplayName("Breakfast routine should produce meaningful output")
    void testBreakfastRoutineOutput() {
        farmSimulation.runBreakfastRoutine();
        String output = getOutput();
        
        // Should have substantial output (more than just headers)
        assertTrue(output.length() > 100, "Breakfast routine should produce meaningful output");
        
        // Should contain some indication of eating
        assertTrue(output.contains("eat") || output.contains("Eat") || 
                  output.contains("breakfast") || output.contains("Breakfast"));
    }
}
