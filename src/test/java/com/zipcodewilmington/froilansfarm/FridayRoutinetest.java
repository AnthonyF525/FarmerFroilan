package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FridayRoutinetest {

    @Test
    public void testFridayMarketDay() {
        // Capture System.out output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FarmSimulation simulation = new FarmSimulation();
        simulation.runFriday();

        String console = outContent.toString();
        System.setOut(System.out);

        System.out.println("DEBUG OUTPUT:\n" + console);

        assertTrue(console.contains("FRIDAY"), "Output should include day header.");
        assertTrue(console.contains("Market Day"), "Output should indicate market day activity.");
        assertTrue(console.contains("selling"), "Output should mention selling produce.");
        assertTrue(console.contains("Friday's market day complete"), "Output should confirm Friday's market day completion.");
    }
}
