// ChickenCoopTest.java
package com.zipcodewilmington.froilansfarm.StructureTests;

import com.zipcodewilmington.froilansfarm.structures.ChickenCoop;
import com.zipcodewilmington.froilansfarm.model.Chicken;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import java.util.List;

public class ChickenCoopTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing ChickenCoop Class ---");
        ChickenCoop coop = new ChickenCoop("Main Coop");
        
        System.out.println("Coop name: " + coop.getName());
        
        // Add chickens (assuming Chicken class exists)
        // Chicken chicken1 = new Chicken("Clucky");
        // coop.addChicken(chicken1);
        
        System.out.println("Number of chickens: " + coop.getChickens().size());
        
        // Test egg collection
        List<Edible> eggs = coop.collectEggs();
        System.out.println("Eggs collected: " + eggs.size());
        
        coop.cleanStructure();
        System.out.println("ChickenCoop test complete.");
    }
}
