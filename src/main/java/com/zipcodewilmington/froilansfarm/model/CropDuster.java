package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.structures.CropRow;
import com.zipcodewilmington.froilansfarm.interfaces.Crop;

public class CropDuster extends Aircraft {

    public CropDuster (String name) {
        super(name);
    }
    
    @Override
    public void makeNoise() {
        System.out.println(name + " is whirling! ");
    }

    public void fertilize(CropRow cropRow) {
        for (Crop crop : cropRow.getCrops()) {
            crop.fertilize();
        }
        System.out.println(cropRow.getName() + " has been fertilized! ");
    }
}
