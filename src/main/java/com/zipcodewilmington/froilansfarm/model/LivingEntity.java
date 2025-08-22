package com.zipcodewilmington.froilansfarm.model;

// LivingEntity is a base class for all living entities on the farm.
public abstract class LivingEntity {

final String ANSI_GREEN = "\u001B[32m";

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
        final String ANSI_BROWN = "\u001B[38;5;94m";
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println("   "+ANSI_BROWN + this.name + ANSI_RESET + " is being checked by " + ANSI_MAGENTA + "Froilanda" + ANSI_RESET + "..."+ANSI_BROWN + this.name + ANSI_RESET + " is healthy!" + ANSI_RESET);
    }
}