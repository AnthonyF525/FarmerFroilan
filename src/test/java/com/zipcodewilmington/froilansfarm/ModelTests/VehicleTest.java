package com.zipcodewilmington.froilansfarm.ModelTests;

import com.zipcodewilmington.froilansfarm.model.Vehicle;

public class VehicleTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Vehicle ---");
        Vehicle testVehicle = new Vehicle("Test Car");
        
        // Test NoiseMaker
        System.out.print("Testing makeNoise()... ");
        testVehicle.makeNoise();

        // Test Rideable 
        System.out.print("Testing mount()... ");
        testVehicle.mount();
        System.out.print("Testing dismount()... ");
        testVehicle.dismount();

        // Test Vehicle
        System.out.print("Testing performMaintenance()... ");
        testVehicle.performMaintenance();
        
        System.out.println("Vehicle test complete.");
    }
}