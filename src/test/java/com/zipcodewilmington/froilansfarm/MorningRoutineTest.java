package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.people.*;
import com.zipcodewilmington.froilansfarm.structures.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MorningRoutineTest {

    private Farm farm;
    private Farmer froilan;
    private Pilot froilanda;
    private Tractor tractor;
    private CropDuster cropDuster;
    private FarmSimulation simulation;

    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        // Redirect console output for verification
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Field field = new Field("Field");
        FarmHouse farmHouse = new FarmHouse("FarmHouse");
        farm = new Farm(field, farmHouse);

        froilan = new Farmer("Froilan");
        froilanda = new Pilot("Froilanda");
        tractor = new Tractor("Tractor");
        cropDuster = new CropDuster("CropDuster");

        simulation = new FarmSimulation(farm, froilan, froilanda, tractor, cropDuster, new Market());

        // Add stable & horse for morning routine
        Stable stable = new Stable("Stable 1");
        stable.addHorse(new Horse("Thunder"));
        farm.addStable(stable);
    }

    @Test
    void testMorningRoutine() {
        simulation.runMorningRoutine();

        String console = output.toString();
        assertTrue(console.contains("Froilan is riding Thunder"));
        assertTrue(console.contains("Froilanda is riding Thunder"));
        assertTrue(console.contains("Feeding Thunder with 3 ears of corn"));
        assertTrue(console.contains("Horse riding and feeding complete."));
    }

    @Test
    void testBreakfastRoutine() {
        // breakfast is called inside morning routine, so just run morning
        simulation.runMorningRoutine();

        String console = output.toString();

        // Check Froilan's breakfast
        assertTrue(console.contains("Froilan is eating breakfast:"));
        assertTrue(console.contains("Froilan is eating Corn"));
        assertTrue(console.contains("Froilan is eating Tomato"));
        assertTrue(console.contains("Froilan is eating Egg"));
        assertTrue(console.contains("Froilan has finished breakfast!"));

        // Check Froilanda's breakfast
        assertTrue(console.contains("Froilanda is eating breakfast:"));
        assertTrue(console.contains("Froilanda is eating Corn"));
        assertTrue(console.contains("Froilanda is eating Egg"));
        assertTrue(console.contains("Froilanda has finished breakfast!"));
    }
}

