package com.farm;

import com.zipcodewilmington.froilansfarm.*;
import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.people.*;
import com.zipcodewilmington.froilansfarm.structures.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SundayTest {
    private FarmSimulation sim;
    private Farm farm;

    @BeforeEach
    void setup() {
        farm = TestUtils.setupFarm(); // helper factory to build farm
        sim = TestUtils.setupSimulation(farm);
    }

    @Test
    void testSundayPlanting() {
        sim.runSunday();
        Field field = farm.getField();

        assertTrue(field.getCropRow(0).getCrops().size() > 0, "Row 0 should have corn stalks");
        assertTrue(field.getCropRow(1).getCrops().size() > 0, "Row 1 should have tomato plants");
        assertTrue(field.getCropRow(2).getCrops().size() > 0, "Row 2 should have generic crops");
    }
}
