package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Crop;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class GenericCrop extends LivingEntity implements Crop {

    private boolean hasBeenHarvested = false;
    private boolean hasBeenFertilized = false;

    public GenericCrop(String name) {
        super(name);
    }

    @Override
    public Edible yieldProduce() {
        if (hasBeenFertilized && !hasBeenHarvested) {
            this.hasBeenHarvested = true;
            return new Tomato(); // Yielding a generic edible item
        } else {
            System.out.println("This crop cannot be harvested yet.");
            return null;
        }
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