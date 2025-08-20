package com.zipcodewilmington.froilansfarm.InterfaceTests;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import com.zipcodewilmington.froilansfarm.interfaces.Produce;
import com.zipcodewilmington.froilansfarm.model.Chicken;

public class ProduceTest {
    public static void main(String[] args) {
        
        System.out.println("\n--- Testing Produce Interface ---");
        Produce chicken = new Chicken("Jasper");
        
        // Produce must yield a produce
        Edible product = chicken.yieldProduce();
        System.out.println("Yielded: " + (product != null ? product.getName() : "null"));
        
        // Produce must have a fertilized state
        System.out.println("Is fertilized: " + chicken.isHasBeenFertilized());
        chicken.setHasBeenFertilized(true);
        System.out.println("Is now fertilized: " + chicken.isHasBeenFertilized());
        System.out.println("Produce interface test complete.");
    }
}