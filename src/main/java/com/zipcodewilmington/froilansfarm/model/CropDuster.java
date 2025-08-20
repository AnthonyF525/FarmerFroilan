package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.structures.CropRow;
import com.zipcodewilmington.froilansfarm.interfaces.Crop;

public class CropDuster extends Aircraft {

    public CropDuster (String name) {
        super(name);
    }
    
    @Override
    public void makeNoise() {
        System.out.println("The " + name + " is making whirling. ");
    }

    public void fertilize(CropRow cropRow) {
        for (Crop crop : cropRow.getCrops()) {
            crop.fertilize();
        }
        System.out.println("The " + cropRow.getName() + " has been fertilized. ");
    }
}
