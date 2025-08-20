package com.zipcodewilmington.froilansfarm.interfaces;


// A specific type of produce that is a plant.
public interface Crop extends Produce {

    // New methods specific to Crop
    boolean isHasBeenHarvested();
    void setHasBeenHarvested(boolean b);
    void fertilize();
}
