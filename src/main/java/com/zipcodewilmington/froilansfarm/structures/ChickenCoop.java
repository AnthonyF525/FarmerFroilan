package com.zipcodewilmington.froilansfarm.structures;

import java.util.List;
import java.util.ArrayList;
import com.zipcodewilmington.froilansfarm.model.Chicken;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class ChickenCoop {

    private String name;
    private List<Chicken> chickens = new ArrayList<>();
    
    public ChickenCoop (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addChicken(Chicken chicken) {
        chickens.add(chicken);
    }

    public List<Chicken> getChickens() {
        return chickens;
    }

    public List<Edible> collectEggs() {
        List<Edible> eggs = new ArrayList<>();
        for (Chicken chicken : chickens) {
            Edible egg = chicken.yieldProduce();
            if (egg != null) {
                eggs.add(egg);
            }
        }
        return eggs;
    }
    
    public void cleanStructure() {
        System.out.println("Coop is being cleaned.");
    }
}
