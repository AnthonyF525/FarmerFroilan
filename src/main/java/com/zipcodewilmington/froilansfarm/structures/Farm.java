package com.zipcodewilmington.froilansfarm.structures;

import java.util.List;
import java.util.ArrayList;
import com.zipcodewilmington.froilansfarm.structures.Field;
import com.zipcodewilmington.froilansfarm.structures.Stable;
import com.zipcodewilmington.froilansfarm.structures.ChickenCoop;
import com.zipcodewilmington.froilansfarm.structures.FarmHouse;
import com.zipcodewilmington.froilansfarm.model.Vehicle;
import com.zipcodewilmington.froilansfarm.model.Aircraft;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import com.zipcodewilmington.froilansfarm.interfaces.FarmVehicle;

public class Farm {
    private Field field;
    private List<Stable> stables = new ArrayList<>();
    private List<ChickenCoop> chickenCoops = new ArrayList<>();
    private FarmHouse farmhouse;
    private List<Vehicle> farmVehicles = new ArrayList<>();
    private List<Aircraft> aircraft = new ArrayList<>();
    private List<Edible> harvestedProduce = new ArrayList<>();

    public Farm(Field field, FarmHouse farmHouse) {
        this.field = field;
        this.farmhouse = farmHouse;
    }

    public Field getField() {
        return field;
    }

    public List<Stable> getStables() {
        return stables;
    }

    public List<ChickenCoop> getChickenCoop() {
        return chickenCoops;
    }

    public FarmHouse getFarmHouse() {
        return farmhouse;
    }

    public List<Vehicle> getFarmVehicles() {
        return farmVehicles;
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void addStable(Stable stable) {
        stables.add(stable);
    }

    public void addChickenCoops (ChickenCoop coop) {
        chickenCoops.add(coop);
    }

    public void addVehicle(Vehicle vehicle) {
        farmVehicles.add(vehicle);
    }

    public void addAircraft(Aircraft aircraft) {
        this.aircraft.add(aircraft);
    }

    public List<Edible> getHarvestedProduce() {
        return harvestedProduce;
    }

    public void addToHarvestedProduce(Edible item) {
        harvestedProduce.add(item);
    }

    public void clearHarvestedProduce() {
        harvestedProduce.clear();
    }

    public String getAllAnimals() {
        int totalCount = 0;
        for (Stable stable : stables) {
            totalCount += stable.getHorses().size();
        }

        for (ChickenCoop coop : chickenCoops) {
            totalCount += coop.getChickens().size();
        }

        return "Total Animals: " + totalCount;
    }

    public String getAllPeople() {
        int totalCount = farmhouse.getPeople().size();
        return "Total People: " + totalCount;
        
    }

    public String getAllCrops() {
        int totalCount = 0;
        for (CropRow row : field.getCropRows()) {
            totalCount += row.getCrops().size();
        }
        return "Total Crops: " + totalCount;
    }
}

