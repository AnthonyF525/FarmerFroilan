package com.zipcodewilmington.froilansfarm.ModelTests;

import com.zipcodewilmington.froilansfarm.model.Animal;
import com.zipcodewilmington.froilansfarm.model.EarCorn;

public class AnimalTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Animal ---");
        Animal animal = new Animal("Test Animal");
        
        // Test eat() 
        System.out.print("Testing eat()... ");
        animal.eat(new EarCorn());

        // Test makeNoise() 
        System.out.print("Testing makeNoise()... ");
        animal.makeNoise();
    }
}