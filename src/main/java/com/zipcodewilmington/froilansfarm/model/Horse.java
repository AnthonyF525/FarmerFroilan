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
        System.out.println( this.name + ", is neighing!");
    }

    // Implement mount and dismount methods from Rideable interface
    @Override
    public void mount() {;
    }

    @Override
    public void dismount() {;
    }
}
