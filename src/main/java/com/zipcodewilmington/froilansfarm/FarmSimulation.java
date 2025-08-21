package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.people.*;
import com.zipcodewilmington.froilansfarm.structures.*;
import com.zipcodewilmington.froilansfarm.interfaces.*;


/**
 * Main simulation class to set up the farm and daily routines.
 */
class FarmSimulation {
    private Farmer froilan;
    private Pilot froilanda;
    private Farm froilanFarm;

    public FarmSimulation() {
        // Create the people
        Farmer froilan = new Farmer ("Froilan");
        Pilot froilanda = new Pilot ("Froilanda");

        // Create the farm structures
        FarmHouse farmHouse = new FarmHouse("Froilan Farmhouse");
        farmHouse.addPerson(froilan);
        farmHouse.addPerson(froilanda);

        Field field = new Field("Field 1");
        for (int i = 1; i <= 5; i++) {
            field.addCropRow(new CropRow("CropRow " + i));
        }

        // Create animals and add them to stables/coops
        Stable stable1 = new Stable("Stable 1");
        Stable stable2 = new Stable("Stable 2");
        Stable stable3 = new Stable("Stable 3");
        for (int i = 1; i <= 10; i++) {
            if (i <= 4) stable1.addHorse(new Horse("Horse " + i));
            else if (i <= 7) stable2.addHorse(new Horse("Horse " + i));
            else stable3.addHorse(new Horse("Horse " + i));
        }

        ChickenCoop coop1 = new ChickenCoop("Coop 1");
        ChickenCoop coop2 = new ChickenCoop("Coop 2");
        ChickenCoop coop3 = new ChickenCoop("Coop 3");
        ChickenCoop coop4 = new ChickenCoop("Coop 4");
        for (int i = 1; i <= 15; i++) {
            if (i <= 4) coop1.addChicken(new Chicken("Chicken " + i));
            else if (i <= 8) coop2.addChicken(new Chicken("Chicken " + i));
            else if (i <= 12) coop3.addChicken(new Chicken("Chicken " + i));
            else coop4.addChicken(new Chicken("Chicken " + i));
        }

        // Create vehicles
        Tractor tractor = new Tractor("Froilan's Tractor");
        CropDuster cropDuster = new CropDuster("Froilanda's CropDuster");
        coop1.addChicken(new Chicken("chicken1"));

        // Assemble the farm
        froilanFarm = new Farm(field, farmHouse);
        froilanFarm.addStable(stable1);
        froilanFarm.addStable(stable2);
        froilanFarm.addStable(stable3);
        froilanFarm.addChickenCoops(coop1);
        froilanFarm.addChickenCoops(coop2);
        froilanFarm.addChickenCoops(coop3);
        froilanFarm.addChickenCoops(coop4);
        froilanFarm.addVehicle(tractor);
        froilanFarm.addAircraft(cropDuster);
    }

    public void runMorningRoutine() {
        System.out.println("--- Morning Routine ---");

        // Riding each horse
        for (Stable stable : froilanFarm.getStables()) {
            for (Horse horse : stable.getHorses()) {
                froilan.mount(horse);
                froilanda.mount(horse);
            }
        }
        System.out.println("Morning ride complete.");

        // Feeding each horse
        for (Stable stable : froilanFarm.getStables()) {
            for (Horse horse : stable.getHorses()) {
                System.out.println("Froilan and Froilanda are feeding " + horse.getName());
                for (int i = 0; i < 3; i++) {
                    horse.eat(new EarCorn());
                }
            }
        }
        System.out.println("Feeding complete.");
    }

    public void runBreakfastRoutine() {
        System.out.println("--- Breakfast Routine ---");
        // Froilan's breakfast
        System.out.println("Froilan's Breakfast:");
        froilan.eat(new EarCorn());
        froilan.eat(new Tomato());
        froilan.eat(new Tomato());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());

        // Froilanda's breakfast
        System.out.println("\nFroilanda's Breakfast:");
        froilanda.eat(new EarCorn());
        froilanda.eat(new EarCorn());
        froilanda.eat(new Tomato());
        froilanda.eat(new EdibleEgg());
        froilanda.eat(new EdibleEgg());
    }

    public void runSunday() {
        runMorningRoutine();
        runBreakfastRoutine();
        System.out.println("\n--- Sunday's Specific Tasks ---");

        CropRow row1 = froilanFarm.getField().getCropRows().get(0);
        CropRow row2 = froilanFarm.getField().getCropRows().get(1);
        CropRow row3 = froilanFarm.getField().getCropRows().get(2);

        froilan.plant(new CornStalk("Corn Stalk"), row1);
        froilan.plant(new TomatoPlant("Tomato Plant"), row2);
        froilan.plant(new GenericCrop("Generic Crop"), row3);
        System.out.println("Sunday's planting complete.");
    }

    public void runMonday() {
        runMorningRoutine();
        runBreakfastRoutine();
        System.out.println("\n--- Monday's Specific Tasks ---");
        System.out.println("Froilanda is flying her crop duster...");

        CropDuster cropDuster = (CropDuster) froilanFarm.getAircraft().get(0);
        cropDuster.fly();

        for (CropRow row : froilanFarm.getField().getCropRows()) {
            cropDuster.fertilize(row);
        }
        System.out.println("Monday's fertilizing complete.");
    }

    public void runTuesday() {
        runMorningRoutine();
        runBreakfastRoutine();
        System.out.println("\n--- Tuesday's Specific Tasks ---");
        System.out.println("Froilan is operating his tractor...");

        Tractor tractor = (Tractor) froilanFarm.getFarmVehicles().get(0);
        tractor.operateOnFarm();

        for (CropRow row : froilanFarm.getField().getCropRows()) {
            for (Crop crop : row.getCrops()) {
                Edible harvestedItem = crop.yieldProduce();
                if (harvestedItem != null) {
                    froilanFarm.addToHarvestedProduce(harvestedItem);
                }
            }
        }
        System.out.println("Tuesday's harvesting complete.");
    }
    
    public void runWednesday() {
        runMorningRoutine();
        runBreakfastRoutine();
        System.out.println("\n--- Wednesday's Specific Tasks (Animal Care Day) ---");
        
        // Health check for horses
        for (Stable stable : froilanFarm.getStables()) {
            stable.cleanStructure();
            for (Horse horse : stable.getHorses()) {
                horse.checkHealth();
            }
        }
        
        // Health check for chickens
        for (ChickenCoop coop : froilanFarm.getChickenCoop()) {
            coop.cleanStructure();
            for (Chicken chicken : coop.getChickens()) {
                chicken.checkHealth();
            }
        }
        System.out.println("Wednesday's animal care complete.");
    }
    
    public void runThursday() {
        runMorningRoutine();
        runBreakfastRoutine();
        System.out.println("\n--- Thursday's Specific Tasks (Maintenance Day) ---");
        
        Tractor tractor = (Tractor) froilanFarm.getFarmVehicles().get(0);
        CropDuster cropDuster = (CropDuster) froilanFarm.getAircraft().get(0);
        
        // Prepare remaining crop rows
        CropRow row4 = froilanFarm.getField().getCropRows().get(3);
        CropRow row5 = froilanFarm.getField().getCropRows().get(4);
        tractor.prepareRow(row4);
        tractor.prepareRow(row5);
        
        // Perform maintenance
        tractor.performMaintenance();
        cropDuster.performMaintenance();
        
        System.out.println("Thursday's maintenance complete.");
    }
    
    public void runFriday() {
        runMorningRoutine();
        runBreakfastRoutine();
        System.out.println("\n--- Friday's Specific Tasks (Market Day) ---");
        
        // Create a market and sell produce
        Market market = new Market();
        market.sellProduce(froilanFarm.getHarvestedProduce());
        
        System.out.println("Friday's market day complete.");
    }
    
    public void runSaturday() {
        runMorningRoutine();
        runBreakfastRoutine();
        System.out.println("\n--- Saturday's Specific Tasks (Rest and Recreation) ---");
        
        // Froilan and Froilanda take a leisure ride
        Horse favoriteHorse = froilanFarm.getStables().get(0).getHorses().get(0);
        froilan.takeLeisureRide(favoriteHorse);
        froilanda.takeLeisureRide(favoriteHorse);
        
        // They eat fresh eggs for dinner
        ChickenCoop coop = froilanFarm.getChickenCoop().get(0);
        System.out.println("\nFroilan and Froilanda are eating fresh eggs for dinner.");
        coop.getChickens().get(0).yieldProduce();
        coop.getChickens().get(1).yieldProduce();
        
        System.out.println("Saturday's rest and recreation complete.");
    }

    public void runWeek() {
        runSunday();
        runMonday();
        runTuesday();
        runWednesday();
        runThursday();
        runFriday();
        runSaturday();
    }
}