package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.people.*;
import com.zipcodewilmington.froilansfarm.structures.*;
import com.zipcodewilmington.froilansfarm.interfaces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main simulation class to set up the farm and daily routines.
 */
class FarmSimulation {
    private Farmer froilan;
    private Pilot froilanda;
    private Farm froilanFarm;

    public FarmSimulation() {
        // Create the people
        froilan = new Farmer("Froilan");
        froilanda = new Pilot("Froilanda");

        // Create the farm structures
        FarmHouse farmHouse = new FarmHouse("Froilan Farmhouse");
        farmHouse.addPerson(froilan);
        farmHouse.addPerson(froilanda);

        Field field = new Field("Field 1");
        for (int i = 1; i <= 5; i++) {
            field.addCropRow(new CropRow("CropRow " + i));
        }

        // Create list of Horse names
        List<String> horseNames = Arrays.asList("Jasper", "Spirit", "Daisy", "Lucky", "Pegasus", "Shadow", "Thunder",
                "Blaze", "Comet", "Star");

        // Create animals and add them to stables/coops
        Stable stable1 = new Stable("Stable 1");
        Stable stable2 = new Stable("Stable 2");
        Stable stable3 = new Stable("Stable 3");
        for (int i = 0; i < horseNames.size(); i++) {
            if (i <= 3)
                stable1.addHorse(new Horse(horseNames.get(i)));
            else if (i <= 6)
                stable2.addHorse(new Horse(horseNames.get(i)));
            else
                stable3.addHorse(new Horse(horseNames.get(i)));
        }

        // create lit of chicken names
        List<String> chickenNames = Arrays.asList(
                "Henny", "Penny", "Ferdinand", "Chuckles",
                "Peck", "Clucksworth", "Nugget", "Feathers",
                "Squawk", "Rosie", "Peeper", "Scruffy",
                "Squabbles", "Pip", "Chirp");

        ChickenCoop coop1 = new ChickenCoop("Coop 1");
        ChickenCoop coop2 = new ChickenCoop("Coop 2");
        ChickenCoop coop3 = new ChickenCoop("Coop 3");
        ChickenCoop coop4 = new ChickenCoop("Coop 4");
        for (int i = 0; i < chickenNames.size(); i++) {
            if (i <= 3)
                coop1.addChicken(new Chicken(chickenNames.get(i)));
            else if (i <= 7)
                coop2.addChicken(new Chicken(chickenNames.get(i)));
            else if (i <= 11)
                coop3.addChicken(new Chicken(chickenNames.get(i)));
            else
                coop4.addChicken(new Chicken(chickenNames.get(i)));
        }

        // Create vehicles
        Tractor tractor = new Tractor("Froilan's Tractor");
        CropDuster cropDuster = new CropDuster("Froilanda's CropDuster");
        //coop1.addChicken(new Chicken("chicken1"));

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
        // Riding each horse
        System.out.println("--- Horse Riding ---");
        System.out.println();
        List<Horse> allHorses = new ArrayList<>();
        for (Stable stable : froilanFarm.getStables()) {
            allHorses.addAll(stable.getHorses());
        }

        // Alternate riders, each horse is only ridden once
        for (int i = 0; i < allHorses.size(); i++) {
            Horse horse = allHorses.get(i);
            if (i % 2 == 0) {
                System.out.println("Froilan mounts " + horse.getName() + ".");
                froilan.mount(horse);
                horse.makeNoise();
                System.out.println("Froilan dismounts " + horse.getName() + ".");
            } else {
                System.out.println("Froilanda mounts " + horse.getName() + ".");
                froilanda.mount(horse);
                horse.makeNoise();
                System.out.println("Froilanda dismounts " + horse.getName() + ".");
            }
            System.out.println();
        }

        System.out.println("Morning ride complete!");
        System.out.println();
        System.out.println();

        // Feeding each horse
        System.out.println("--- Feeding Horses ---");
        System.out.println();
        for (Stable stable : froilanFarm.getStables()) {
            for (Horse horse : stable.getHorses()) {
                System.out.println("Froilan and Froilanda are feeding " + horse.getName());
                for (int i = 0; i < 3; i++) {
                    horse.eat(new EarCorn());
                }
                System.out.println();
            }
        }
        System.out.println("Feeding complete!");
    }

    public void runBreakfastRoutine() {
        System.out.println();
        System.out.println("--- Breakfast Routine ---");
        System.out.println();
        // Froilan's breakfast
        System.out.println("Froilan's Breakfast:");
        System.out.println();
        froilan.eat(new EarCorn());
        froilan.eat(new Tomato());
        froilan.eat(new Tomato());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());
        System.out.println();

        // Froilanda's breakfast
        System.out.println("Froilanda's Breakfast:");
        System.out.println();
        froilanda.eat(new EarCorn());
        froilanda.eat(new EarCorn());
        froilanda.eat(new Tomato());
        froilanda.eat(new EdibleEgg());
        froilanda.eat(new EdibleEgg());
    }

    public void runSunday() {
        System.out.println("\n================================================\n");
        System.out.println("                    SUNDAY");
        System.out.println("\n================================================\n");
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("\n--- Planting Day ! ---");
        System.out.println();

        CropRow row1 = froilanFarm.getField().getCropRows().get(0);
        CropRow row2 = froilanFarm.getField().getCropRows().get(1);
        CropRow row3 = froilanFarm.getField().getCropRows().get(2);

        froilan.plant(new CornStalk("Corn Stalk"), row1);
        System.out.println();
        froilan.plant(new TomatoPlant("Tomato Plant"), row2);
        System.out.println();
        froilan.plant(new GenericCrop("Generic Crop"), row3);
        System.out.println();
        System.out.println();
        System.out.println("Sunday's planting complete!");
    }

    public void runMonday() {
        System.out.println("\n================================================\n");
        System.out.println("                    MONDAY");
        System.out.println("\n================================================\n");
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("\n--- Fertilize Day With CropDuster! ---");
        System.out.println();
        System.out.println("Froilanda gets in her crop duster...");
        System.out.println();

        CropDuster cropDuster = (CropDuster) froilanFarm.getAircraft().get(0);
        cropDuster.fly();
        System.out.println();
        cropDuster.makeNoise();
        System.out.println();

        for (CropRow row : froilanFarm.getField().getCropRows()) {
            cropDuster.fertilize(row);
        }
        System.out.println();
        System.out.println("Monday's fertilizing complete!");
    }

    public void runTuesday() {
        System.out.println("\n================================================\n");
        System.out.println("                    TUESDAY");
        System.out.println("\n================================================\n");
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("\n--- Harvest Day With Tractor! ---");
        System.out.println();
        System.out.println("Froilan is operating his tractor to harvest the crops.");
        System.out.println();

        Tractor tractor = (Tractor) froilanFarm.getFarmVehicles().get(0);
        tractor.operateOnFarm();
        System.out.println();
        tractor.makeNoise();
        System.out.println();
        System.out.println();

        List<CropRow> cropRows = froilanFarm.getField().getCropRows();
        for (int i = 0; i < 3 && i < cropRows.size(); i++) {
            CropRow row = cropRows.get(i);
            System.out.println("Harvesting " + row.getName() + "...");
            for (Crop crop : row.getCrops()) {
                System.out.print("   Harvesting a " + crop.getName() + "... ");
                Edible harvestedItem = tractor.harvest(crop);
                if (harvestedItem != null) {
                    froilanFarm.addToHarvestedProduce(harvestedItem);
                    System.out.println("   SUCCESS! Yielded " + harvestedItem.getName() + ".");
                } else {
                    System.out.println("   FAILURE. Crop did not yield.");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Tuesday's harvesting complete!");
    }

    public void runWednesday() {
        System.out.println("\n================================================\n");
        System.out.println("                   WEDNESDAY");
        System.out.println("\n================================================\n");
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("\n--- Animal Care Day! ---");
        System.out.println();

        System.out.println("--- Cleaning and Health Check ---");
        System.out.println("\nFroilan begins by checking on the horses and cleaning their stables.");
        System.out.println();

        // Health check for horses
        for (Stable stable : froilanFarm.getStables()) {
            stable.cleanStructure();
            for (Horse horse : stable.getHorses()) {
                horse.checkHealth();
            }
            System.out.println();
        }

        System.out.println("Now checking the chickens and cleaning their coops.");
        System.out.println();

        // Health check for chickens
        for (ChickenCoop coop : froilanFarm.getChickenCoop()) {
            coop.cleanStructure();
            for (Chicken chicken : coop.getChickens()) {
                chicken.checkHealth();
            }
            System.out.println();
        }
        System.out.println("Wednesday's animal care complete!");
    }

    public void runThursday() {
        System.out.println("\n================================================\n");
        System.out.println("                   THURSDAY");
        System.out.println("\n================================================\n");
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("\n--- Maintenance Day! ---");
        System.out.println();

        System.out.println("Time to prepare the empty crop rows for next season's planting!");
        System.out.println();
        System.out.println("Froilan uses his tractor to work the land...");
        System.out.println();

        Tractor tractor = (Tractor) froilanFarm.getFarmVehicles().get(0);
        CropDuster cropDuster = (CropDuster) froilanFarm.getAircraft().get(0);

        // Prepare remaining crop rows
        CropRow row4 = froilanFarm.getField().getCropRows().get(3);
        CropRow row5 = froilanFarm.getField().getCropRows().get(4);
        tractor.prepareRow(row4);
        tractor.prepareRow(row5);
        System.out.println();

        // Perform maintenance
        System.out.println("Now performing essential maintenance on the farm vehicles!");
        System.out.println();
        System.out.println("Froilan mounts the tractor to begin his work...");
        tractor.performMaintenance();
        System.out.println("\nFroilan dismounts the tractor, maintenance finished!");
        System.out.println();

        System.out.println("Froilanda mounts the crop duster to check the controls...");
        cropDuster.performMaintenance();
        System.out.println("\nFroilanda dismounts the crop duster, maintenance finished!");
        System.out.println();

        System.out.println("Thursday's maintenance complete!");
    }

    public void runFriday() {
        System.out.println("\n================================================\n");
        System.out.println("                    FRIDAY");
        System.out.println("\n================================================\n");
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("\n--- Market Day! ---");
        System.out.println();

        System.out.println("Froilan and Froilanda are loading up the harvested produce.");
        System.out.println();
        System.out.println("Taking their goods to the local market!");
        System.out.println();

        // Create a market and sell produce
        Market market = new Market();
        market.sellProduce(froilanFarm.getHarvestedProduce());
        System.out.println();

        System.out.println("Friday's market day complete!");
    }

    public void runSaturday() {
        System.out.println("\n================================================\n");
        System.out.println("                   SATURDAY");
        System.out.println("\n================================================\n");
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("\n--- Rest & Recreation Day! ---");
        System.out.println();

        // Froilan and Froilanda take a leisure ride
        Horse froilanHorse = froilanFarm.getStables().get(0).getHorses().get(0);
        Horse froilandaHorse = froilanFarm.getStables().get(0).getHorses().get(1);

        froilan.takeLeisureRide(froilanHorse);
        froilanda.takeLeisureRide(froilandaHorse);
        System.out.println();

        // They eat fresh eggs for dinner
        ChickenCoop coop = froilanFarm.getChickenCoop().get(0);
        System.out.println("Froilan and Froilanda are eating fresh eggs for dinner.");
        System.out.println("\nThe chickens coo happily as they go about their evening!");
        for (Chicken chicken : coop.getChickens()) {
            chicken.makeNoise();
        }
        System.out.println();
        coop.getChickens().get(0).yieldProduce();
        coop.getChickens().get(1).yieldProduce();
        System.out.println();

        System.out.println("Saturday's rest and recreation complete!");
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