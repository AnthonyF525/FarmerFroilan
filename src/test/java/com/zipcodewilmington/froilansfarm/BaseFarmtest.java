package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Base test class providing common setup and utility methods
 * for all FarmSimulation tests
 */
public abstract class BaseFarmtest {
    
    protected FarmSimulation farmSimulation;
    protected ByteArrayOutputStream outputStream;
    protected PrintStream originalOut;

    @BeforeEach
    void setUp() {
        farmSimulation = new FarmSimulation();
        
        // Capture System.out for testing console output
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        // Restore original System.out after each test
        System.setOut(originalOut);
    }

    /**
     * Helper method to get captured output as string
     */
    protected String getOutput() {
        return outputStream.toString();
    }

    /**
     * Helper method to reset captured output
     */
    protected void resetOutput() {
        outputStream.reset();
    }

    /**
     * Helper method to count occurrences of a substring in a string
     */
    protected int countOccurrences(String text, String pattern) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(pattern, index)) != -1) {
            count++;
            index += pattern.length();
        }
        return count;
    }

    /**
     * Common assertion for testing that a routine completes without exceptions
     */
    protected void assertRoutineCompletesSuccessfully(Runnable routine) {
        assertDoesNotThrow(routine::run);
    }

    /**
     * Common assertion for testing output contains expected content
     */
    protected void assertOutputContains(String... expectedContent) {
        String output = getOutput();
        for (String content : expectedContent) {
            assertTrue(output.contains(content), 
                "Output should contain: " + content + "\nActual output: " + output);
        }
    }

    /**
     * Common assertion for testing day header formatting
     */
    protected void assertDayHeaderFormatting(String dayName) {
        String output = getOutput();
        assertTrue(output.contains("================================================"));
        assertTrue(output.contains(dayName.toUpperCase()));
    }
}