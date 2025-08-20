package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.people.*;
import com.zipcodewilmington.froilansfarm.structures.*;
import com.zipcodewilmington.froilansfarm.interfaces.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Main simulation class to set up the farm and daily routines.
 */
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


    // Shared morning routine
    public void runMorningRoutine() {
        System.out.println("\n--- Morning Routine ---");

        // Ride & feed horses
        for (Stable stable : farm.getStables()) {
            for (Horse horse : stable.getHorses()) {
                System.out.println("Froilan is riding " + horse.getName());
                froilan.ride(horse);

                System.out.println("Froilanda is riding " + horse.getName());
                froilanda.ride(horse);

                System.out.println("Feeding " + horse.getName() + " with 3 ears of corn...");
                for (int i = 0; i < 3; i++) {
                    horse.eat(new EarCorn());
                }
            }
        }
        System.out.println("Horse riding and feeding complete.");

        runBreakfastRoutine();
    }

    // Breakfast routine
    private void runBreakfastRoutine() {
        System.out.println("\n--- Breakfast Routine ---");

        // Froilan's breakfast
        System.out.println("Froilan is eating breakfast:");
        froilan.eat(new EarCorn());
        froilan.eat(new Tomato());
        froilan.eat(new Tomato());
        for (int i = 0; i < 5; i++) {
            froilan.eat(new EdibleEgg());
        }
        System.out.println("Froilan has finished breakfast!");

        // Froilanda's breakfast
        System.out.println("\nFroilanda is eating breakfast:");
        froilanda.eat(new EarCorn());
        froilanda.eat(new EarCorn());
        froilanda.eat(new Tomato());
        for (int i = 0; i < 2; i++) {
            froilanda.eat(new EdibleEgg());
        }
        System.out.println("Froilanda has finished breakfast!");
    }

    // Sunday: Plant crops (Froilan only)
    public void runSunday() {
        runMorningRoutine();
    
        System.out.println("\n--- Sunday: Planting ---");

        Field field = farm.getField();
        System.out.println("Froilan is planting crops...");
        field.getCropRow(0).plant(new CornStalk());
        field.getCropRow(1).plant(new TomatoPlant());
        field.getCropRow(2).plant(new GenericCrop());
        System.out.println("Sunday's planting complete.");
    }

    // Monday: Froilanda fertilizes crops
    public void runMonday() {
        runMorningRoutine();
        
        System.out.println("\n--- Monday: Fertilizing ---");

        System.out.println("Froilanda is flying the crop duster...");
        froilanda.fly(cropDuster);
        for (CropRow row : farm.getField().getCropRows()) {
            froilanda.fertilize(cropDuster, row);
        }
        System.out.println("Monday's fertilizing complete.");
    }

    // Tuesday: Froilan harvests
    public void runTuesday() {
        runMorningRoutine();
    
        System.out.println("\n--- Tuesday: Harvesting ---");

        System.out.println("Froilan is harvesting crops with the tractor...");
        for (CropRow row : farm.getField().getCropRows()) {
            List<Edible> yield = froilan.harvest(tractor, row);
            harvestedProduce.addAll(yield);
        }
        System.out.println("Tuesday's harvesting complete.");
    }

    // Wednesday: Animal care
    public void runWednesday() {
        runMorningRoutine();
    
        System.out.println("\n--- Wednesday: Animal Care ---");

        for (Stable stable : farm.getStables()) {
            stable.cleanStructure();
            for (Horse horse : stable.getHorses()) {
                horse.checkHealth();
            }
        }

        for (ChickenCoop coop : farm.getChickenCoops()) {
            coop.cleanStructure();
            for (Chicken chicken : coop.getChickens()) {
                chicken.checkHealth();
            }
        }
        System.out.println("Wednesday's animal care complete.");
    }

    // Thursday: Maintenance
    public void runThursday() {
        runMorningRoutine();
    
        System.out.println("\n--- Thursday: Maintenance ---");

        Field field = farm.getField();
        tractor.prepareRow(field.getCropRow(3));
        tractor.prepareRow(field.getCropRow(4));
        tractor.performMaintenance();
        cropDuster.performMaintenance();

        System.out.println("Thursday's maintenance complete.");
    }

    // Friday: Market day
    public void runFriday() {
        runMorningRoutine();
    
        System.out.println("\n--- Friday: Market Day ---");

        market.sellProduce(harvestedProduce);
        harvestedProduce.clear();

        System.out.println("Friday's market day complete.");
    }

    // Saturday: Rest & leisure
    public void runSaturday() {
        runMorningRoutine();
    
        System.out.println("\n--- Saturday: Rest & Leisure ---");

        if (!farm.getStables().isEmpty() && !farm.getStables().get(0).getHorses().isEmpty()) {
            Horse favoriteHorse = farm.getStables().get(0).getHorses().get(0);
            froilan.takeLeisureRide(favoriteHorse);
            froilanda.takeLeisureRide(favoriteHorse);
        }

        System.out.println("For dinner, Froilan and Froilanda are eating fresh eggs.");
        for (int i = 0; i < 2; i++) froilan.eat(new EdibleEgg());
        for (int i = 0; i < 2; i++) froilanda.eat(new EdibleEgg());

        System.out.println("Saturday's rest and leisure complete.");
    }
}
