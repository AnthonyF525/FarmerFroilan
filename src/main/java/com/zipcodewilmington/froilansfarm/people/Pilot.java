package com.zipcodewilmington.froilansfarm.people;

import com.zipcodewilmington.froilansfarm.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.interfaces.Rider;
import com.zipcodewilmington.froilansfarm.model.Horse;
import com.zipcodewilmington.froilansfarm.model.Person;
import com.zipcodewilmington.froilansfarm.model.Vehicle;

// Pilot class implements Rider interface.
public class Pilot extends Person implements Rider {
    
    // Constructor
    public Pilot(String name) {
        super(name);
    }

    // Implement mount method from Rider interface
    @Override
    public void mount(Rideable rideable) {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";
        String vehicleName = rideable instanceof Vehicle && ((Vehicle) rideable).getName().equals("Froilanda's CropDuster")
            ? ANSI_MAGENTA + ((Vehicle) rideable).getName() + ANSI_RESET
            : ((Vehicle) rideable).getName();
        System.out.println("Froilanda mounts the vehicle, " + vehicleName);
        rideable.mount();
    }

    // Implement dismount method from Rider interface
    @Override
    public void dismount(Rideable rideable) {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";
        String vehicleName = rideable instanceof Vehicle && ((Vehicle) rideable).getName().equals("Froilanda's CropDuster")
            ? ANSI_MAGENTA + ((Vehicle) rideable).getName() + ANSI_RESET
            : ((Vehicle) rideable).getName();
        System.out.println("Froilanda dismounts the vehicle, " + vehicleName);
        rideable.dismount();
    }
    
    // Implement takeLeisureRide method from Rider interface
    @Override
    public void takeLeisureRide(Horse horse) {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_BROWN = "\u001B[38;5;94m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(
            ANSI_MAGENTA + "Froilanda" + ANSI_RESET + " takes a leisure ride on " + ANSI_BROWN + horse.getName() + ANSI_RESET + "."
        );
        horse.mount();
        horse.dismount();
    }
}
