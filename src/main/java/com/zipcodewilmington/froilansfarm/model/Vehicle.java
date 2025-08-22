package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.interfaces.Rideable;

public class Vehicle implements NoiseMaker, Rideable {

    // Name of the vehicle
    protected String name;

    // Constructor
    public Vehicle(String name) {
        this.name = name;
    }

    // Implement makeNoise method from NoiseMaker interface
    @Override
    public void makeNoise() {
        System.out.println("The " + name + " is making noise. ");
    }

    // Implement mount and dismount methods from Rideable interface
    @Override
    public void mount() {
        System.out.println("Someone mounts the vehicle, " + name);
    }

    @Override
    public void dismount() {
        System.out.println("Someone dismounts the vehicle, " + name);
    }

    public void mount(String riderName) {
        System.out.println(riderName + " mounts the vehicle, " + name);
    }

    public void dismount(String riderName) {
        System.out.println(riderName + " dismounts the vehicle, " + name);
    }

    // Vehicle-specific method
    public void performMaintenance() {
        System.out.println(this.name + " is undergoing maintenance.");
    }
}