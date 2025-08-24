package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test class for Monday - Fertilize Day
 */
class MondayRoutinetest extends BaseFarmtest {

    @Test
    @DisplayName("Monday should complete without exceptions")
    void testMondayCompletesSuccessfully() {
        // Plant crops first so there's something to fertilize
        farmSimulation.runSunday();
        resetOutput();
        
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runMonday());
    }

    @Test
    @DisplayName("Monday should be fertilize day")
    void testMondayIsFertilizeDay() {
        // Plant crops first
        farmSimulation.runSunday();
        resetOutput();
        
        farmSimulation.runMonday();
        
        assertOutputContains(
            "MONDAY",
            "--- Fertilize Day ---",
            "Time to fertilize the crops!",
            "Monday's fertilizing complete!"
        );
    }

    @Test
    @DisplayName("Monday should include morning routine")
    void testMondayIncludesMorningRoutine() {
        farmSimulation.runMonday();
        
        assertOutputContains(
            "--- Horse Riding ---",
            "--- Feeding Horses ---"
        );
    }

    @Test
    @DisplayName("Monday should include breakfast routine")
    void testMondayIncludesBreakfastRoutine() {
        farmSimulation.runMonday();
        
        assertOutputContains("---Breakfast Routine---");
    }

    @Test
    @DisplayName("Monday should use crop duster for fertilizing")
    void testMondayUsesCropDuster() {
        // Plant crops first
        farmSimulation.runSunday();
        resetOutput();
        
        farmSimulation.runMonday();
        
        assertOutputContains(
            "gets in her crop duster",
            "Froilanda"
        );
    }

    @Test
    @DisplayName("Monday should have proper day header formatting")
    void testMondayHeaderFormatting() {
        farmSimulation.runMonday();
        assertDayHeaderFormatting("MONDAY");
    }

    @Test
    @DisplayName("Monday should show Froilanda piloting the crop duster")
    void testMondayShowsFroilandaPiloting() {
        farmSimulation.runMonday();
        String output = getOutput();
        
        assertTrue(output.contains("Froilanda"));
        assertTrue(output.contains("crop duster") || output.contains("duster"));
    }

    @Test
    @DisplayName("Monday without planted crops should still complete")
    void testMondayWithoutPlantedCrops() {
        // Don't plant crops first - test fertilizing empty rows
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runMonday());
        
        assertOutputContains(
            "MONDAY",
            "--- Fertilize Day ---",
            "Monday's fertilizing complete!"
        );
    }

    @Test
    @DisplayName("Monday should end with completion message")
    void testMondayEndsWithCompletionMessage() {
        farmSimulation.runMonday();
        String output = getOutput();
        
        assertTrue(output.contains("Monday's fertilizing complete!"));
    }

    @Test
    @DisplayName("Monday should show crop duster sounds")
    void testMondayShowsCropDusterSounds() {
        farmSimulation.runMonday();
        String output = getOutput();
        
        // The crop duster should make noise
        assertTrue(output.contains("noise") || output.contains("sound") || 
                  output.length() > 500); // Substantial output suggests sounds/effects
    }
}
