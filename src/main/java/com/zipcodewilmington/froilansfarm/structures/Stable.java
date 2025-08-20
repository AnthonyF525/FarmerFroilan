package com.zipcodewilmington.froilansfarm.structures;

import java.util.List;
import java.util.ArrayList;
import com.zipcodewilmington.froilansfarm.model.Horse;

public class Stable {
    private String name;
    private List<Horse> horses = new ArrayList<>();
    
    public Stable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addHorse(Horse horse) {
        horses.add(horse);
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void cleanStructure() {
        System.out.println("Stables are being cleaned.");
    }



}
