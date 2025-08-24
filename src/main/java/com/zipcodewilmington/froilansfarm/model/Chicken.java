package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import com.zipcodewilmington.froilansfarm.interfaces.Produce;
import com.zipcodewilmington.froilansfarm.interfaces.NoiseMaker;

// Chicken is a type of Animal and implements Produce interface.
public class Chicken extends Animal implements Produce {

    // New field to track fertilization status
    private boolean hasBeenFertilized = false;

    protected boolean isHealthy = true;

    // Constructor
    public Chicken(String name) {
        super(name);
    }

    // Implement makeNoise method from NoiseMaker interface
    @Override
    public void makeNoise() {
        final String ANSI_BROWN = "\u001B[38;5;94m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_BROWN + this.name + ANSI_RESET + ", is clucking!");
    }

    // Implement yieldProduce method from Produce interface
    @Override
    public Edible yieldProduce() {
        final String ANSI_BROWN = "\u001B[38;5;94m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        if (!hasBeenFertilized) {
            System.out.println("* " + ANSI_BROWN + this.name + ANSI_RESET + ", lays an egg.");
            return new EdibleEgg();
        } else {
            System.out.println("* " + ANSI_BROWN + this.name + ANSI_RESET + ", lays an " + ANSI_RED + "unedible fertilized egg" + ANSI_RESET + ".");
            return null;
        }
    }

    // Implement fertilization methods from Produce interface
    @Override
    public boolean isHasBeenFertilized() {
        return hasBeenFertilized;
    }

    // Setter for fertilization status
    @Override
    public void setHasBeenFertilized(boolean b) {
        this.hasBeenFertilized = b;
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
