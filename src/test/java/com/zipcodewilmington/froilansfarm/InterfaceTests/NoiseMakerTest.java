package com.zipcodewilmington.froilansfarm.InterfaceTests;

import com.zipcodewilmington.froilansfarm.model.Animal;
import com.zipcodewilmington.froilansfarm.model.Horse;

public class NoiseMakerTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing NoiseMaker Interface ---");
        Animal horse = new Horse("Jasper");
        
        // A NoiseMaker must be able to make a noise
        horse.makeNoise();
        System.out.println("NoiseMaker interface test complete.");
    }
}
