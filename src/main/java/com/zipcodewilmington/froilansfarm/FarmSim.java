package com.zipcodewilmington.froilansfarm;

public class FarmSim {

    private final Farm farm;
    private final Farmer froilan;
    private final  Pilot froilanda;

    public FarmSimulation() {
        this.farm = FarmFactory.createFroilanFarm();
        this.froilan = farm.getFarmHouse().getFarmerByName("Froilan");
        this.froilanda = farm.getFarmHouse().getPilotByName("Froilanda");
    }

    public Farm getFarm() {
        return farm;
    }

    // ---------- Shared morning routine ----------
    public void morningRoutine() {

        System.out.println("Starting morning routine...");
        // Ride and feed horses
        for (Stable stable : farm.getStables()) {
            for (Horse horse : stable.getHorses()) {
                froilan.mount(horse);
                froilanda.mount(horse);
                horse.makeNoise();
                // Each horse eats 3 corn
                for (int i = 0; i < 3; i++) {
                    horse.eat(new EarCorn());
                }
                froilan.dismount(horse);
                froilanda.dismount(horse);
            }
        }
        System.out.println("Horses fed and ridden.");

        // Breakfast
        // Froilan eats
        froilan.eat(new EarCorn());
        froilan.eat(new Tomato());
        froilan.eat(new Tomato());
        for (int i = 0; i < 5; i++) {
            froilan.eat(new Egg());
        }

        // Froilanda eats
        froilanda.eat(new EarCorn());
        froilanda.eat(new EarCorn());
        froilanda.eat(new Tomato());
        for (int i = 0; i < 2; i++) {
            froilanda.eat(new Egg());
        }
    }

    // ---------- Daily routines ----------
    public void runSunday() {
        morningRoutine();
        // Plant 3 different crops
        farm.getField().getCropRow(0).addCrop(new CornStalk());
        farm.getField().getCropRow(1).addCrop(new TomatoPlant());
        farm.getField().getCropRow(2).addCrop(new CornStalk());
    }

    public void runMonday() {
        morningRoutine();
        // Froilanda uses crop duster
        CropDuster cropDuster = farm.getCropDuster();
        cropDuster.fly(farm.getField());
        cropDuster.fertilize(farm.getField());
    }

    public void runTuesday() {
        morningRoutine();
        // Froilan uses tractor to harvest
        Tractor tractor = farm.getFarmVehicles().get(0);
        for (CropRow row : farm.getField().getCropRows()) {
            tractor.harvest(row);
        }
    }


}
