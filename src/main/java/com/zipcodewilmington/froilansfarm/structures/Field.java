package com.zipcodewilmington.froilansfarm.structures;

import java.util.List;
import java.util.ArrayList;

public class Field {
    private String name;
    private List<CropRow> cropRows = new ArrayList<>();
    
    public Field(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCropRow(CropRow cropRow) {
        cropRows.add(cropRow);
    }

    public List<CropRow> getCropRows() {
        return cropRows;
    }

    public CropRow getCropRow(int index) {
        return cropRows.get(index);
    }
}
