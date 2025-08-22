package com.zipcodewilmington.froilansfarm.model;

// Aircraft is a type of Vehicle.
public class Aircraft extends Vehicle {

    // Constructor
    public Aircraft (String name) {
        super(name);
    }

    // Aircraft-specific methods
    public void fly(String riderName) {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";
        String coloredName = riderName.equalsIgnoreCase("Froilanda") ? ANSI_MAGENTA + riderName + ANSI_RESET : riderName;

        if (name.startsWith("Froilanda's")) {
            System.out.println(ANSI_MAGENTA + "Froilanda" + ANSI_RESET + "'s CropDuster is taking off");
        } else {
            System.out.println(coloredName + "'s " + name + " is taking off");
        }
    }

    // Override makeNoise method from Vehicle class
    @Override
    public void makeNoise() {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";
        // If you want to show Froilanda's name in magenta when making noise:
        System.out.println(ANSI_MAGENTA + "Froilanda" + ANSI_RESET + "'s " + name + " is humming. ");
    }

    public String getName() {
        return this.name;
    }
}
