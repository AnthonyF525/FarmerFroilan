package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MorningRoutineTest {

    private ByteArrayOutputStream output;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        // Capture console output before each test
        output = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(output));
    }

    @Test
    void testMorningRoutine() {
        // Arrange
        FarmSimulation simulation = new FarmSimulation();

        // Act
        simulation.runMorningRoutine();

        // Restore original System.out
        System.setOut(originalOut);

        // Assert
        String console = output.toString();
        assertTrue(console.contains("Froilan mounts"), "Should show Froilan mounting horses.");
        assertTrue(console.contains("Froilanda mounts"), "Should show Froilanda mounting horses.");
        assertTrue(console.contains("Morning ride complete!"), "Should confirm morning ride is complete.");
        assertTrue(console.contains("Feeding complete!"), "Should confirm feeding is complete.");
    }

    @Test
    void testBreakfastRoutine() {
        // Arrange
        FarmSimulation simulation = new FarmSimulation();

        // Act
        simulation.runMorningRoutine(); // breakfast happens inside

        // Restore original System.out
        System.setOut(originalOut);

        // Assert
        String console = output.toString();

        // Check Froilan's breakfast
        assertTrue(console.contains("Froilan is eating breakfast:"), "Froilan's breakfast start missing.");
        assertTrue(console.contains("Froilan is eating Corn"), "Corn missing from Froilan's breakfast.");
        assertTrue(console.contains("Froilan is eating Tomato"), "Tomato missing from Froilan's breakfast.");
        assertTrue(console.contains("Froilan is eating Egg"), "Egg missing from Froilan's breakfast.");
        assertTrue(console.contains("Froilan has finished breakfast!"), "Froilan's breakfast completion missing.");

        // Check Froilanda's breakfast
        assertTrue(console.contains("Froilanda is eating breakfast:"), "Froilanda's breakfast start missing.");
        assertTrue(console.contains("Froilanda is eating Corn"), "Corn missing from Froilanda's breakfast.");
        assertTrue(console.contains("Froilanda is eating Egg"), "Egg missing from Froilanda's breakfast.");
        assertTrue(console.contains("Froilanda has finished breakfast!"), "Froilanda's breakfast completion missing.");
    }
}
