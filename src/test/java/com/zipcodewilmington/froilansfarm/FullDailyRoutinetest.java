package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Integration test class for testing the complete week simulation
 */
class FullDailyRoutinetest extends BaseFarmtest {

    @Test
    @DisplayName("Full week should run all days in sequence")
    void testRunWeekAllDaysInSequence() {
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runWeek());
        
        // Verify all days are present in order
        assertOutputContains(
            "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", 
            "THURSDAY", "FRIDAY", "SATURDAY"
        );
    }

    @Test
    @DisplayName("Full week should include all themed activities")
    void testRunWeekIncludesAllThemedActivities() {
        farmSimulation.runWeek();
        
        // Verify key activities for each day
        assertOutputContains(
            "Planting Day",      // Sunday
            "Fertilize Day",     // Monday
            "Harvest Day",       // Tuesday
            "Animal Care Day",   // Wednesday
            "Maintenance Day",   // Thursday
            "Market Day",        // Friday
            "Leisure Day"        // Saturday
        );
    }

    @Test
    @DisplayName("Each day should include morning routine")
    void testEachDayIncludesMorningRoutine() {
        farmSimulation.runWeek();
        String output = getOutput();
        
        // Should see horse riding and feeding messages multiple times (once per day)
        int horseRidingCount = countOccurrences(output, "--- Horse Riding ---");
        int horseFeedingCount = countOccurrences(output, "--- Feeding Horses ---");
        
        assertEquals(7, horseRidingCount, "Horse riding should occur once each day");
        assertEquals(7, horseFeedingCount, "Horse feeding should occur once each day");
    }

    @Test
    @DisplayName("Each day should include breakfast routine")
    void testEachDayIncludesBreakfastRoutine() {
        farmSimulation.runWeek();
        String output = getOutput();
        
        int breakfastCount = countOccurrences(output, "---Breakfast Routine---");
        assertEquals(7, breakfastCount, "Breakfast should occur once each day");
    }

    @Test
    @DisplayName("Week should show proper farming sequence")
    void testWeekShowsProperFarmingSequence() {
        farmSimulation.runWeek();
        String output = getOutput();
        
        // Planting should come before fertilizing
        int plantingPos = output.indexOf("Planting Day");
        int fertilizePos = output.indexOf("Fertilize Day");
        assertTrue(plantingPos < fertilizePos, "Planting should come before fertilizing");
        
        // Fertilizing should come before harvesting
        int harvestPos = output.indexOf("Harvest Day");
        assertTrue(fertilizePos < harvestPos, "Fertilizing should come before harvesting");
        
        // Harvesting should come before market day
        int marketPos = output.indexOf("Market Day");
        assertTrue(harvestPos < marketPos, "Harvesting should come before market day");
    }

    @Test
    @DisplayName("Week should show all farm personnel working")
    void testWeekShowsAllFarmPersonnelWorking() {
        farmSimulation.runWeek();
        String output = getOutput();
        
        // Both Froilan and Froilanda should be mentioned throughout the week
        int froilanCount = countOccurrences(output, "Froilan");
        int froilandaCount = countOccurrences(output, "Froilanda");
        
        assertTrue(froilanCount >= 20, "Froilan should be very active throughout the week");
        assertTrue(froilandaCount >= 10, "Froilanda should be active throughout the week");
    }

    @Test
    @DisplayName("Week should produce comprehensive output")
    void testWeekProducesComprehensiveOutput() {
        farmSimulation.runWeek();
        String output = getOutput();
        
        // Should be substantial output (more than just a few lines)
        assertTrue(output.length() > 5000, "Full week simulation should produce substantial output");
        
        // Should contain evidence of all major farm activities
        assertOutputContains(
            "planting", "fertiliz", "harvest", 
            "cleaning", "maintenance", "market", "leisure"
        );
    }

    @Test
    @DisplayName("Week should show consistent day formatting")
    void testWeekShowsConsistentDayFormatting() {
        farmSimulation.runWeek();
        String output = getOutput();
        
        // Each day should have proper header formatting
        int headerCount = countOccurrences(output, "================================================");
        assertTrue(headerCount >= 14, "Should have headers for each day (start and potentially end)");
        
        // Each day should have section dividers
        int dividerCount = countOccurrences(output, "------------------------");
        assertTrue(dividerCount >= 21, "Should have section dividers (3+ per day)");
    }

    @Test
    @DisplayName("Week should show progression of activities")
    void testWeekShowsProgressionOfActivities() {
        farmSimulation.runWeek();
        String output = getOutput();
        
        // Should show logical progression through the week
        // Sunday: Plant → Monday: Fertilize → Tuesday: Harvest → Friday: Market
        String[] expectedSequence = {
            "SUNDAY", "plant", 
            "MONDAY", "fertiliz", 
            "TUESDAY", "harvest",
            "FRIDAY", "market"
        };
        
        int lastPosition = 0;
        for (String expectedItem : expectedSequence) {
            int currentPosition = output.indexOf(expectedItem, lastPosition);
            assertTrue(currentPosition > lastPosition, 
                "Expected sequence not found: " + expectedItem);
            lastPosition = currentPosition;
        }
    }

    @Test
    @DisplayName("Week should handle all animals and structures")
    void testWeekHandlesAllAnimalsAndStructures() {
        farmSimulation.runWeek();
        String output = getOutput();
        
        // Should mention various structures
        assertTrue(output.contains("Stable") || output.contains("stable"));
        assertTrue(output.contains("Coop") || output.contains("coop"));
        
        // Should mention animals
        assertTrue(output.contains("horse") || output.contains("Horse"));
        assertTrue(output.contains("chicken") || output.contains("Chicken"));
        
        // Should mention vehicles
        assertTrue(output.contains("tractor") || output.contains("Tractor"));
        assertTrue(output.contains("crop duster") || output.contains("CropDuster"));
    }

    @Test
    @DisplayName("Week should end with Saturday completion")
    void testWeekEndsWithSaturdayCompletion() {
        farmSimulation.runWeek();
        String output = getOutput();
        
        // Should end with Saturday's completion message
        assertTrue(output.contains("Saturday's rest and recreation complete!"));
        
        // Saturday should be the last day mentioned
        int lastSaturdayPos = output.lastIndexOf("SATURDAY");
        int lastSundayPos = output.lastIndexOf("SUNDAY");
        assertTrue(lastSaturdayPos > lastSundayPos, "Saturday should be after Sunday in the sequence");
    }

    @Test
    @DisplayName("Week simulation should be deterministic")
    void testWeekSimulationIsDeterministic() {
        // Run the simulation twice and compare key metrics
        farmSimulation.runWeek();
        String firstOutput = getOutput();
        
        // Reset and run again
        setUp(); // This creates a new simulation
        farmSimulation.runWeek();
        String secondOutput = getOutput();
        
        // Should have similar structure (same number of days, sections, etc.)
        int firstDayCount = countOccurrences(firstOutput, "================================================");
        int secondDayCount = countOccurrences(secondOutput, "================================================");
        assertEquals(firstDayCount, secondDayCount, "Both runs should have same number of day headers");
        
        int firstBreakfastCount = countOccurrences(firstOutput, "---Breakfast Routine---");
        int secondBreakfastCount = countOccurrences(secondOutput, "---Breakfast Routine---");
        assertEquals(firstBreakfastCount, secondBreakfastCount, "Both runs should have same number of breakfasts");
    }
}