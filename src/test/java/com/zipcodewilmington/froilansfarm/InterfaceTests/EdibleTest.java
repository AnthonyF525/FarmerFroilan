package com.zipcodewilmington.froilansfarm.InterfaceTests;

//import com.zipcodewilmington.froilansfarm.model.EdibleEgg;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class EdibleTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Edible Interface ---");
        Edible egg = new EdibleEgg();
        
        // An Edible must have a name and calories
        System.out.println("Edible name: " + egg.getName());
        System.out.println("Edible calories: " + egg.getCalories());
        System.out.println("Edible interface test complete.");
    }
}