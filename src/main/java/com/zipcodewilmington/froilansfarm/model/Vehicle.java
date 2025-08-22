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
        String coloredVehicle = riderName.equalsIgnoreCase("Froilanda") ? ANSI_MAGENTA + name + ANSI_RESET
                            : riderName.equalsIgnoreCase("Froilan") ? ANSI_BLUE + name + ANSI_RESET
                            : name;
        System.out.println(coloredName + " mounts the vehicle, " + coloredVehicle + ".");
    }

    public void dismount(String riderName) {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        String coloredName = riderName.equalsIgnoreCase("Froilanda") ? ANSI_MAGENTA + riderName + ANSI_RESET
                      : riderName.equalsIgnoreCase("Froilan") ? ANSI_BLUE + riderName + ANSI_RESET
                      : riderName;
        String coloredVehicle = riderName.equalsIgnoreCase("Froilanda") ? ANSI_MAGENTA + name + ANSI_RESET
                        : riderName.equalsIgnoreCase("Froilan") ? ANSI_BLUE + name + ANSI_RESET
                        : name;
        System.out.println(coloredName + " dismounts the vehicle, " + coloredVehicle + ".");
    }

    // Vehicle-specific method
    public void performMaintenance() {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";
        if (this.name.contains("Froilanda")) {
            System.out.println(ANSI_MAGENTA + this.name + ANSI_RESET + " is undergoing maintenance.");
        } else if (this.name.contains("Froilan")) {
            System.out.println(ANSI_BLUE + this.name + ANSI_RESET + " is undergoing maintenance.");
        } else {
            System.out.println(this.name + " is undergoing maintenance.");
        }
    }
}