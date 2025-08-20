package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Eater;
import com.zipcodewilmington.froilansfarm.interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

// Person is a LivingEntity that can make noise and eat.
public class Person extends LivingEntity implements NoiseMaker, Eater {

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
        System.out.println(this.name + " is eating " + food.getName() + ".");
    }
}
