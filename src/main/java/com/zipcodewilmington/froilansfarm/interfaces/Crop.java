package com.zipcodewilmington.froilansfarm.interfaces;

import com.zipcodewilmington.froilansfarm.interfaces.Produce;

// A specific type of produce that is a plant.
public interface Crop extends Produce {
    boolean isHasBeenHarvested();
    void setHasBeenHarvested(boolean b);
    void fertilize();
}
