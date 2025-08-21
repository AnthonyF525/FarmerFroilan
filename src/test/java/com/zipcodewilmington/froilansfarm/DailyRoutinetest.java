package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.people.*;
import com.zipcodewilmington.froilansfarm.structures.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class DailyRoutinetest {

    private Farm farm;
    private Farmer froilan;
    private Pilot froilanda;
    private Tractor tractor;
    private CropDuster cropDuster;
    private FarmSimulation simulation;
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Field field = new Field("Field");

         field.addCropRow(new CropRow("Row 1")); // Add CropRow at index 0 (first row).
        field.addCropRow(new CropRow("Row 2")); // Add CropRow at index 1 (second row).
        field.addCropRow(new CropRow("Row 3")); // Add CropRow at index 2 (third row).
        field.addCropRow(new CropRow("Row 4")); // Add CropRow at index 3 (fourth row) — required for Thursday maintenance.
        field.addCropRow(new CropRow("Row 5")); // Add CropRow at index 4 (fifth row) — also required by Thursday maintenance.
        FarmHouse farmHouse = new FarmHouse("FarmHouse");
        farm = new Farm(field, farmHouse);

        froilan = new Farmer("Froilan");
        froilanda = new Pilot("Froilanda");
        tractor = new Tractor("Tractor");
        cropDuster = new CropDuster("CropDuster");

        simulation = new FarmSimulation(farm, froilan, froilanda, tractor, cropDuster, new Market());
    }

    @Test
    void testSundayPlanting() {
        simulation.runSunday();
        String console = output.toString();
        assertTrue(console.contains("Froilan is planting crops"));
        assertTrue(console.contains("Sunday's planting complete."));
    }

    @Test
    void testMondayFertilizing() {
        simulation.runMonday();
        String console = output.toString();
        assertTrue(console.contains("Froilanda is flying the crop duster"));
        assertTrue(console.contains("has been fertilized"));
        assertTrue(console.contains("Monday's fertilizing complete."));
    }

    @Test
    void testTuesdayHarvesting() {
        simulation.runTuesday();
        String console = output.toString();
        assertTrue(console.contains("Froilan is harvesting crops with the tractor"));
        assertTrue(console.contains("Tuesday's harvesting complete."));
    }

    @Test
    void testWednesdayAnimalCare() {
        simulation.runWednesday();
        String console = output.toString();
        assertTrue(console.contains("animal care complete"));
    }

    @Test
    void testThursdayMaintenance() {
        simulation.runThursday();
        String console = output.toString();
        assertTrue(console.contains("maintenance complete"));
    }

    @Test
    void testFridayMarketDay() {
        simulation.runFriday();
        String console = output.toString();
        assertTrue(console.contains("Friday's market day complete."));
    }

    @Test
    void testSaturdayRestAndLeisure() {
        Stable stable = new Stable("Stable");
        stable.addHorse(new Horse("Bella"));
        farm.addStable(stable);

        simulation.runSaturday();
        String console = output.toString();
        assertTrue(console.contains("rest and leisure complete"));
    }
}
