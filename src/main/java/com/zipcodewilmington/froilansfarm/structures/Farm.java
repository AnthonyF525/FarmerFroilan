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

    public String getField() {
        return field;
    }

    public String getStables() {
        return stables;
    }

    public List<ChickenCoop> getChickenCoop() {
        return chickenCoops;
    }

    public String getFarmHouse() {
        return farmhouse;
    }

    public List<FarmVehicle> getFarmVehicles() {
        return farmVehicles;
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void addStable(Stable stable) {
        Stables.add(stable);
    }

    public void addChickenCoop(ChickenCoop coop) {
        chickenCoops.add(coop);
    }

    public void addVehicle(Vehicle vehicle) {
        farmVehicles.add(vehicle);
    }

    public void addAircraft(Aircraft aircraft) {
        aircraft.add(Aircraft);
    }
    
}
