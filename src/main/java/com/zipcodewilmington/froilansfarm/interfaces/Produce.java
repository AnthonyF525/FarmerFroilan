package com.zipcodewilmington.froilansfarm.interfaces;

// An object that can yield a produce.
public interface Produce {

    // Method to yield produce
    Edible yieldProduce();
    
    // Method to check if the produce has been fertilized
    boolean isHasBeenFertilized();

    // Method to set the fertilization status of the produce
    void setHasBeenFertilized(boolean b);
}