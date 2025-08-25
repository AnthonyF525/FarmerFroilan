package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.interfaces.Rideable;

public class Vehicle implements NoiseMaker, Rideable {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Implement makeNoise method from NoiseMaker interface
    @Override
    public void makeNoise() {
        System.out.println("The " + name + " is making noise. ");
    }

    // Implement mount and dismount methods from Rideable interface
    @Override
    public void mount() {
        System.out.println("Someone mounts the vehicle, " + name);
    }

    @Override
    public void dismount() {
        System.out.println("Someone dismounts the vehicle, " + name);
    }

    public void mount(String riderName) {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        String coloredName = riderName.equalsIgnoreCase("Froilanda") ? ANSI_MAGENTA + riderName + ANSI_RESET
                      : riderName.equalsIgnoreCase("Froilan") ? ANSI_BLUE + riderName + ANSI_RESET
                      : riderName;
        System.out.println(coloredName + " mounts the vehicle, " + name + ".");
    }

    public void dismount(String riderName) {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        String coloredName = riderName.equalsIgnoreCase("Froilanda") ? ANSI_MAGENTA + riderName + ANSI_RESET
                  : riderName.equalsIgnoreCase("Froilan") ? ANSI_BLUE + riderName + ANSI_RESET
                  : riderName;
        System.out.println(coloredName + " dismounts the vehicle, " + name + ".");
    }

    // Vehicle-specific method
    public void performMaintenance() {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";
        if (this.name.startsWith("Froilanda's")) {
            System.out.println(ANSI_MAGENTA + "Froilanda's" + ANSI_RESET + " CropDuster is undergoing maintenance...");
        } else if (this.name.startsWith("Froilan's")) {
            System.out.println(ANSI_BLUE + "Froilan's" + ANSI_RESET + " Tractor is undergoing maintenance...");
        } else {
            System.out.println(this.name + " is undergoing maintenance...");
        }
    }
}