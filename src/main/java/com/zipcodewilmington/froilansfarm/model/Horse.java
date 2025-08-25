package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

// Horse is an Animal that can be ridden.
public class Horse extends Animal implements Rideable {

    protected boolean isHealthy = true;

    // Constructor
    public Horse(String name) {
        super(name);
    }

    // Override makeNoise method from Animal class
    @Override
    public void makeNoise() {
        final String ANSI_BROWN = "\u001B[38;5;94m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(" * " + ANSI_BROWN + this.name + ANSI_RESET + ", is neighing!");
    }

    // Implement mount and dismount methods from Rideable interface
    @Override
    public void mount() {
        ;
    }

    @Override
    public void dismount() {
        ;
    }

    @Override
    public void eat(Edible food) {
        final String ANSI_BROWN = "\u001B[38;5;94m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";
        String foodName = food.getName();
        if ("Corn".equalsIgnoreCase(foodName) || "EarCorn".equalsIgnoreCase(foodName)) {
            System.out.println(
                    " * " + ANSI_BROWN + this.name + ANSI_RESET + " is eating " + ANSI_YELLOW + "Corn" + ANSI_RESET
                            + ".");
        } else {
            System.out.println(" * " + ANSI_BROWN + this.name + ANSI_RESET + " is eating " + foodName + ".");
        }
    }

    public void morningRide(String riderName) {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_BROWN = "\u001B[38;5;94m";
        final String ANSI_RESET = "\u001B[0m";
        String coloredRider = riderName.equalsIgnoreCase("Froilanda") ? ANSI_MAGENTA + riderName + ANSI_RESET
                : riderName.equalsIgnoreCase("Froilan") ? ANSI_BLUE + riderName + ANSI_RESET
                        : riderName;
        System.out
                .println(" * " + coloredRider + " took " + ANSI_BROWN + this.name + ANSI_RESET + " on a morning ride!");
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        this.isHealthy = healthy;
    }

    public void checkHealth() {
        final String ANSI_BROWN = "\u001B[38;5;94m";
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.print("  * " + ANSI_BROWN + this.name + ANSI_RESET + " is being checked by " + ANSI_MAGENTA
                + "Froilanda" + ANSI_RESET + "...");
        if (isHealthy) {
            System.out.println(ANSI_BROWN + this.name + ANSI_RESET + " is " + ANSI_GREEN + "healthy!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_BROWN + this.name + ANSI_RESET + " is " + ANSI_RED + "not healthy!" + ANSI_RESET);
        }
    }

    public void giveMedicine() {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_BROWN = "\u001B[38;5;94m";
        final String ANSI_RESET = "\u001B[0m";
        this.isHealthy = true;
        System.out.println("  * " + ANSI_MAGENTA + "Froilanda" + ANSI_RESET + " gives medicine to " +
                ANSI_BROWN + this.name + ANSI_RESET + "... " +
                ANSI_BROWN + this.name + ANSI_RESET + " is now " + ANSI_GREEN + "healthy!" + ANSI_RESET);
    }
}
