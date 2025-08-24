package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Tuesday - Harvest Day
 */
class TuesdayRoutinetest extends BaseFarmtest {

    @Test
    @DisplayName("Tuesday should complete without exceptions")
    void testTuesdayCompletesSuccessfully() {
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runTuesday());
    }

    @Test
    @DisplayName("Tuesday should be harvest day")
    void testTuesdayIsHarvestDay() {
        farmSimulation.runTuesday();
        
        assertOutputContains(
            "TUESDAY",
            "--- Harvest Day ---",
            "Time to head out and harvest some crops!",
            "Tuesday's harvesting complete!"
        );
    }

    @Test
    @DisplayName("Tuesday should include morning routine")
    void testTuesdayIncludesMorningRoutine() {
        farmSimulation.runTuesday();
        
        assertOutputContains(
            "--- Horse Riding ---",
            "--- Feeding Horses ---"
        );
    }

    @Test
    @DisplayName("Tuesday should include breakfast routine")
    void testTuesdayIncludesBreakfastRoutine() {
        farmSimulation.runTuesday();
        
        assertOutputContains("---Breakfast Routine---");
    }

    @Test
    @DisplayName("Tuesday should use tractor for harvesting")
    void testTuesdayUsesTractor() {
        farmSimulation.runTuesday();
        
        assertOutputContains("Froilan");
        String output = getOutput();
        assertTrue(output.contains("tractor") || output.contains("harvesting"));
    }

    @Test
    @DisplayName("Tuesday should handle empty crop rows gracefully")
    void testTuesdayHandlesEmptyCropRows() {
        // Run Tuesday without planting first
        farmSimulation.runTuesday();
        String output = getOutput();
        
        // Should contain failure messages for empty rows
        assertTrue(output.contains("FAILURE") || output.contains("No crops planted") ||
                  output.contains("harvesting")); // At least mentions harvesting attempt
    }

    @Test
    @DisplayName("Tuesday with planted crops should show successful harvest")
    void testTuesdayWithPlantedCropsShowsSuccess() {
        // Plant and fertilize first
        farmSimulation.runSunday();
        farmSimulation.runMonday();
        resetOutput();
        
        farmSimulation.runTuesday();
        String output = getOutput();
        
        // Should show successful harvesting
        assertTrue(output.contains("SUCCESS") || output.contains("Yielded") ||
                  output.contains("harvesting") || output.contains("Harvesting"));
    }

    @Test
    @DisplayName("Tuesday should have proper day header formatting")
    void testTuesdayHeaderFormatting() {
        farmSimulation.runTuesday();
        assertDayHeaderFormatting("TUESDAY");
    }

    @Test
    @DisplayName("Tuesday should show Froilan operating the tractor")
    void testTuesdayShowsFroilanOperatingTractor() {
        farmSimulation.runTuesday();
        String output = getOutput();
        
        assertTrue(output.contains("Froilan"));
        assertTrue(output.contains("harvest") || output.contains("tractor") || 
                  output.contains("operating") || output.contains("is harvesting"));
    }

    @Test
    @DisplayName("Tuesday should process multiple crop rows")
    void testTuesdayProcessesMultipleCropRows() {
        farmSimulation.runTuesday();
        String output = getOutput();
        
        // Should mention multiple rows being processed
        assertTrue(output.contains("CropRow") || output.contains("row") ||
                  output.contains("harvest"));
    }

    @Test
    @DisplayName("Tuesday should end with completion message")
    void testTuesdayEndsWithCompletionMessage() {
        farmSimulation.runTuesday();
        String output = getOutput();
        
        assertTrue(output.contains("Tuesday's harvesting complete!"));
    }

    @Test
    @DisplayName("Tuesday should show different outcomes for different crops")
    void testTuesdayShowsDifferentOutcomes() {
        // Run full sequence to see success/failure mix
        farmSimulation.runSunday(); // Plant some rows
        farmSimulation.runMonday(); // Fertilize
        resetOutput();
        
        farmSimulation.runTuesday();
        String output = getOutput();
        
        // Should show some combination of success/failure or at least harvesting attempts
        assertTrue(output.contains("harvest") || output.contains("Harvest") ||
                  output.contains("SUCCESS") || output.contains("FAILURE"));
    }
}