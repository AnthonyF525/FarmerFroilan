package com.zipcodewilmington.froilansfarm.people;

import com.zipcodewilmington.froilansfarm.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.interfaces.Rider;
import com.zipcodewilmington.froilansfarm.model.Horse;
import com.zipcodewilmington.froilansfarm.model.Person;

// Pilot class implements Rider interface.
public class Pilot extends Person implements Rider {
    
    // Constructor
    public Pilot(String name) {
        super(name);
    }

    // Implement mount method from Rider interface
    @Override
    public void mount(Rideable rideable) {
        rideable.mount();
    }

    // Implement dismount method from Rider interface
    @Override
    public void dismount(Rideable rideable) {
        rideable.dismount();
    }
    
    // Implement takeLeisureRide method from Rider interface
    @Override
    public void takeLeisureRide(Horse horse) {
        System.out.println(this.name + " is taking a leisure ride on " + horse.getName() + ".");
        horse.mount();
        horse.dismount();
    }
}
