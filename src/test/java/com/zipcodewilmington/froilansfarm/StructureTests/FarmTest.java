package com.zipcodewilmington.froilansfarm.StructureTests;

import com.zipcodewilmington.froilansfarm.structures.*;
import com.zipcodewilmington.froilansfarm.model.*;

public class FarmTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Farm Class ---");
        
        // Create farm components
        Field field = new Field("Main Field");
        FarmHouse farmHouse = new FarmHouse("Main House");
        Farm farm = new Farm(field, farmHouse);
        
        // Test adding structures
        Stable stable = new Stable("Stable 1");
        ChickenCoop coop = new ChickenCoop("Coop 1");
        
        farm.addStable(stable);
        farm.addChickenCoops(coop);
        
        // Test vehicle management
        Tractor tractor = new Tractor("Tractor 1");
        CropDuster duster = new CropDuster("Duster 1");
        
        farm.addVehicle(tractor);
        farm.addAircraft(duster);
        
        // Test reporting methods
        System.out.println(farm.getAllAnimals());
        System.out.println(farm.getAllPeople());
        System.out.println(farm.getAllCrops());
        
        System.out.println("Farm test complete.");
    }
}
