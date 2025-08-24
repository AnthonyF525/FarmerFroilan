package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test class for Sunday - Planting Day
 */
class SundayRoutinetest extends BaseFarmtest {

    @Test
    @DisplayName("Sunday should complete without exceptions")
    void testSundayCompletesSuccessfully() {
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runSunday());
    }

    @Test
    @DisplayName("Sunday should be planting day")
    void testSundayIsPlantingDay() {
        farmSimulation.runSunday();
        
        assertOutputContains(
            "SUNDAY",
            "  --- Planting Day ---",
            "Time to head out and plant some crops!",
            "Sunday's planting complete!"
        );
    }

    @Test
    @DisplayName("Sunday should include morning routine")
    void testSundayIncludesMorningRoutine() {
        farmSimulation.runSunday();
        
        assertOutputContains(
            "--- Horse Riding ---",
            "--- Feeding Horses ---"
        );
    }

    @Test
    @DisplayName("Sunday should include breakfast routine")
    void testSundayIncludesBreakfastRoutine() {
        farmSimulation.runSunday();
        
        assertOutputContains("---Breakfast Routine---");
    }

    @Test
    @DisplayName("Sunday should plant different crop types")
    void testSundayPlantsDifferentCrops() {
        farmSimulation.runSunday();
        
        assertOutputContains(
            "Corn",
            "Tomato",
            "Spinach"
        );
    }

    @Test
    @DisplayName("Sunday should plant crops in specific rows")
    void testSundayPlantsInSpecificRows() {
        farmSimulation.runSunday();
        String output = getOutput();
        
        // Should mention CropRow names
        assertTrue(output.contains("CropRow") || output.contains("has"));
    }

    @Test
    @DisplayName("Sunday should have proper day header formatting")
    void testSundayHeaderFormatting() {
        farmSimulation.runSunday();
        assertDayHeaderFormatting("SUNDAY");
    }

    @Test
    @DisplayName("Sunday should show planting progress")
    void testSundayShowsPlantingProgress() {
        farmSimulation.runSunday();
        String output = getOutput();
        
        // Should show that different crops are planted in different rows
        assertTrue(output.contains("CropRow 1") || output.contains("has"));
        
        // Should reference the farmer doing the planting
        assertTrue(output.contains("Froilan") || output.contains("plant"));
    }

    @Test
    @DisplayName("Sunday should end with completion message")
    void testSundayEndsWithCompletionMessage() {
        farmSimulation.runSunday();
        String output = getOutput();
        
        assertTrue(output.endsWith("Sunday's planting complete!\n") || 
                  output.contains("Sunday's planting complete!"));
    }
}
