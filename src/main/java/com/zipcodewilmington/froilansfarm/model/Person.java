package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Eater;
import com.zipcodewilmington.froilansfarm.interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

// Person is a LivingEntity that can make noise and eat.
public class Person extends LivingEntity implements NoiseMaker, Eater {

    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_MAGENTA = "\u001B[35m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_ORANGE = "\u001B[38;5;208m";
    private static final String ANSI_RESET = "\u001B[0m";

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
        String colorName = this.name.equalsIgnoreCase("Froilan") ? ANSI_BLUE : 
                           this.name.equalsIgnoreCase("Froilanda") ? ANSI_MAGENTA : "";
        String colorFood;
        switch (food.getName()) {
            case "Corn":
                colorFood = ANSI_YELLOW;
                break;
            case "Tomato":
                colorFood = ANSI_RED;
                break;
            case "Egg":
                colorFood = ANSI_ORANGE;
                break;
            default:
                colorFood = "";
        }
        System.out.println(colorName + this.name + ANSI_RESET + " is eating " + colorFood + food.getName() + ANSI_RESET + ".");
    }

    @Override
    public String getName() {
        if ("Froilanda".equalsIgnoreCase(super.getName())) {
            return "\u001B[35m" + super.getName() + "\u001B[0m";
        } else if ("Froilan".equalsIgnoreCase(super.getName())) {
            return "\u001B[34m" + super.getName() + "\u001B[0m";
        }
        return super.getName();
    }
}
