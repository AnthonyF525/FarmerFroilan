package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Crop;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class GenericCrop extends LivingEntity implements Crop {

    private boolean hasBeenHarvested = false;
    private boolean hasBeenFertilized = false;

    public GenericCrop() {
        super("Generic Crop");
    }
    
    public GenericCrop(String name) {
        super(name);
    }

    @Override
    public Edible yieldProduce() {

        // Return an anonymous Edible with name "Vegetation"
        return new Edible() {
            @Override
            public String getName() {
                return "Spinach";
            }
            @Override
            public int getNutritionalValue() {
                return 1; // or any value you want
            }
        };
    }

    @Override
    public boolean isHasBeenFertilized() { return hasBeenFertilized; }

    @Override
    public void setHasBeenFertilized(boolean b) { this.hasBeenFertilized = b; }

    @Override
    public boolean isHasBeenHarvested() { return hasBeenHarvested; }

    @Override
    public void setHasBeenHarvested(boolean b) { this.hasBeenHarvested = b; }

    @Override
    public void fertilize() {
        this.hasBeenFertilized = true;
    }
}