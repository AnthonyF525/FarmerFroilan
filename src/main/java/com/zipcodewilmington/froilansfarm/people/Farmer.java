package com.zipcodewilmington.froilansfarm.people;

import com.zipcodewilmington.froilansfarm.model.Person;
import com.zipcodewilmington.froilansfarm.interfaces.Crop;
import com.zipcodewilmington.froilansfarm.structures.CropRow;
import com.zipcodewilmington.froilansfarm.model.Tractor;
import com.zipcodewilmington.froilansfarm.model.Horse;
import com.zipcodewilmington.froilansfarm.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.interfaces.Rider;
import com.zipcodewilmington.froilansfarm.interfaces.Botanist;


// Farmer class implements Rider and Botanist interfaces.
public class Farmer extends Person implements Rider, Botanist {
    public Farmer(String name) {
        super(name);
    }

    // Implement mount method from Rider interface
    @Override
    public void mount(Rideable rideable) {
        rideable.mount();
    }

    // Implement dismount method from Rider interface
    @Override
    public void dismount(Rideable rideable) {
        rideable.dismount();
    }
    
    // Implement takeLeisureRide method from Rider interface
    @Override
    public void takeLeisureRide(Horse horse) {
        System.out.println(this.name + " is taking a leisure ride on " + horse.getName() + ".");
        horse.mount();
        horse.dismount();
    }

    // Implement plant method from Botanist interface
    @Override
    public void plant(Crop crop, CropRow cropRow) {
        System.out.println(this.name + " is planting a " + crop.getName() + " in " + cropRow.getName() + ".");
        cropRow.addCrop(crop);
    }

    // Implement harvest method from Botanist interface
    public void harvest(Tractor tractor, Crop crop) {
        tractor.harvest(crop);
    }
}