package com.zipcodewilmington.froilansfarm.ModelTests;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.zipcodewilmington.froilansfarm.model.Animal;

public class AnimalTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Animal ---");
        Animal animal = new Animal("Test Animal");
        
        // Test eat() method
        System.out.print("Testing eat()... ");
        animal.eat(new EarCorn());

        // Test makeNoise() method
        System.out.print("Testing makeNoise()... ");
        animal.makeNoise();
    }
}