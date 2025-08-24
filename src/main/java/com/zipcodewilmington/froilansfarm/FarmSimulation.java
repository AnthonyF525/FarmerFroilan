package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.people.*;
import com.zipcodewilmington.froilansfarm.structures.*;
import com.zipcodewilmington.froilansfarm.interfaces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private static final String LIGHT_PURPLE = "\u001B[38;5;183m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_LIGHT_PURPLE = "\u001B[38;5;183m";
    final String BRIGHT_GREEN = "\u001B[38;5;46m";
    final String RESET = "\u001B[0m";
    final String DEEP_RED = "\u001B[38;5;124m";
    private static final String ANSI_BROWN = "\u001B[38;5;94m";

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

        // Randomly set some horses and chickens as unhealthy
        for (Stable stable : froilanFarm.getStables()) {
            for (Horse horse : stable.getHorses()) {
                if (Math.random() < 0.3) { // 30% chance to be unhealthy
                    horse.setHealthy(false);
                }
            }
        }
        for (ChickenCoop coop : froilanFarm.getChickenCoop()) {
            for (Chicken chicken : coop.getChickens()) {
                if (Math.random() < 0.2) { // 20% chance to be unhealthy
                    chicken.setHealthy(false);
                }
            }
        }
    }

    public void runMorningRoutine() {
        // Riding each horse
        System.out.println("------------------------");
        System.out.println(" --- Horse Riding ---");
        System.out.println("------------------------");
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Froilan and Froilanda head out to ride the horses!" + ANSI_RESET);
        System.out.println();
        List<Horse> allHorses = new ArrayList<>();
        for (Stable stable : froilanFarm.getStables()) {
            allHorses.addAll(stable.getHorses());
        }

        // Alternate riders, each horse is only ridden once
        for (int i = 0; i < allHorses.size(); i++) {
            Horse horse = allHorses.get(i);
            if (i % 2 == 0) {
                System.out.println(froilan.getName() + " mounts " + ANSI_BROWN + horse.getName() + ANSI_RESET + ".");
                horse.morningRide("Froilan");
                horse.makeNoise();
                System.out.println(froilan.getName() + " dismounts " + ANSI_BROWN + horse.getName() + ANSI_RESET + ".");
            } else {
                System.out.println(froilanda.getName() + " mounts " + ANSI_BROWN + horse.getName() + ANSI_RESET + ".");
                horse.morningRide("Froilanda");
                horse.makeNoise();
                System.out
                        .println(froilanda.getName() + " dismounts " + ANSI_BROWN + horse.getName() + ANSI_RESET + ".");
            }
            System.out.println();
        }

        System.out.println(LIGHT_PURPLE + "Morning rides complete!" + ANSI_RESET);
        System.out.println();
        System.out.println();

        // Feeding each horse
        System.out.println("------------------------");
        System.out.println(" --- Feeding Horses ---");
        System.out.println("------------------------");
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Froilan and Froilanda head out to feed the horses!" + ANSI_RESET);
        System.out.println();
        for (Stable stable : froilanFarm.getStables()) {
            for (Horse horse : stable.getHorses()) {
                System.out.println(
                        ANSI_BLUE + "Froilan" + ANSI_RESET + " and " +
                                ANSI_MAGENTA + "Froilanda" + ANSI_RESET + " are feeding " +
                                ANSI_BROWN + horse.getName() + ANSI_RESET);
                for (int i = 0; i < 3; i++) {
                    horse.eat(new EarCorn());
                }
                System.out.println();
            }
        }
        System.out.println(LIGHT_PURPLE + "Feeding complete!" + ANSI_RESET);
    }

    public void runBreakfastRoutine() {
        System.out.println();
        System.out.println("------------------------");
        System.out.println("---Breakfast Routine---");
        System.out.println("------------------------");
        System.out.println();
        // Froilan's breakfast
        System.out.println(LIGHT_PURPLE + "Time to eat breakfast!" + ANSI_RESET);
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
        System.out.println();
        froilanda.eat(new EarCorn());
        froilanda.eat(new EarCorn());
        froilanda.eat(new Tomato());
        froilanda.eat(new EdibleEgg());
        froilanda.eat(new EdibleEgg());
        System.out.println();

        System.out.println(LIGHT_PURPLE + "Breakfast complete!" + ANSI_RESET);
    }

    public void runSunday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                    SUNDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("------------------------");
        System.out.println("  --- Planting Day ---");
        System.out.println("------------------------");
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Time to head out and plant some crops!" + ANSI_RESET);
        System.out.println();

        List<CropRow> cropRows = froilanFarm.getField().getCropRows();

        // Row 1: Corn Stalks (use CornStalk, not GenericCrop)
        CropRow row1 = cropRows.get(0);
        for (int i = 0; i < 6; i++) {
            froilan.plant(new CornStalk("Corn Stalk"), row1);
        }
        System.out.println(row1.getName() + " is growing 6" + ANSI_YELLOW + " Corn" + ANSI_RESET + ".");
        System.out.println();

        // Row 2: Tomato
        CropRow row2 = cropRows.get(1);
        for (int i = 0; i < 5; i++) {
            froilan.plant(new TomatoPlant("Tomato Plant"), row2);
        }
        System.out.println(row2.getName() + " is growing 5 " + ANSI_RED + "Tomatoes" + ANSI_RESET + ".");
        System.out.println();

        // Row 3: Spinach
        CropRow row3 = cropRows.get(2);
        for (int i = 0; i < 7; i++) {
            froilan.plant(new GenericCrop("Spinach"), row3);
        }
        System.out.println(row3.getName() + " is growing 7 " + ANSI_GREEN + "Bundles of Spinach" + ANSI_RESET + ".");
        System.out.println();

        // Row 4: Corn Stalks (print last)
        CropRow row4 = cropRows.get(3);
        for (int i = 0; i < 4; i++) {
            froilan.plant(new CornStalk("Corn Stalk"), row4);
        }
        System.out.println(row4.getName() + " is growing 4 " + ANSI_YELLOW + "Corn" + ANSI_RESET + ".");
        System.out.println();

        System.out.println(LIGHT_PURPLE + "Sunday's planting complete!" + ANSI_RESET);
    }

    public void runMonday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                    MONDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("------------------------");
        System.out.println(" --- Fertilize Day ---");
        System.out.println("------------------------");
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Time to fertilize the crops!" + ANSI_RESET);
        System.out.println();
        System.out.println(froilanda.getName() + " gets in her crop duster...");

        CropDuster cropDuster = (CropDuster) froilanFarm.getAircraft().get(0);
        ((CropDuster) cropDuster).mount("Froilanda");
        cropDuster.fly("Froilanda");
        cropDuster.makeNoise();
        System.out.println();

        // Only fertilize crop rows that have crops planted
        List<CropRow> cropRows = froilanFarm.getField().getCropRows();
        for (int i = 0; i < cropRows.size(); i++) {
            if (i == 3)
                continue; // Skip CropRow 4
            CropRow row = cropRows.get(i);
            if (!row.getCrops().isEmpty()) {
                cropDuster.fertilize(row);
            }
        }
        System.out.println();
        System.out.println(ANSI_MAGENTA + "Froilanda" + ANSI_RESET + " forgets to fertilize CropRow 4...");
        System.out.println();
        ((CropDuster) cropDuster).dismount("Froilanda");
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Monday's fertilizing complete!" + ANSI_RESET);
        System.out.println();

        System.out.println(LIGHT_PURPLE + "OH look! Some of the chickens are laying eggs..." + ANSI_RESET);
        System.out.println();

        List<Chicken> layingChickens = new ArrayList<>();
        for (ChickenCoop coop : froilanFarm.getChickenCoop()) {
            for (Chicken chicken : coop.getChickens()) {
                if (layingChickens.size() < 8) {
                    layingChickens.add(chicken);
                }
            }
            if (layingChickens.size() >= 8)
                break;
        }

        // Shuffle and pick 2 random chickens to fertilize
        Collections.shuffle(layingChickens);
        layingChickens.get(2).setHasBeenFertilized(true);
        layingChickens.get(5).setHasBeenFertilized(true);

        List<Edible> collectedEggs = new ArrayList<>();
        List<Chicken> incubatorEggs = new ArrayList<>();
        for (int i = 0; i < layingChickens.size(); i++) {
            Chicken chicken = layingChickens.get(i);
            Edible egg = chicken.yieldProduce(); // This method prints the correct message
            if (egg != null) {
                collectedEggs.add(egg); // edible eggs
            } else {
                incubatorEggs.add(chicken);
            }
        }
        System.out.println();

        System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " checks the coops for edible eggs...");
        System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " collects " + collectedEggs.size() + " eggs.");
        froilanFarm.getHarvestedProduce().addAll(collectedEggs);

        System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " puts " + incubatorEggs.size() + " fertilized eggs into the incubator.");
        System.out.println();

        System.out.println(LIGHT_PURPLE + "Monday's tasks are complete !" + ANSI_RESET);
        System.out.println();
    }

    public void runTuesday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                    TUESDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("------------------------");
        System.out.println("  --- Harvest Day ---");
        System.out.println("------------------------");
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Time to head out and harvest some crops!" + ANSI_RESET);
        System.out.println();

        Tractor tractor = (Tractor) froilanFarm.getFarmVehicles().get(0);

        ((Tractor) tractor).mount("Froilan");

        tractor.operateOnFarm();
        tractor.makeNoise();
        System.out.println();

        List<CropRow> cropRows = froilanFarm.getField().getCropRows();
        for (int i = 0; i < 5 && i < cropRows.size(); i++) {
            CropRow row = cropRows.get(i);
            System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " is harvesting " + row.getName() + "...");
            if (row.getCrops().isEmpty()) {
                System.out.println("   " + DEEP_RED + " No crops planted to harvest!" + ANSI_RESET);
            } else {
                int cornHarvested = 0;
                int tomatoHarvested = 0;
                int spinachHarvested = 0;
                for (Crop crop : row.getCrops()) {
                    String cropDisplayName;
                    String yieldDisplayName;
                    switch (crop.getName()) {
                        case "Corn Stalk":
                            cropDisplayName = "Corn Stalk";
                            yieldDisplayName = ANSI_YELLOW + "Corn" + ANSI_RESET;
                            break;
                        case "Tomato Plant":
                            cropDisplayName = "Tomato Plant";
                            yieldDisplayName = ANSI_RED + "Tomato" + ANSI_RESET;
                            break;
                        case "Spinach":
                            cropDisplayName = crop.getClass().getSimpleName().equals("GenericCrop") ? "Spinach Plant"
                                    : "Spinach";
                            yieldDisplayName = ANSI_GREEN + "Spinach" + ANSI_RESET;
                            break;
                        default:
                            cropDisplayName = crop.getName();
                            yieldDisplayName = crop.getName();
                    }
                    Edible harvestedItem = tractor.harvest(crop);
                    if (harvestedItem != null) {
                        froilanFarm.addToHarvestedProduce(harvestedItem);
                        System.out.println("  * Harvesting " + cropDisplayName + "... " + BRIGHT_GREEN + "SUCCESS!"
                                + RESET + " Yielded " + yieldDisplayName + "!");
                        // Count harvested items by type
                        if (crop.getName().equals("Corn Stalk"))
                            cornHarvested++;
                        if (crop.getName().equals("Tomato Plant"))
                            tomatoHarvested++;
                        if (crop.getName().equals("Spinach"))
                            spinachHarvested++;
                    } else {
                        System.out.println("  * Harvesting " + cropDisplayName + "... " + DEEP_RED + "FAILURE!" + RESET
                                + " Corn Stalks were not fertilized.");
                    }
                }
                // Print summary for each crop row
                if (cornHarvested > 0) {
                    System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " has harvested " + cornHarvested + " "
                            + ANSI_YELLOW + "Ears of Corn!" + ANSI_RESET);
                }
                if (tomatoHarvested > 0) {
                    System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " has harvested " + tomatoHarvested + " "
                            + ANSI_RED + "Tomatoes!" + ANSI_RESET);
                }
                if (spinachHarvested > 0) {
                    System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " has harvested " + spinachHarvested + " "
                            + ANSI_GREEN + "Bundles of Spinach!" + ANSI_RESET);
                }
            }
            System.out.println();
        }
        ((Tractor) tractor).dismount("Froilan");
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Tuesday's harvesting complete!" + ANSI_RESET);
    }

    public void runWednesday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                   WEDNESDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("------------------------");
        System.out.println("--- Animal Care Day ---");
        System.out.println("------------------------");
        System.out.println();

        System.out.println(
                LIGHT_PURPLE + "Time to clean the animal's structures and check if they are healthy! " + ANSI_RESET);
        System.out.println("\n" + ANSI_BLUE + "Froilan " + ANSI_RESET + "begins cleaning the stables.");
        System.out.println(
                ANSI_MAGENTA + "Froilanda " + ANSI_RESET + "begins by checking if the horses are in good health.");
        System.out.println();
        System.out.println();

        for (Stable stable : froilanFarm.getStables()) {
            System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " is cleaning " + stable.getName() + "...");
            stable.cleanStructure();
            for (Horse horse : stable.getHorses()) {
                horse.checkHealth();
                if (!horse.isHealthy()) {
                    horse.giveMedicine();
                }
            }
            System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " is finished cleaning " + stable.getName() + "!");
            System.out.println();
        }

        System.out.println();
        System.out.println(
                ANSI_BLUE + "Froilan " + ANSI_RESET + "now goes to clean the chicken coops.");
        System.out.println(ANSI_MAGENTA + "Froilanda " + ANSI_RESET + "now checks on the chickens.");
        System.out.println();
        System.out.println();

        for (ChickenCoop coop : froilanFarm.getChickenCoop()) {
            System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " is cleaning " + coop.getName() + "...");
            coop.cleanStructure();
            for (Chicken chicken : coop.getChickens()) {
                chicken.checkHealth();
                if (!chicken.isHealthy()) {
                    chicken.giveMedicine();
                }
            }
            System.out.println(ANSI_BLUE + "Froilan" + ANSI_RESET + " is finished cleaning " + coop.getName()
                    + "! It's spotless.");
            System.out.println();
        }
        System.out.println(LIGHT_PURPLE + "Wednesday's animal care complete!" + ANSI_RESET);
    }

    public void runThursday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                   THURSDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("------------------------");
        System.out.println("--- Maintenance Day ---");
        System.out.println("------------------------");
        System.out.println();

        System.out
                .println(LIGHT_PURPLE + "Time to prepare the empty crop rows for next season's planting!" + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_BLUE + "Froilan " + ANSI_RESET + "uses his tractor to work the land...");

        Tractor tractor = (Tractor) froilanFarm.getFarmVehicles().get(0);
        CropDuster cropDuster = (CropDuster) froilanFarm.getAircraft().get(0);
        tractor.operateOnFarm();
        tractor.makeNoise();
        System.out.println();

        // Prepare remaining crop rows
        if (froilanFarm.getField().getCropRows().size() > 3) {
            CropRow row4 = froilanFarm.getField().getCropRows().get(3); // index 3 = CropRow 4
            CropRow row5 = froilanFarm.getField().getCropRows().get(4); // index 4 = CropRow 5
            tractor.prepareRow(row4);
            tractor.prepareRow(row5);
            System.out.println();
        }

        System.out.println(ANSI_BLUE + "Froilan " + ANSI_RESET + "finished preparing the crop rows!");
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Performing essential maintenance on farm vehicles..." + ANSI_RESET);
        System.out.println();
        ((Tractor) tractor).mount("Froilan");
        tractor.performMaintenance();
        System.out.println(
                ANSI_BLUE + "Froilan " + ANSI_RESET + "finished maintenance on his tractor! Everything looks good.");
        ((Tractor) tractor).dismount("Froilan");
        System.out.println();

        ((CropDuster) cropDuster).mount("Froilanda");
        cropDuster.performMaintenance();
        System.out.println(ANSI_MAGENTA + "Froilanda " + ANSI_RESET
                + "finished maintenance on her crop duster! Everything looks good.");
        ((CropDuster) cropDuster).dismount("Froilanda");
        System.out.println();

        System.out.println(LIGHT_PURPLE + "Thursday's maintenance complete!" + ANSI_RESET);
    }

    public void runFriday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                    FRIDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("------------------------");
        System.out.println("  --- Market Day ---");
        System.out.println("------------------------");
        System.out.println();

        System.out.println(LIGHT_PURPLE + "Froilan and Froilanda gather all their harvested produce..." + ANSI_RESET);
        System.out.println();
        List<Edible> harvestedProduce = froilanFarm.getHarvestedProduce();
        System.out.println("Total Produce Gathered: " + harvestedProduce.size());
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Time to bring them over to the local market!" + ANSI_RESET);
        System.out.println();

        // Select exactly 20 items for sale
        List<Edible> itemsForSale;
        if (harvestedProduce.size() >= 20) {
            itemsForSale = new ArrayList<>(harvestedProduce.subList(0, 20));
        } else {
            itemsForSale = new ArrayList<>(harvestedProduce);
        }

        Market market = new Market();
        market.sellProduce(itemsForSale);
        System.out.println();

        System.out.println(LIGHT_PURPLE + "Froilan and Froilanda pack up and head back to the farm." + ANSI_RESET);
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Friday's market day complete!" + ANSI_RESET);
    }

    public void runSaturday() {
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                   SATURDAY" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "\n================================================\n" + ANSI_RESET);
        runMorningRoutine();
        System.out.println();
        runBreakfastRoutine();
        System.out.println();
        System.out.println("------------------------");
        System.out.println(" ---  Leisure Day ---");
        System.out.println("------------------------");
        System.out.println();

        Horse froilanHorse = froilanFarm.getStables().get(0).getHorses().get(0);
        Horse froilandaHorse = froilanFarm.getStables().get(0).getHorses().get(1);
        System.out.println(LIGHT_PURPLE + "Time for a relaxing ride with " + froilanHorse.getName() + " and "
                + froilandaHorse.getName() + "..." + ANSI_RESET);
        System.out.println();
        froilan.takeLeisureRide(froilanHorse);
        froilanda.takeLeisureRide(froilandaHorse);
        System.out.println();

        // Feed the chickens
        System.out.println(
                LIGHT_PURPLE + "Froilan and Froilanda feed some of the chickens some fresh corn!" + ANSI_RESET);
        System.out.println();
        int fed = 0;
        for (ChickenCoop chickenCoop : froilanFarm.getChickenCoop()) {
            for (Chicken chicken : chickenCoop.getChickens()) {
                if (fed < 6) {
                    System.out.println("* Feeding " + ANSI_BROWN + chicken.getName() + ANSI_RESET + "...");
                    System.out.println("    " + ANSI_BROWN + chicken.getName() + ANSI_RESET + " is eating "
                            + ANSI_YELLOW + "Corn" + ANSI_RESET + ".");
                    fed++;
                }
            }
            if (fed >= 6)
                break;
        }
        System.out.println();

        System.out.println(LIGHT_PURPLE + "The chickens coo happily after their meal!" + ANSI_RESET);
        System.out.println();
        int clucked = 0;
        for (ChickenCoop chickenCoop : froilanFarm.getChickenCoop()) {
            for (Chicken chicken : chickenCoop.getChickens()) {
                if (clucked < 6) {
                    chicken.makeNoise();
                    clucked++;
                }
            }
            if (clucked >= 6)
                break;
        }
        System.out.println();

        // Picnic activity
        System.out.println(LIGHT_PURPLE + "Froilan and Froilanda enjoy a picnic with fresh vegetables from the farm."
                + ANSI_RESET);
        System.out.println();
        froilan.eat(new Tomato());
        GenericCrop spinachCrop = new GenericCrop("Spinach");
        froilan.eat(spinachCrop.yieldProduce());
        froilanda.eat(new Tomato());
        froilanda.eat(spinachCrop.yieldProduce());

        System.out.println();
        System.out.println(LIGHT_PURPLE + "They relax, chat and enjoy the peaceful farm atmosphere." + ANSI_RESET);
        System.out.println();
        froilan.makeNoise();
        froilanda.makeNoise();
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Saturday's leisure day complete!" + ANSI_RESET);
        System.out.println();
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