package com.zipcodewilmington.froilansfarm.StructureTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.zipcodewilmington.froilansfarm.structures.*;
import com.zipcodewilmington.froilansfarm.model.*;

public class FarmTest {
    
    @Test
    public void testFarmSetup() {
        System.out.println("\n--- Testing Farm Class ---");
        
        // Create farm components
        Field field = new Field("Main Field");
        FarmHouse farmHouse = new FarmHouse("Main House");
        Farm farm = new Farm(field, farmHouse);
        
        assertNotNull(farm, "Farm should be created");
        assertEquals(field, farm.getField(), "Farm should have correct field");
        assertEquals(farmHouse, farm.getFarmHouse(), "Farm should have correct farmhouse");
        
        System.out.println("Farm setup test complete.");
    }
    
    @Test
    public void testFarmStructureManagement() {
        Field field = new Field("Main Field");
        FarmHouse farmHouse = new FarmHouse("Main House");
        Farm farm = new Farm(field, farmHouse);
        
        // Test adding structures
        Stable stable = new Stable("Stable 1");
        ChickenCoop coop = new ChickenCoop("Coop 1");
        
        farm.addStable(stable);
        farm.addChickenCoops(coop);
        
        assertTrue(farm.getStables().contains(stable), "Farm should contain added stable");
        assertTrue(farm.getChickenCoop().contains(coop), "Farm should contain added coop");
        
        System.out.println("Farm structure management test complete.");
    }
    
    @Test
    public void testFarmReporting() {
        Field field = new Field("Main Field");
        FarmHouse farmHouse = new FarmHouse("Main House");
        Farm farm = new Farm(field, farmHouse);
        
        // Test reporting methods
        String animals = farm.getAllAnimals();
        String people = farm.getAllPeople();
        String crops = farm.getAllCrops();
        
        assertNotNull(animals, "Animals report should not be null");
        assertNotNull(people, "People report should not be null");
        assertNotNull(crops, "Crops report should not be null");
        
        System.out.println("Farm reporting test complete.");
    }
}
