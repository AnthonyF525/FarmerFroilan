package com.zipcodewilmington.froilansfarm.interfaces;

import com.zipcodewilmington.froilansfarm.structures.*;
import com.zipcodewilmington.froilansfarm.model.Tractor;

// An object that can plant and harvest crops.
public interface Botanist {
    void plant(Crop crop, CropRow cropRow);
    void harvest(Tractor tractor, Crop crop);
}
