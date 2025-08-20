package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class EdibleEgg implements Edible {
    String name = "Egg";

    public EdibleEgg () {
        this.name = "Egg";
    }
    
    public String getName() {
        return "Egg";
    }

    public int getNutritionalValue() {
        return 5;
    }
}
