package com.zipcodewilmington.froilansfarm.model;
import com.zipcodewilmington.froilansfarm.interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.interfaces.Rideable;

public class Vehicle implements NoiseMaker, Rideable {
    
    // Name of the vehicle
    protected String name;

    // Constructor
    public Vehicle(String name) {
        this.name=name;
    }

    // Implement makeNoise method from NoiseMaker interface
    @Override
    public void makeNoise() {
        System.out.println("The " + name + " is making noise. ");
    }

    // Implement mount and dismount methods from Rideable interface
    @Override
    public void mount() {
        System.out.println(" is mounting the vehicle, " + name);
    }

    // Implement dismount method from Rideable interface
    @Override
    public void dismount() {
        System.out.println(" is dismounting the vehicle," + name);
    }

    // Vehicle-specific method
    public void performMaintenance() {
        System.out.println(this.name + " is undergoing maintenance.");
    }
}