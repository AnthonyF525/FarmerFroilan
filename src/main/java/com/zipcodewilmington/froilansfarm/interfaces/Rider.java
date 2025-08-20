package com.zipcodewilmington.froilansfarm.interfaces;

// An object that can be ridden with a specific leisure routine.
interface Rider {
    void mount(Rideable rideable);
    void dismount(Rideable rideable);
    void takeLeisureRide(Horse horse);
}
