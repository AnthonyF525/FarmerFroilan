package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WednesdayRoutinetest {

    @Test
    public void testWednesdayAnimalCare() {
        // Capture System.out output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FarmSimulation simulation = new FarmSimulation();
        simulation.runWednesday();

        String console = outContent.toString();
        System.setOut(System.out);

        

        assertTrue(console.contains("WEDNESDAY"), "Output should include day header.");
        assertTrue(console.contains("Animal Care Day"), "Output should indicate animal care activity.");
        assertTrue(console.contains("feeding"), "Output should mention feeding animals.");
        assertTrue(console.contains("Wednesday's animal care complete"), "Output should confirm Wednesday's animal care completion.");
    }
}
