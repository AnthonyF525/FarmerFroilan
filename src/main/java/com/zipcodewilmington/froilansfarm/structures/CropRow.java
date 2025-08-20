package com.zipcodewilmington.froilansfarm.structures;

import com.zipcodewilmington.froilansfarm.interfaces.Crop;

import java.util.ArrayList;
import java.util.List;


public class CropRow {
    private String name;
    private List<Crop> crops = new ArrayList<>();

    public CropRow(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCrop(Crop crop) {
        crops.add(crop);
    }

    public List<Crop> getCrops() {
        return crops;
    }
    

}
