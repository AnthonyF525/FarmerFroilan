package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Crop;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class CornStalk extends LivingEntity implements Crop {
    private boolean hasBeenFertilized = false;
    private boolean hasBeenHarvested = false;
    

    public CornStalk(String name) {
        super(name);
    }

    @Override
    public Edible yieldProduce() {
        if (hasBeenFertilized && !hasBeenHarvested) {
            hasBeenHarvested = true;
            return new EarCorn();
        }
        return null;
    }
    
    @Override
    public void fertilize() {
        hasBeenFertilized = true;
    }
    
    @Override
    public boolean isHasBeenFertilized() {
        return hasBeenFertilized;
    }
    
    @Override
    public void setHasBeenFertilized(boolean hasBeenFertilized) {
        this.hasBeenFertilized = hasBeenFertilized;
    }
    
    @Override
    public boolean isHasBeenHarvested() {
        return hasBeenHarvested;
    }
    
    @Override
    public void setHasBeenHarvested(boolean hasBeenHarvested) {
        this.hasBeenHarvested = hasBeenHarvested;
    }


}