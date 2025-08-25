package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Saturday - Leisure Day
 */
class SaturdayRoutinetest extends BaseFarmtest {

    @Test
    @DisplayName("Saturday should complete without exceptions")
    void testSaturdayCompletesSuccessfully() {
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runSaturday());
    }

    @Test
    @DisplayName("Saturday should be leisure day")
    void testSaturdayIsLeisureDay() {
        farmSimulation.runSaturday();

        assertOutputContains(
                "SATURDAY",
                " ---  Leisure Day ---",
                "Time for a relaxing ride with Jasper and Spirit...",
                "Saturday's leisure day complete!");
    }

    @Test
    @DisplayName("Saturday should include morning routine")
    void testSaturdayIncludesMorningRoutine() {
        farmSimulation.runSaturday();

        assertOutputContains(
                "--- Horse Riding ---",
                "--- Feeding Horses ---");
    }

    @Test
    @DisplayName("Saturday should include breakfast routine")
    void testSaturdayIncludesBreakfastRoutine() {
        farmSimulation.runSaturday();

        assertOutputContains("---Breakfast Routine---");
    }

    @Test
    @DisplayName("Saturday should include leisure horse riding")
    void testSaturdayIncludesLeisureRiding() {
        farmSimulation.runSaturday();

        assertOutputContains("Time for a relaxing ride");
    }

    @Test
    @DisplayName("Saturday should have proper day header formatting")
    void testSaturdayHeaderFormatting() {
        farmSimulation.runSaturday();
        assertDayHeaderFormatting("SATURDAY");
    }

    @Test
    @DisplayName("Saturday should show both Froilan and Froilanda taking leisure rides")
    void testSaturdayShowsBothTakingLeisureRides() {
        farmSimulation.runSaturday();
        String output = getOutput();

        assertTrue(output.contains("Froilan") && output.contains("Froilanda"));
        assertTrue(output.contains("relaxing ride") || output.contains("leisure"));
    }

    @Test
    @DisplayName("Saturday should show specific horses for leisure rides")
    void testSaturdayShowsSpecificHorsesForLeisure() {
        farmSimulation.runSaturday();
        String output = getOutput();

        // Should mention specific horse names for the leisure ride
        boolean containsHorseNames = output.contains("Jasper") ||
                output.contains("Spirit") ||
                output.contains("Daisy") ||
                output.contains("Lucky") ||
                output.contains("and"); // "horse1 and horse2"

        assertTrue(containsHorseNames, "Should mention specific horses for leisure rides");
    }

    @Test
    @DisplayName("Saturday should show happy chickens")
    void testSaturdayShowsHappyChickens() {
        farmSimulation.runSaturday();

        assertOutputContains(
                "chickens coo happily",
                "after their meal!");
    }

    @Test
    @DisplayName("Saturday should include chicken sounds")
    void testSaturdayIncludesChickenSounds() {
        farmSimulation.runSaturday();
        String output = getOutput();

        // Should show chickens making noise
        assertTrue(output.contains("coo") || output.contains("noise") ||
                output.contains("sound") || output.contains("happily"));
    }

    @Test
    @DisplayName("Saturday should end with completion message")
    void testSaturdayEndsWithCompletionMessage() {
        farmSimulation.runSaturday();
        String output = getOutput();

        assertTrue(output.contains("Saturday's leisure day complete!"));
    }

    @Test
    @DisplayName("Saturday should show a relaxed pace compared to other days")
    void testSaturdayShowsRelaxedPace() {
        farmSimulation.runSaturday();
        String output = getOutput();

        // Should emphasize leisure, relaxation, rest
        assertTrue(output.contains("relaxing") || output.contains("leisure") ||
                output.contains("rest") || output.contains("recreation"));
    }

    @Test
    @DisplayName("Saturday should show farm life balance")
    void testSaturdayShowsFarmLifeBalance() {
        farmSimulation.runSaturday();
        String output = getOutput();

        // Should show both work (egg collection) and leisure (riding)
        assertTrue(output.contains("leisure") || output.contains("relaxing"));
        assertTrue(output.contains("eggs") || output.contains("chickens"));

        // Should show contentment and happiness
        assertTrue(output.contains("happily") || output.contains("ready") ||
                output.contains("recreation"));
    }

    @Test
    @DisplayName("Saturday should include picnic activity")
    void testSaturdayIncludesPicnic() {
        farmSimulation.runSaturday();
        String output = getOutput();
        assertTrue(output.toLowerCase().contains("picnic"), "Output should mention a picnic activity");
    }

    @Test
    @DisplayName("Saturday should include Froilan and Froilanda speaking")
    void testSaturdayIncludesSpeaking() {
        farmSimulation.runSaturday();
        String output = getOutput();
        output = output.replaceAll("\u001B\\[[;\\d]*m", "");
        assertTrue(output.contains("Froilan is speaking"), "Output should include 'Froilan is speaking'");
        assertTrue(output.contains("Froilanda is speaking"), "Output should include 'Froilanda is speaking'");
    }
}