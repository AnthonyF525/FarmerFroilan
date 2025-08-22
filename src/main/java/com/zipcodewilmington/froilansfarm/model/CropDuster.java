package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.structures.CropRow;
import com.zipcodewilmington.froilansfarm.interfaces.Crop;

public class CropDuster extends Aircraft {

    public CropDuster (String name) {
        super(name);
    }
    
    @Override
    public void makeNoise() {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";
        if (name.startsWith("Froilanda's")) {
            System.out.println(ANSI_MAGENTA + "Froilanda's CropDuster" + ANSI_RESET + " is whirling! ");
        } else {
            System.out.println(name + " is whirling! ");
        }
    }

    public void fertilize(CropRow cropRow) {
        for (Crop crop : cropRow.getCrops()) {
            crop.fertilize();
        }
        System.out.println(cropRow.getName() + " has been fertilized! ");
    }
    
    @Override
    public void fly(String riderName) {
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";
        String coloredName = name.equals("Froilanda's CropDuster") ? ANSI_MAGENTA + name + ANSI_RESET : name;
        System.out.println(coloredName + " is taking off.");
    }
}
