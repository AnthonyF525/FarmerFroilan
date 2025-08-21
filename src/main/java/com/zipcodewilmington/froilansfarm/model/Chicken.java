package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import com.zipcodewilmington.froilansfarm.interfaces.Produce;
import com.zipcodewilmington.froilansfarm.interfaces.NoiseMaker;


// Chicken is a type of Animal and implements Produce interface.
public class Chicken extends Animal implements Produce {
    
    // New field to track fertilization status
    private boolean hasBeenFertilized = false;

    // Constructor
    public Chicken(String name) {
        super(name);
    }

    // Implement makeNoise method from NoiseMaker interface
    @Override
    public void makeNoise() {
        System.out.println(this.name + ", is clucking!");
    }

    // Implement yieldProduce method from Produce interface
    @Override
    public Edible yieldProduce() {
        if (!hasBeenFertilized) {
            System.out.println("The chicken, " + this.name + ", lays an egg.");
            return new EdibleEgg();
        } else {
            System.out.println("The chicken, " + this.name + ", lays an unedible fertilized egg.");
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
}
