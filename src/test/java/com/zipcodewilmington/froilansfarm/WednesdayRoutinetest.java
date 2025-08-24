package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Wednesday - Animal Care Day
 */
class WednesdayRoutinetest extends BaseFarmtest {

    @Test
    @DisplayName("Wednesday should complete without exceptions")
    void testWednesdayCompletesSuccessfully() {
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runWednesday());
    }

    @Test
    @DisplayName("Wednesday should be animal care day")
    void testWednesdayIsAnimalCareDay() {
        farmSimulation.runWednesday();
        
        assertOutputContains(
            "WEDNESDAY",
            "--- Animal Care Day ---",
            "Time to clean the animal's structures and check if they are healthy!",
            "Wednesday's animal care complete!"
        );
    }

    @Test
    @DisplayName("Wednesday should include morning routine")
    void testWednesdayIncludesMorningRoutine() {
        farmSimulation.runWednesday();
        
        assertOutputContains(
            "--- Horse Riding ---",
            "--- Feeding Horses ---"
        );
    }

    @Test
    @DisplayName("Wednesday should include breakfast routine")
    void testWednesdayIncludesBreakfastRoutine() {
        farmSimulation.runWednesday();
        
        assertOutputContains("---Breakfast Routine---");
    }

    @Test
    @DisplayName("Wednesday should include stable cleaning")
    void testWednesdayIncludesStableCleaning() {
        farmSimulation.runWednesday();
        
        assertOutputContains(
            "begins cleaning the stables",
            "is cleaning",
            "is finished cleaning"
        );
    }

    @Test
    @DisplayName("Wednesday should include horse health checks")
    void testWednesdayIncludesHorseHealthChecks() {
        farmSimulation.runWednesday();
        
        assertOutputContains("checking if the horses are in good health");
    }

    @Test
    @DisplayName("Wednesday should include chicken coop cleaning")
    void testWednesdayIncludesChickenCoopCleaning() {
        farmSimulation.runWednesday();
        
        assertOutputContains(
            "goes to clean the chicken coops",
            "checks on the chickens"
        );
    }

    @Test
    @DisplayName("Wednesday should have proper day header formatting")
    void testWednesdayHeaderFormatting() {
        farmSimulation.runWednesday();
        assertDayHeaderFormatting("WEDNESDAY");
    }

    @Test
    @DisplayName("Wednesday should show both Froilan and Froilanda working")
    void testWednesdayShowsBothWorkersWorking() {
        farmSimulation.runWednesday();
        
        assertOutputContains("Froilan", "Froilanda");
    }

    @Test
    @DisplayName("Wednesday should clean multiple stables")
    void testWednesdayCleanMultipleStables() {
        farmSimulation.runWednesday();
        String output = getOutput();
        
        // Should clean multiple stables (Stable 1, Stable 2, Stable 3)
        int stableCleaningCount = countOccurrences(output, "is cleaning Stable");
        int finishedCleaningCount = countOccurrences(output, "is finished cleaning Stable");
        
        assertTrue(stableCleaningCount >= 3, "Should clean at least 3 stables");
        assertTrue(finishedCleaningCount >= 3, "Should finish cleaning at least 3 stables");
    }

    @Test
    @DisplayName("Wednesday should clean multiple chicken coops")
    void testWednesdayCleanMultipleCoops() {
        farmSimulation.runWednesday();
        String output = getOutput();
        
        // Should clean multiple coops
        int coopCleaningCount = countOccurrences(output, "is cleaning Coop");
        int finishedCoopCleaningCount = countOccurrences(output, "is finished cleaning Coop");
        
        assertTrue(coopCleaningCount >= 4, "Should clean at least 4 coops");
        assertTrue(finishedCoopCleaningCount >= 4, "Should finish cleaning at least 4 coops");
    }

    @Test
    @DisplayName("Wednesday should end with completion message")
    void testWednesdayEndsWithCompletionMessage() {
        farmSimulation.runWednesday();
        String output = getOutput();
        
        assertTrue(output.contains("Wednesday's animal care complete!"));
    }

    @Test
    @DisplayName("Wednesday should show structured cleaning approach")
    void testWednesdayShowsStructuredApproach() {
        farmSimulation.runWednesday();
        String output = getOutput();
        
        // Should show a structured approach: stables first, then coops
        int stablePosition = output.indexOf("cleaning the stables");
        int coopPosition = output.indexOf("clean the chicken coops");
        
        assertTrue(stablePosition < coopPosition, "Should clean stables before coops");
    }

    @Test
    @DisplayName("Wednesday should show care for animal health")
    void testWednesdayShowsAnimalHealthCare() {
        farmSimulation.runWednesday();
        String output = getOutput();
        
        assertTrue(output.contains("health") || output.contains("checking"));
    }
}