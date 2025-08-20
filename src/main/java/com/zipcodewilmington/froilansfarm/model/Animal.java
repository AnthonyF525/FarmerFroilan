package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import com.zipcodewilmington.froilansfarm.interfaces.Eater;
import com.zipcodewilmington.froilansfarm.interfaces.NoiseMaker;

// Animal implements Eater and NoiseMaker interfaces.
public class Animal extends LivingEntity implements Eater, NoiseMaker {
    
    // Constructor
    public Animal(String name) {
        super(name);
    }

    // Implement eat method from Eater interface
    @Override
    public void eat(Edible food) {
        System.out.println(this.name + " is eating a " + food.getName() + ".");
    }

    // Implement makeNoise method from NoiseMaker interface
    @Override
    public void makeNoise() {
        System.out.println(this.name + " is making a noise.");
    }
}
