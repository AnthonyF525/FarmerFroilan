package com.zipcodewilmington.froilansfarm.people;

import com.zipcodewilmington.froilansfarm.model.Person;
import com.zipcodewilmington.froilansfarm.interfaces.Crop;
import com.zipcodewilmington.froilansfarm.structures.CropRow;
import com.zipcodewilmington.froilansfarm.model.Tractor;
import com.zipcodewilmington.froilansfarm.model.Horse;
import com.zipcodewilmington.froilansfarm.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.interfaces.Rider;

import com.zipcodewilmington.froilansfarm.interfaces.Botanist;

// Farmer class implements Rider and Botanist interfaces.
public class Farmer extends Person implements Rider, Botanist {
    public Farmer(String name) {
        super(name);
    }

    // Implement mount method from Rider interface
    @Override
    public void mount(Rideable rideable) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " mounts the vehicle.");
        rideable.mount();
    }

    // Implement dismount method from Rider interface
    @Override
    public void dismount(Rideable rideable) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " dismounts the vehicle.");
        rideable.dismount();
    }

    // Implement takeLeisureRide method from Rider interface
    @Override
    public void takeLeisureRide(Horse horse) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_BROWN = "\u001B[38;5;94m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(
                ANSI_BLUE + "Froilan" + ANSI_RESET + " takes a leisure ride on " + ANSI_BROWN + horse.getName()
                        + ANSI_RESET + ".");
    }

    // Implement plant method from Botanist interface
    @Override
    public void plant(Crop crop, CropRow cropRow) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        String coloredName = this.name.equalsIgnoreCase("Froilan") ? ANSI_BLUE + this.name + ANSI_RESET : this.name;
        // Always use crop.getName() for the crop type
        String cropType = crop.getName();
        System.out.println("* " + coloredName + " is planting a " + cropType + " in " + cropRow.getName() + ".");
        cropRow.addCrop(crop);
    }

    // Implement harvest method from Botanist interface
    public void harvest(Tractor tractor, Crop crop) {
        tractor.harvest(crop);
    }
}