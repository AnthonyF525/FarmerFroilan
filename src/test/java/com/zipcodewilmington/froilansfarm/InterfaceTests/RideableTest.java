package com.zipcodewilmington.froilansfarm.InterfaceTests;

import com.zipcodewilmington.froilansfarm.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.model.Tractor;

public class RideableTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Rideable Interface ---");
        Rideable tractor = new Tractor("Tractor 1");

        // Rideable must be mounted and dismounted
        tractor.mount();
        tractor.dismount();
        System.out.println("Rideable interface test complete.");
    }
}