package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Rideable;

// Horse is an Animal that can be ridden.
public class Horse extends Animal implements Rideable {
    
    // Constructor
    public Horse(String name) {
        super(name);
    }

    // Override makeNoise method from Animal class
    @Override
    public void makeNoise() {
        System.out.println("The horse, " + this.name + ", is neighing.");
    }

    // Implement mount and dismount methods from Rideable interface
    @Override
    public void mount() {
        System.out.println("The horse, " + this.name + ", has been mounted.");
    }

    @Override
    public void dismount() {
        System.out.println("The horse, " + this.name + ", has been dismounted.");
    }
}
