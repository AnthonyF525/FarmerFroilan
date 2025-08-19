package com.zipcodewilmington.froilansfarm.model;
import com.zipcodewilmington.froilansfarm.interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.interfaces.Rideable;

public class Vehicle implements NoiseMaker, Rideable {
    protected String name;
    

    public Vehicle(String name) {
        this.name=name;
    }

    @Override
    public void makeNoise() {
        System.out.println("The " + name + " is making noise. ");
    }

    @Override
    public void mount() {
        System.out.println("Someone is mounting the vehicle," + name);
    }
    
    @Override
    public void dismount() {
        System.out.println("Someone is dismounting the vehicle," + name);
    }


    public void performMaintenance() {
        System.out.println("The vehicle, " + this.name + ", is undergoing maintenance.");
    }
}