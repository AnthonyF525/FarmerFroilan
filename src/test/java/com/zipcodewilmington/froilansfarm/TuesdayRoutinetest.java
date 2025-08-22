package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TuesdayRoutinetest {

    @Test
    public void testTuesdayHarvesting() {
        // Capture System.out output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FarmSimulation simulation = new FarmSimulation();
        simulation.runTuesday();

        String console = outContent.toString();
        System.setOut(System.out);

       

        assertTrue(console.contains("TUESDAY"), "Output should include day header.");
        assertTrue(console.contains("Harvest Day"), "Output should indicate harvesting activity.");
        assertTrue(console.contains("Tractor"), "Output should mention using the Tractor.");
        assertTrue(console.contains("Tuesday's harvesting complete"), "Output should confirm Tuesday's harvesting completion.");
    }
}
