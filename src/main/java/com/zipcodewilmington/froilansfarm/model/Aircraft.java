package com.zipcodewilmington.froilansfarm.model;


public class Aircraft extends Vehicle {

    public Aircraft (String name) {
        super(name);
    }

    public void fly() {
        System.out.println(" The " + name + " is taking off ");
    }
    
    @Override
    public void makeNoise() {
        System.out.println("The " + name + " is humming. ");
    }
}
