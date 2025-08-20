package com.zipcodewilmington.froilansfarm.InterfaceTests;

import com.zipcodewilmington.froilansfarm.interfaces.FarmVehicle;
import com.zipcodewilmington.froilansfarm.model.Tractor;

public class FarmVehicleTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing FarmVehicle Interface ---");
        FarmVehicle tractor = new Tractor("Tractor 1");

        // FarmVehicle must operate on the farm
        tractor.operateOnFarm();

        System.out.println("FarmVehicle interface test complete.");
    }
}