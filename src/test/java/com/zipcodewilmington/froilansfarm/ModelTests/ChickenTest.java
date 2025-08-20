package com.zipcodewilmington.froilansfarm.ModelTests;

import com.zipcodewilmington.froilansfarm.model.Chicken;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;
//import com.zipcodewilmington.froilansfarm.model.EdibleEgg;

public class ChickenTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Chicken ---");
        Chicken chicken = new Chicken("Jasper");

        // Test makeNoise() 
        System.out.print("Testing makeNoise()... ");
        chicken.makeNoise();

        // Test yieldProduce() (not fertilized)
        System.out.print("Testing yieldProduce() when not fertilized... ");
        Edible produce = chicken.yieldProduce();
        if (produce instanceof EdibleEgg) {
            System.out.println("SUCCESS: Correctly yielded an EdibleEgg.");
        } else {
            System.out.println("FAILURE: Expected an EdibleEgg, got " + (produce != null ? produce.getName() : "null"));
        }

        // Test yieldProduce() (fertilized)
        System.out.print("Testing yieldProduce() when fertilized... ");
        chicken.setHasBeenFertilized(true);
        produce = chicken.yieldProduce();
        if (produce == null) {
            System.out.println("SUCCESS: Correctly yielded null.");
        } else {
            System.out.println("FAILURE: Expected null, got " + produce.getName());
        }
    }
}