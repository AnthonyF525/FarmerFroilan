package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class Tomato implements Edible{
    String name = "Tomato";

    public Tomato () {
        this.name = "Tomato";
    }
    
    public String getName() {
        return "Tomato";
    }

    public int getNutritionalValue() {
        return 2;
    }
}
