package com.zipcodewilmington.froilansfarm.interfaces;

// A specific type of produce that is a plant.
interface Crop extends Produce {
    boolean isHasBeenHarvested();
    void setHasBeenHarvested(boolean b);
    void fertilize();
}
