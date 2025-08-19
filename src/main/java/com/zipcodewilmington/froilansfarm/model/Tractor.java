package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Crop;
import com.zipcodewilmington.froilansfarm.structures.CropRow;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class Tractor extends Vehicle {

    public Tractor (String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("The " + name + " is making whirling. ");
    }

    public Edible harvest(Crop crop) {
        Edible harvestedItem = crop.yieldProduce();
        System.out.println(crop + "was harvested. ");
        return harvestedItem;

    }

    public void prepareRow(CropRow cropRow) {
        System.out.println("The " + cropRow.getName() + " is ready for sowing!");
    }
}
