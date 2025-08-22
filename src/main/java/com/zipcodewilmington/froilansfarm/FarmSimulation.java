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
    // ANSI color codes for enhanced terminal output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_MAGENTA = "\u001B[35m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_ORANGE = "\u001B[38;5;208m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_YELLOW = "\u001B[33m";

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
        for (int i = 1; i <= 6; i++) {
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
        // coop1.addChicken(new Chicken("chicken1"));

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
        System.out.println(ANSI_CYAN + "--- Horse Riding ---" + ANSI_RESET);
        System.out.println();
        List<Horse> allHorses = new ArrayList<>();
        for (Stable stable : froilanFarm.getStables()) {
            allHorses.addAll(stable.getHorses());
        }

        // Alternate riders, each horse is only ridden once
        for (int i = 0; i < allHorses.size(); i++) {
            Horse horse = allHorses.get(i);
            if (i % 2 == 0) {
                System.out.println(ANSI_BLUE + "Froilan mounts " + horse.getName() + "." + ANSI_RESET);
                froilan.mount(horse);
                horse.makeNoise();
                System.out.println(ANSI_BLUE + "Froilan dismounts " + horse.getName() + "." + ANSI_RESET);
            } else {
                System.out.println(ANSI_MAGENTA + "Froilanda mounts " + horse.getName() + "." + ANSI_RESET);
                froilanda.mount(horse);
                horse.makeNoise();
                System.out.println(ANSI_MAGENTA + "Froilanda dismounts " + horse.getName() + "." + ANSI_RESET);
            }
            System.out.println();
        }

        System.out.println(ANSI_ORANGE + "Morning ride complete!" + ANSI_RESET);
        System.out.println();
        System.out.println();

        // Feeding each horse
        System.out.println(ANSI_CYAN + "--- Feeding Horses ---" + ANSI_RESET);
        System.out.println();
        for (Stable stable : froilanFarm.getStables()) {
            for (Horse horse : stable.getHorses()) {
                System.out.println(ANSI_ORANGE + "Froilan and Froilanda are feeding " + horse.getName() + ANSI_RESET);
                for (int i = 0; i < 3; i++) {
                    horse.eat(new EarCorn());
                }
                System.out.println();
            }
        }
        System.out.println(ANSI_ORANGE + "Feeding complete!" + ANSI_RESET);
    }

    public void runBreakfastRoutine() {
        System.out.println();
        System.out.println(ANSI_CYAN + "--- Breakfast Routine ---" + ANSI_RESET);
        System.out.println();
        // Froilan's breakfast
        System.out.println(ANSI_BLUE + "Froilan's Breakfast:" + ANSI_RESET);
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
        System.out.println(ANSI_MAGENTA + "Froilanda's Breakfast:" + ANSI_RESET);
        System.out.println();
        froilanda.eat(new EarCorn());
        froilanda.eat(new EarCorn());
        froilanda.eat(new Tomato());
        froilanda.eat(new EdibleEgg());
        froilanda.eat(new EdibleEgg());
    }

    public void runSunday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                    SUNDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println(ANSI_CYAN + "\n--- Planting Day ! ---" + ANSI_RESET);
        System.out.println();

        List<CropRow> cropRows = froilanFarm.getField().getCropRows();

        // Row 1: Corn
        CropRow row1 = cropRows.get(0);
        for (int i = 0; i < 3; i++) {
            froilan.plant(new CornStalk("Corn Stalk"), row1);
        }
        System.out.println("Row 1 has " + ANSI_YELLOW + "Corn" + ANSI_RESET + ".");
        System.out.println();

        // Row 2: Tomato
        CropRow row2 = cropRows.get(1);
        for (int i = 0; i < 3; i++) {
            froilan.plant(new TomatoPlant("Tomato Plant"), row2);
        }
        System.out.println("Row 2 has " + ANSI_RED + "Tomato" + ANSI_RESET + ".");
        System.out.println();

        // Row 3: Arbitrary vegetation (GenericCrop)
        CropRow row3 = cropRows.get(2);
        for (int i = 0; i < 3; i++) {
            froilan.plant(new GenericCrop("Vegetation"), row3);
        }
        System.out.println(row3.getName() + " grows " + ANSI_GREEN + "Arbitrary Vegetation" + ANSI_RESET + ".");
        System.out.println();
        
        System.out.println(ANSI_ORANGE + "Sunday's planting complete!" + ANSI_RESET);
    }

    public void runMonday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                    MONDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println(ANSI_CYAN + "\n--- Fertilize Day With CropDuster! ---" + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_MAGENTA + "Froilanda gets in her crop duster..." + ANSI_RESET);
        System.out.println();

        CropDuster cropDuster = (CropDuster) froilanFarm.getAircraft().get(0);
        ((CropDuster) cropDuster).mount("Froilanda");
        System.out.println();
        cropDuster.fly();
        System.out.println();
        cropDuster.makeNoise();
        System.out.println();

        // Only fertilize crop rows that have crops planted
        for (CropRow row : froilanFarm.getField().getCropRows()) {
            if (!row.getCrops().isEmpty()) {
                cropDuster.fertilize(row);
            }
        }
        System.out.println();
        ((CropDuster) cropDuster).dismount("Froilanda");
        System.out.println();
        System.out.println(ANSI_ORANGE + "Monday's fertilizing complete!" + ANSI_RESET);
    }

    public void runTuesday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                    TUESDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println(ANSI_CYAN + "\n--- Harvest Day With Tractor! ---" + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_BLUE + "Froilan is operating his tractor to harvest the crops." + ANSI_RESET);
        System.out.println();

        Tractor tractor = (Tractor) froilanFarm.getFarmVehicles().get(0);

        ((Tractor) tractor).mount("Froilan");
        System.out.println();

        tractor.operateOnFarm();
        System.out.println();
        tractor.makeNoise();
        System.out.println();

        List<CropRow> cropRows = froilanFarm.getField().getCropRows();
        for (int i = 0; i < cropRows.size(); i++) {
            CropRow row = cropRows.get(i);
            System.out.println(ANSI_CYAN + "Harvesting " + row.getName() + "..." + ANSI_RESET);
            if (row.getCrops().isEmpty()) {
            System.out.println("   No crops planted to harvest!");
            } else {
                for (Crop crop : row.getCrops()) {
                    String cropDisplayName;
                    switch (crop.getName()) {
                        case "Corn Stalk":
                            cropDisplayName = ANSI_YELLOW + "Corn" + ANSI_RESET;
                            break;
                        case "Tomato Plant":
                            cropDisplayName = ANSI_RED + "Tomato" + ANSI_RESET;
                            break;
                        case "Vegetation":
                            cropDisplayName = ANSI_GREEN + "Vegetation" + ANSI_RESET;
                            break;
                        default:
                            cropDisplayName = crop.getName();
                    }
                    System.out.print("   Harvesting a " + cropDisplayName + "... ");
                    Edible harvestedItem = tractor.harvest(crop);
                    if (harvestedItem != null) {
                        froilanFarm.addToHarvestedProduce(harvestedItem);
                        System.out.println("     SUCCESS! Yielded " + harvestedItem.getName() + ".");
                    } else {
                        System.out.println("FAILURE. Crop did not yield.");
                    }
                }
            }
            System.out.println();
        }
        ((Tractor) tractor).dismount("Froilan");
        System.out.println();
        System.out.println(ANSI_ORANGE + "Tuesday's harvesting complete!" + ANSI_RESET);
    }

    public void runWednesday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                   WEDNESDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println(ANSI_CYAN + "\n--- Animal Care Day! ---" + ANSI_RESET);
        System.out.println();

        System.out.println("--- Cleaning and Health Check ---");
        System.out.println("\n" + ANSI_BLUE + "Froilan begins by checking on the horses and cleaning their stables..." + ANSI_RESET);
        System.out.println();

        // Health check for horses
        for (Stable stable : froilanFarm.getStables()) {
            stable.cleanStructure();
            for (Horse horse : stable.getHorses()) {
                horse.checkHealth();
            }
            System.out.println();
        }

        System.out.println(ANSI_BLUE + "Now checking the chickens and cleaning their coops..." + ANSI_RESET);
        System.out.println();

        // Health check for chickens
        for (ChickenCoop coop : froilanFarm.getChickenCoop()) {
            coop.cleanStructure();
            for (Chicken chicken : coop.getChickens()) {
                chicken.checkHealth();
            }
            System.out.println();
        }
        System.out.println(ANSI_ORANGE + "Wednesday's animal care complete!" + ANSI_RESET);
    }

    public void runThursday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                   THURSDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println(ANSI_CYAN + "\n--- Maintenance Day! ---" + ANSI_RESET);
        System.out.println();

        System.out.println(ANSI_BLUE + "Time to prepare the empty crop rows for next season's planting!" + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_BLUE + "Froilan uses his tractor to work the land..." + ANSI_RESET);
        System.out.println();

        Tractor tractor = (Tractor) froilanFarm.getFarmVehicles().get(0);
        CropDuster cropDuster = (CropDuster) froilanFarm.getAircraft().get(0);

        // Prepare remaining crop rows
        if(froilanFarm.getField().getCropRows().size() > 3){
            CropRow row4 = froilanFarm.getField().getCropRows().get(3); // index 3 = CropRow 4
            CropRow row5 = froilanFarm.getField().getCropRows().get(4); // index 4 = CropRow 5
            tractor.prepareRow(row4);
            tractor.prepareRow(row5);
            System.out.println();
        }

        System.out.println(ANSI_ORANGE + "Performing essential maintenance on the farm vehicles." + ANSI_RESET);
        System.out.println();
        ((Tractor) tractor).mount("Froilan");
        ((Tractor) tractor).dismount("Froilan");
        System.out.println();

        ((CropDuster) cropDuster).mount("Froilanda");
        ((CropDuster) cropDuster).dismount("Froilanda");
        System.out.println();

        // Perform maintenance
        tractor.performMaintenance();
        System.out.println();
        cropDuster.performMaintenance();
        System.out.println();

        System.out.println(ANSI_ORANGE + "Thursday's maintenance complete!" + ANSI_RESET);
    }

    public void runFriday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                    FRIDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println(ANSI_CYAN + "\n--- Market Day! ---" + ANSI_RESET);
        System.out.println();

        System.out.println(ANSI_ORANGE + "Froilan and Froilanda are loading up the harvested produce." + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_ORANGE + "Taking their goods to the local market!" + ANSI_RESET);
        System.out.println();

        // Create a market and sell produce
        Market market = new Market();
        market.sellProduce(froilanFarm.getHarvestedProduce());
        System.out.println();

        System.out.println(ANSI_ORANGE + "Friday's market day complete!" + ANSI_RESET);
    }

    public void runSaturday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                   SATURDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println(ANSI_CYAN + "\n--- Rest & Recreation Day! ---" + ANSI_RESET);
        System.out.println();

        // Froilan and Froilanda take a leisure ride
        Horse froilanHorse = froilanFarm.getStables().get(0).getHorses().get(0);
        Horse froilandaHorse = froilanFarm.getStables().get(0).getHorses().get(1);

        System.out.println(ANSI_BLUE + "Froilan takes a leisure ride on " + froilanHorse.getName() + "." + ANSI_RESET);
        //froilan.takeLeisureRide(froilanHorse);
        System.out.println();

        System.out.println(ANSI_MAGENTA + "Froilanda takes a leisure ride on " + froilandaHorse.getName() + "." + ANSI_RESET);
        //froilanda.takeLeisureRide(froilandaHorse);
        System.out.println();

        // Declare coop before using it
        ChickenCoop coop = froilanFarm.getChickenCoop().get(0);

        coop.getChickens().get(0).yieldProduce();
        coop.getChickens().get(1).yieldProduce();
        System.out.println();

        // They eat fresh eggs for dinner
        System.out.println(ANSI_ORANGE + "Froilan and Froilanda are eating fresh eggs for dinner." + ANSI_RESET);
        System.out.println(ANSI_ORANGE + "\nThe chickens coo happily as they go about their evening!" + ANSI_RESET);
        for (Chicken chicken : coop.getChickens()) {
            chicken.makeNoise();
        }
        System.out.println();
        System.out.println(ANSI_ORANGE + "Saturday's rest and recreation complete!" + ANSI_RESET);
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