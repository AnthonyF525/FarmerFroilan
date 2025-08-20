package com.zipcodewilmington.froilansfarm.ModelTests;

import com.zipcodewilmington.froilansfarm.model.Person;
import com.zipcodewilmington.froilansfarm.model.Tomato;

public class PersonTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Person ---");
        Person person = new Person("Test Person");
        
        // Test eat()
        System.out.print("Testing eat()... ");
        person.eat(new Tomato());

        // Test makeNoise()
        System.out.print("Testing makeNoise()... ");
        person.makeNoise();
    }
}