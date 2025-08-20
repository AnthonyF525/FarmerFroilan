package com.zipcodewilmington.froilansfarm.ModelTests;

import com.zipcodewilmington.froilansfarm.model.Horse;

public class HorseTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Horse ---");
        Horse horse = new Horse("Jasper");

        // Test makeNoise() 
        System.out.print("Testing makeNoise()... ");
        horse.makeNoise();

        // Test Rideable interface 
        System.out.print("Testing mount()... ");
        horse.mount();
        System.out.print("Testing dismount()... ");
        horse.dismount();
    }
}