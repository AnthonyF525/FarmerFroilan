package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Eater;
import com.zipcodewilmington.froilansfarm.interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

// Person is a LivingEntity that can make noise and eat.
public class Person extends LivingEntity implements NoiseMaker, Eater {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_MAGENTA = "\u001B[35m";

    // Constructor
    public Person(String name) {
        super(name);
    }

    // Implement makeNoise method from NoiseMaker interface
    @Override
    public void makeNoise() {
        System.out.println(this.name + " is speaking.");
    }

    // Implement eat method from Eater interface
    @Override
    public void eat(Edible food) {
        String color;
        switch (food.getName()) {
            case "Corn":
                color = "\u001B[33m"; // Yellow
                break;
            case "Tomato":
                color = "\u001B[31m"; // Red
                break;
            case "Egg":
                color = "\u001B[38;5;208m"; // Orange (256-color)
                break;
            default:
                color = "";
        }
        System.out.println(this.name + " is eating " + color + food.getName() + "\u001B[0m" + ".");
    }

    @Override
    public String getName() {
        if ("Froilan".equals(super.getName())) {
            return ANSI_BLUE + super.getName() + ANSI_RESET;
        } else if ("Froilanda".equals(super.getName())) {
            return ANSI_MAGENTA + super.getName() + ANSI_RESET;
        }
        return super.getName();
    }
}
