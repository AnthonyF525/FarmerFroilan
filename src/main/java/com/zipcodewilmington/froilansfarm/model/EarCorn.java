package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class EarCorn implements Edible{
    String name = "Corn";

    public EarCorn () {
        this.name = "Corn";
    }
    
    public String getName() {
        return "Corn";
    }

    public int getNutritionalValue() {
        return 4;
    }
    
}
