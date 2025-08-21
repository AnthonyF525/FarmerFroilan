package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Crop;
import com.zipcodewilmington.froilansfarm.structures.CropRow;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import com.zipcodewilmington.froilansfarm.interfaces.FarmVehicle;

public class Tractor extends Vehicle implements FarmVehicle {

    public Tractor(String name) {
        super(name);
    }

    @Override
    public void operateOnFarm() {
        System.out.println("The tractor is operating on the farm.");
    }

    public void makeNoise() {
        System.out.println("The " + name + " is making humming. ");
    }

    public Edible harvest(Crop crop) {
        Edible harvestedItem = crop.yieldProduce();
        System.out.println(crop.getName() + " was harvested.");
        return harvestedItem;

    }

    public void prepareRow(CropRow cropRow) {
        System.out.println("The " + cropRow.getName() + " is ready for sowing!");
    }
}
