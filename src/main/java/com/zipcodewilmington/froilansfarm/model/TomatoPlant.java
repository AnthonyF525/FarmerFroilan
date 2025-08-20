package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Crop;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class TomatoPlant extends LivingEntity implements Crop {

    // State variables to track if the plant has been fertilized and harvested
    private boolean hasBeenFertilized = false;
    private boolean hasBeenHarvested = false;

    // Constructor
    public TomatoPlant(String name) {
        super(name);
    }

    // Implement yieldProduce method from Crop interface
    @Override
    public Edible yieldProduce() {
        if (hasBeenFertilized && !hasBeenHarvested) {
            this.hasBeenHarvested = true;
            return new Tomato();
        } else {
            System.out.println("The tomato plant cannot be harvested yet.");
            return null;
        }
    }

    // Implement fertilization methods from Crop interface
    @Override
    public boolean isHasBeenFertilized() { return hasBeenFertilized; }

    //Implement fertilization methods from Crop interface
    @Override
    public void setHasBeenFertilized(boolean b) { this.hasBeenFertilized = b; }

    // Implement harvest methods from Crop interface
    @Override
    public boolean isHasBeenHarvested() { return hasBeenHarvested; }

    // Implement harvest methods from Crop interface
    @Override
    public void setHasBeenHarvested(boolean b) { this.hasBeenHarvested = b; }

    // Implement fertilize method from Crop interface
    @Override
    public void fertilize() {
        this.hasBeenFertilized = true;
    }
}
