package com.zipcodewilmington.froilansfarm.model;

// Aircraft is a type of Vehicle.
public class Aircraft extends Vehicle {

    // Constructor
    public Aircraft (String name) {
        super(name);
    }

    // Aircraft-specific methods
    public void fly() {
        System.out.println(" The " + name + " is taking off ");
    }

    // Override makeNoise method from Vehicle class
    @Override
    public void makeNoise() {
        System.out.println("The " + name + " is humming. ");
    }

    public String getName() {
        return this.name;
    }
}
