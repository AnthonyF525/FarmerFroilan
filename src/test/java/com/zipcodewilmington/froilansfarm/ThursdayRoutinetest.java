package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThursdayRoutinetest {

    @Test
    public void testThursdayMaintenance() {
        // Capture System.out output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FarmSimulation simulation = new FarmSimulation();
        simulation.runThursday();

        String console = outContent.toString();
        System.setOut(System.out);


        assertTrue(console.contains("THURSDAY"), "Output should include day header.");
        assertTrue(console.contains("Maintenance Day"), "Output should indicate maintenance activity.");
        assertTrue(console.contains("equipment"), "Output should mention maintaining equipment.");
        assertTrue(console.contains("Thursday's maintenance complete"), "Output should confirm Thursday's maintenance completion.");
    }
}
