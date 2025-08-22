package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MondayRoutinetest {

    @Test
    public void testMondayFertilizing() {
        // Capture System.out output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FarmSimulation simulation = new FarmSimulation();
        simulation.runMonday();

        String console = outContent.toString();
        System.setOut(System.out);

        System.out.println("DEBUG OUTPUT:\n" + console);

        assertTrue(console.contains("MONDAY"), "Output should include day header.");
        assertTrue(console.contains("Fertilize Day"), "Output should indicate fertilization activity.");
        assertTrue(console.contains("Froilanda"), "Output should mention Froilanda using the CropDuster.");
        assertTrue(console.contains("Monday's fertilizing complete"), "Output should confirm Monday's fertilizing completion.");
    }
}
