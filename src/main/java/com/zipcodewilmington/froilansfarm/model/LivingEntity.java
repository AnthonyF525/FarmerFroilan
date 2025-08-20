package com.zipcodewilmington.froilansfarm.model;

// LivingEntity is a base class for all living entities on the farm.
public abstract class LivingEntity {

    // Name of the living entity
    protected String name;

    // Constructor
    public LivingEntity(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }
    
    // New method for animal health check
    public void checkHealth() {
        System.out.println(this.name + " is being checked for health.");
    }
}
