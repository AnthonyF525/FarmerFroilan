package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Thursday - Maintenance Day
 */
class ThursdayRoutinetest extends BaseFarmtest {

    @Test
    @DisplayName("Thursday should have proper day header formatting")
    void testThursdayHeaderFormatting() {
        farmSimulation.runThursday();
        assertDayHeaderFormatting("THURSDAY");
}

    @Test
    @DisplayName("Thursday should show Froilan working with tractor")
    void testThursdayShowsFroilanWithTractor() {
        farmSimulation.runThursday();
        
        assertOutputContains("Froilan");
        String output = getOutput();
        assertTrue(output.contains("tractor") || output.contains("work the land"));
    }

    @Test
    @DisplayName("Thursday should show Froilanda maintaining crop duster")
    void testThursdayShowsFroilandaMaintainingCropDuster() {
        farmSimulation.runThursday();
        
        assertOutputContains("Froilanda", "crop duster");
    }

    @Test
    @DisplayName("Thursday should prepare specific crop rows")
    void testThursdayPreparesSpecificCropRows() {
        farmSimulation.runThursday();
        String output = getOutput();
        
        // Should mention preparing rows (CropRow 4 and 5)
        assertTrue(output.contains("preparing") || output.contains("prepare") ||
                  output.contains("crop rows"));
    }

    @Test
    @DisplayName("Thursday should show maintenance for both vehicles")
    void testThursdayMaintainsBothVehicles() {
        farmSimulation.runThursday();
        String output = getOutput();
        
        // Should maintain both tractor and crop duster
        assertTrue(output.contains("tractor"));
        assertTrue(output.contains("crop duster"));
        
        int maintenanceCount = countOccurrences(output, "maintenance");
        assertTrue(maintenanceCount >= 3, "Should mention maintenance multiple times");
    }

    @Test
    @DisplayName("Thursday should end with completion message")
    void testThursdayEndsWithCompletionMessage() {
        farmSimulation.runThursday();
        String output = getOutput();
        
        assertTrue(output.contains("Thursday's maintenance complete!"));
    }

    @Test
    @DisplayName("Thursday should show structured maintenance workflow")
    void testThursdayShowsStructuredWorkflow() {
        farmSimulation.runThursday();
        String output = getOutput();
        
        // Should show land preparation before vehicle maintenance
        int landPrepPosition = output.indexOf("work the land");
        int vehicleMaintenancePosition = output.indexOf("essential maintenance");
        
        assertTrue(landPrepPosition < vehicleMaintenancePosition, "Should prepare land before vehicle maintenance");
    }

    @Test
    @DisplayName("Thursday should show mounting and dismounting vehicles")
    void testThursdayShowsMountingDismounting() {
        farmSimulation.runThursday();
        String output = getOutput();
        
        // Should show mounting and dismounting for maintenance
        assertTrue(output.contains("mount") || output.contains("dismount") ||
                  output.contains("Mount") || output.contains("Dismount"));
    }
    void testThursdayCompletesSuccessfully() {
        assertRoutineCompletesSuccessfully(() -> farmSimulation.runThursday());
    }

    @Test
    @DisplayName("Thursday should be maintenance day")
    void testThursdayIsMaintenanceDay() {
        farmSimulation.runThursday();

        assertOutputContains("THURSDAY",
            "--- Maintenance Day ---",
            "Time to prepare the empty crop rows for next season's planting!",
            "Thursday's maintenance complete!"
        );
    }

    @Test
    @DisplayName("Thursday should include morning routine")
    void testThursdayIncludesMorningRoutine() {
        farmSimulation.runThursday();
        
        assertOutputContains(
            "--- Horse Riding ---",
            "--- Feeding Horses ---"
        );
    }

    @Test
    @DisplayName("Thursday should include breakfast routine")
    void testThursdayIncludesBreakfastRoutine() {
        farmSimulation.runThursday();
        
        assertOutputContains("---Breakfast Routine---");
    }

    @Test
    @DisplayName("Thursday should include land preparation")
    void testThursdayIncludesLandPreparation() {
        farmSimulation.runThursday();

        assertOutputContains("uses his tractor to work the land", "finished preparing the crop rows!");
    }

    @Test
    @DisplayName("Thursday should include vehicle maintenance")
    void testThursdayIncludesVehicleMaintenance() {
        farmSimulation.runThursday();
        
        assertOutputContains(
            "Performing essential maintenance on farm vehicles",
            "finished maintenance on his tractor!",
            "finished maintenance on her crop duster!"
        );
    }
}
  