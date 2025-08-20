package com.zipcodewilmington.froilansfarm.InterfaceTests;

import com.zipcodewilmington.froilansfarm.interfaces.Eater;
//import com.zipcodewilmington.froilansfarm.model.EarCorn;
import com.zipcodewilmington.froilansfarm.model.Person;

public class EaterTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Eater Interface ---");
        Person froilan = new Person("Froilan");
        EarCorn corn = new EarCorn();
        
        // An Eater must be able to eat an Edible object
        froilan.eat(corn);
        System.out.println("Eater interface test complete.");
    }
}