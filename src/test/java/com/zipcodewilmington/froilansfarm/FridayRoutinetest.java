package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Friday - Market Day
 */
class FridayRoutinetest extends BaseFarmtest {

    @Test
    @DisplayName("Friday should complete without exceptions")
    void testFridayCompletesSuccessfully() {
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runFriday());
    }

    @Test
    @DisplayName("Friday should be market day")
    void testFridayIsMarketDay() {
        farmSimulation.runFriday();
        
        assertOutputContains(
            "FRIDAY",
            "--- Market Day ---",
            "gather all their harvested produce",
            "Time to bring them over to the local market!",
            "Friday's market day complete!"
        );
    }

    @Test
    @DisplayName("Friday should include morning routine")
    void testFridayIncludesMorningRoutine() {
        farmSimulation.runFriday();
        
        assertOutputContains(
            "--- Horse Riding ---",
            "--- Feeding Horses ---"
        );
    }

    @Test
    @DisplayName("Friday should include breakfast routine")
    void testFridayIncludesBreakfastRoutine() {
        farmSimulation.runFriday();
        
        assertOutputContains("---Breakfast Routine---");
    }

    @Test
    @DisplayName("Friday should have proper day header formatting")
    void testFridayHeaderFormatting() {
        farmSimulation.runFriday();
        assertDayHeaderFormatting("FRIDAY");
    }

    @Test
    @DisplayName("Friday should show both Froilan and Froilanda gathering produce")
    void testFridayShowsBothGatheringProduce() {
        farmSimulation.runFriday();
        
        assertOutputContains("Froilan", "Froilanda");
    }

    @Test
    @DisplayName("Friday should create and use market")
    void testFridayCreatesAndUsesMarket() {
        farmSimulation.runFriday();
        String output = getOutput();
        
        assertTrue(output.contains("market") || output.contains("Market"));
    }

    @Test
    @DisplayName("Friday with harvested produce should show selling activity")
    void testFridayWithHarvestedProduceShowsSelling() {
        // Run full sequence to have produce to sell
        farmSimulation.runSunday(); // Plant
        farmSimulation.runMonday(); // Fertilize
        farmSimulation.runTuesday(); // Harvest
        resetOutput();
        
        farmSimulation.runFriday();
        String output = getOutput();
        
        // Should show market activity
        assertTrue(output.contains("market") || output.contains("Market") ||
                  output.contains("sell") || output.contains("produce"));
    }

    @Test
    @DisplayName("Friday should end with completion message")
    void testFridayEndsWithCompletionMessage() {
        farmSimulation.runFriday();
        String output = getOutput();
        
        assertTrue(output.contains("Friday's market day complete!"));
    }

    @Test
    @DisplayName("Friday should show preparation before market visit")
    void testFridayShowsPreparation() {
        farmSimulation.runFriday();
        String output = getOutput();
        
        // Should show gathering produce before going to market
        int gatherPosition = output.indexOf("gather");
        int marketPosition = output.indexOf("market");
        
        assertTrue(gatherPosition < marketPosition || gatherPosition == -1 || marketPosition == -1,
                  "Should gather produce before going to market");
    }

    @Test
    @DisplayName("Friday should handle empty produce gracefully")
    void testFridayHandlesEmptyProduce() {
        // Run Friday without harvesting first
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runFriday());
        
        // Should still complete successfully even with no produce
        assertOutputContains("Friday's market day complete!");
    }

    @Test
    @DisplayName("Friday should show teamwork between Froilan and Froilanda")
    void testFridayShowsTeamwork() {
        farmSimulation.runFriday();
        String output = getOutput();
        
        // Should show both working together
        assertTrue(output.contains("Froilan") && output.contains("Froilanda"));
        assertTrue(output.contains("and") || output.contains("&")); // Some indication of cooperation
    }

    @Test
    @DisplayName("Friday should be focused on selling produce")
    void testFridayFocusOnSelling() {
        farmSimulation.runFriday();
        String output = getOutput();
        
        // Main theme should be about produce and market
        assertTrue(output.contains("produce") || output.contains("market") ||
                  output.contains("harvest") || output.contains("sell"));
    }
}