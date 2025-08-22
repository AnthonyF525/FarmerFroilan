package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SundayRoutinetest {

    @Test
    public void testSundayPlanting() {
        // Capture System.out output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create simulation and run Sunday routine
        FarmSimulation simulation = new FarmSimulation();
        simulation.runSunday();

        // Get the captured console output
        String console = outContent.toString();

        // Reset System.out to its default
        System.setOut(System.out);

        

        // Assertions for expected Sunday output
        assertTrue(console.contains("SUNDAY"), "Output should include day header.");
        assertTrue(console.contains("Planting Day"), "Output should indicate planting activity.");
        assertTrue(console.contains("Corn"), "Output should mention planting Corn.");
        assertTrue(console.contains("Tomato"), "Output should mention planting Tomato.");
        assertTrue(console.contains("Sunday's planting complete"), "Output should confirm Sunday's planting completion.");
    }
}
