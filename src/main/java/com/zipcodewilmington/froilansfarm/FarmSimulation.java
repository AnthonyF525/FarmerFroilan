package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.people.*;
import com.zipcodewilmington.froilansfarm.structures.*;
import com.zipcodewilmington.froilansfarm.interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class FarmSimulation {
    private final Farm farm;
    private final Farmer froilan;      // Farmer
    private final Pilot froilanda;     // Pilot
    private final Tractor tractor;
    private final CropDuster cropDuster;
    private final Market market;
    private final List<Edible> harvestedProduce = new ArrayList<>();

    public FarmSimulation(Farm farm, Farmer froilan, Pilot froilanda,
                          Tractor tractor, CropDuster cropDuster, Market market) {
        this.farm = farm;
        this.froilan = froilan;
        this.froilanda = froilanda;
        this.tractor = tractor;
        this.cropDuster = cropDuster;
        this.market = market;
    }

    // Shared morning routine (runs every day)
    public void runMorningRoutine() {
        // Ride & feed horses
        for (Stable stable : farm.getStables()) {
            for (Horse horse : stable.getHorses()) {
                froilan.ride(horse);
                froilanda.ride(horse);

                for (int i = 0; i < 3; i++) {
                    horse.eat(new EarCorn());
                }
            }
        }

        // Froilan's breakfast
        froilan.eat(new EarCorn());
        froilan.eat(new Tomato());
        froilan.eat(new Tomato());
        for (int i = 0; i < 5; i++) froilan.eat(new EdibleEgg());

        // Froilanda's breakfast
        froilanda.eat(new EarCorn());
        froilanda.eat(new EarCorn());
        froilanda.eat(new Tomato());
        for (int i = 0; i < 2; i++) froilanda.eat(new EdibleEgg());
    }

    //  Sunday: Plant crops 
    public void runSunday() {
        runMorningRoutine();
        Field field = farm.getField();
        field.getCropRow(0).plant(new CornStalk());
        field.getCropRow(1).plant(new TomatoPlant());
        field.getCropRow(2).plant(new GenericCrop());
    }

    // Monday: Froilanda fertilizes crops
    public void runMonday() {
        runMorningRoutine();
        for (CropRow row : farm.getField().getCropRows()) {
            froilanda.fly(cropDuster);
            froilanda.fertilize(cropDuster, row);
        }
    }

    //  Tuesday: Froilan harvests
    public void runTuesday() {
        runMorningRoutine();
        for (CropRow row : farm.getField().getCropRows()) {
            List<Edible> yield = froilan.harvest(tractor, row);
            harvestedProduce.addAll(yield);
        }
    }

    //  Wednesday: Animal care
    public void runWednesday() {
        runMorningRoutine();
        for (Stable stable : farm.getStables()) {
            for (Horse horse : stable.getHorses()) {
                horse.checkHealth();
            }
            stable.cleanStructure();
        }
        for (ChickenCoop coop : farm.getChickenCoops()) {
            for (Chicken chicken : coop.getChickens()) {
                chicken.checkHealth();
            }
            coop.cleanStructure();
        }
    }

    //  Thursday: Maintenance
    public void runThursday() {
        runMorningRoutine();
        Field field = farm.getField();
        tractor.prepareRow(field.getCropRow(3));
        tractor.prepareRow(field.getCropRow(4));
        tractor.performMaintenance();
        cropDuster.performMaintenance();
    }

    //  Friday: Market day
    public void runFriday() {
        runMorningRoutine();
        market.sellProduce(harvestedProduce);
        harvestedProduce.clear();
    }

    //  Saturday: Rest & leisure
    public void runSaturday() {
        runMorningRoutine();
        if (!farm.getStables().isEmpty() && !farm.getStables().get(0).getHorses().isEmpty()) {
            Horse favoriteHorse = farm.getStables().get(0).getHorses().get(0);
            froilan.takeLeisureRide(favoriteHorse);
            froilanda.takeLeisureRide(favoriteHorse);
        }
        for (int i = 0; i < 2; i++) froilan.eat(new EdibleEgg());
        for (int i = 0; i < 2; i++) froilanda.eat(new EdibleEgg());
    }
}
