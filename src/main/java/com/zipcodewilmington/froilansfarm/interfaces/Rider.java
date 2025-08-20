package com.zipcodewilmington.froilansfarm.interfaces;

import com.zipcodewilmington.froilansfarm.model.Horse;

// An object that can be ridden with a specific leisure routine.
public interface Rider {

    // Methods for mounting and dismounting a Rideable object
    void mount(Rideable rideable);
    void dismount(Rideable rideable);

    // Method for taking a leisure ride on a Horse
    void takeLeisureRide(Horse horse);
}
