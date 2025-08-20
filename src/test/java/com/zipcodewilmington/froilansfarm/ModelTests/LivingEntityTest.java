package com.zipcodewilmington.froilansfarm.ModelTests;

import com.zipcodewilmington.froilansfarm.model.LivingEntity;

public class LivingEntityTest {
    public static void main(String[] args) {
        System.out.println("--- Testing LivingEntity ---");

        // Create an instance of a concrete subclass to test the abstract class
        LivingEntity entity = new LivingEntity("Test Entity") {};
        
        // Test getName()
        String name = entity.getName();
        if ("Test Entity".equals(name)) {
            System.out.println("SUCCESS: getName() returned the correct name.");
        } else {
            System.out.println("FAILURE: getName() returned '" + name + "', expected 'Test Entity'.");
        }
        
        // Test checkHealth()
        System.out.print("Testing checkHealth()... ");
        entity.checkHealth();
    }
}