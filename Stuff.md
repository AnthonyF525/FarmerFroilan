/**
 * Interfaces to define behaviors for various entities on the farm.
 * This section addresses the "multi-inheritance" concept by having classes
 * implement multiple interfaces.
 */

// An object that can eat an Edible object.
interface Eater {
    void eat(Edible food);
}

// An object that can be eaten.
interface Edible {
    String getName();
    int getCalories();
}

// An object that can make noise.
interface NoiseMaker {
    void makeNoise();
}

// An object that can be ridden.
interface Rideable {
    void mount();
    void dismount();
}

// An object that can yield a produce.
interface Produce {
    Edible yieldProduce();
    boolean isHasBeenFertilized();
    void setHasBeenFertilized(boolean b);
}

// A specific type of produce that is a plant.
interface Crop extends Produce {
    boolean isHasBeenHarvested();
    void setHasBeenHarvested(boolean b);
    void fertilize();
}

// An object that can be ridden with a specific leisure routine.
interface Rider {
    void mount(Rideable rideable);
    void dismount(Rideable rideable);
    void takeLeisureRide(Horse horse);
}

interface Botanist {
    void plant(Crop crop, CropRow cropRow);
}

/**
 * Concrete classes representing the entities on the farm.
 * Classes implement the interfaces to gain their behaviors.
 */

abstract class LivingEntity {
    protected String name;

    public LivingEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    // New method for animal health check
    public void checkHealth() {
        System.out.println(this.name + " is being checked for health.");
    }
}

// Animal implements Eater and NoiseMaker interfaces.
class Animal extends LivingEntity implements Eater, NoiseMaker {
    public Animal(String name) {
        super(name);
    }

    @Override
    public void eat(Edible food) {
        System.out.println(this.name + " is eating a " + food.getName() + ".");
    }

    @Override
    public void makeNoise() {
        System.out.println(this.name + " is making a noise.");
    }
}

class Horse extends Animal implements Rideable {
    public Horse(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("The horse, " + this.name + ", is neighing.");
    }

    @Override
    public void mount() {
        System.out.println("The horse, " + this.name + ", has been mounted.");
    }

    @Override
    public void dismount() {
        System.out.println("The horse, " + this.name + ", has been dismounted.");
    }
}

class Chicken extends Animal implements Produce {
    private boolean hasBeenFertilized = false;

    public Chicken(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("The chicken, " + this.name + ", is clucking.");
    }

    @Override
    public Edible yieldProduce() {
        if (!hasBeenFertilized) {
            System.out.println("The chicken, " + this.name + ", lays an egg.");
            return new EdibleEgg();
        } else {
            System.out.println("The chicken, " + this.name + ", lays an unedible fertilized egg.");
            return null;
        }
    }

    @Override
    public boolean isHasBeenFertilized() {
        return hasBeenFertilized;
    }

    @Override
    public void setHasBeenFertilized(boolean b) {
        this.hasBeenFertilized = b;
    }
}

class Person extends LivingEntity implements NoiseMaker, Eater {
    public Person(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println(this.name + " is speaking.");
    }

    @Override
    public void eat(Edible food) {
        System.out.println(this.name + " is eating " + food.getName() + ".");
    }
}

class Farmer extends Person implements Rider, Botanist {
    public Farmer(String name) {
        super(name);
    }

    @Override
    public void mount(Rideable rideable) {
        rideable.mount();
    }

    @Override
    public void dismount(Rideable rideable) {
        rideable.dismount();
    }
    
    @Override
    public void takeLeisureRide(Horse horse) {
        System.out.println(this.name + " is taking a leisure ride on " + horse.getName() + ".");
        horse.mount();
        horse.dismount();
    }

    @Override
    public void plant(Crop crop, CropRow cropRow) {
        System.out.println(this.name + " is planting a " + crop.getName() + " in " + cropRow.getName() + ".");
        cropRow.addCrop(crop);
    }

    public void harvest(Tractor tractor, Crop crop) {
        tractor.harvest(crop);
    }
}

class Pilot extends Person implements Rider {
    public Pilot(String name) {
        super(name);
    }

    @Override
    public void mount(Rideable rideable) {
        rideable.mount();
    }

    @Override
    public void dismount(Rideable rideable) {
        rideable.dismount();
    }
    
    @Override
    public void takeLeisureRide(Horse horse) {
        System.out.println(this.name + " is taking a leisure ride on " + horse.getName() + ".");
        horse.mount();
        horse.dismount();
    }
}

// Edible items
class EdibleEgg implements Edible {
    @Override
    public String getName() {
        return "Edible Egg";
    }

    @Override
    public int getCalories() {
        return 72;
    }
}

class EarCorn implements Edible {
    @Override
    public String getName() {
        return "Ear Corn";
    }

    @Override
    public int getCalories() {
        return 86;
    }
}

class Tomato implements Edible {
    @Override
    public String getName() {
        return "Tomato";
    }

    @Override
    public int getCalories() {
        return 18;
    }
}

// Crop items
class CornStalk extends LivingEntity implements Crop {
    private boolean hasBeenFertilized = false;
    private boolean hasBeenHarvested = false;

    public CornStalk(String name) {
        super(name);
    }

    @Override
    public Edible yieldProduce() {
        if (hasBeenFertilized && !hasBeenHarvested) {
            this.hasBeenHarvested = true;
            return new EarCorn();
        } else {
            System.out.println("The corn cannot be harvested yet.");
            return null;
        }
    }

    @Override
    public boolean isHasBeenFertilized() { return hasBeenFertilized; }

    @Override
    public void setHasBeenFertilized(boolean b) { this.hasBeenFertilized = b; }

    @Override
    public boolean isHasBeenHarvested() { return hasBeenHarvested; }

    @Override
    public void setHasBeenHarvested(boolean b) { this.hasBeenHarvested = b; }

    @Override
    public void fertilize() {
        this.hasBeenFertilized = true;
    }
}

class TomatoPlant extends LivingEntity implements Crop {
    private boolean hasBeenFertilized = false;
    private boolean hasBeenHarvested = false;

    public TomatoPlant(String name) {
        super(name);
    }

    @Override
    public Edible yieldProduce() {
        if (hasBeenFertilized && !hasBeenHarvested) {
            this.hasBeenHarvested = true;
            return new Tomato();
        } else {
            System.out.println("The tomato plant cannot be harvested yet.");
            return null;
        }
    }

    @Override
    public boolean isHasBeenFertilized() { return hasBeenFertilized; }

    @Override
    public void setHasBeenFertilized(boolean b) { this.hasBeenFertilized = b; }

    @Override
    public boolean isHasBeenHarvested() { return hasBeenHarvested; }

    @Override
    public void setHasBeenHarvested(boolean b) { this.hasBeenHarvested = b; }

    @Override
    public void fertilize() {
        this.hasBeenFertilized = true;
    }
}

class GenericCrop extends LivingEntity implements Crop {
    private boolean hasBeenFertilized = false;
    private boolean hasBeenHarvested = false;

    public GenericCrop(String name) {
        super(name);
    }

    @Override
    public Edible yieldProduce() {
        if (hasBeenFertilized && !hasBeenHarvested) {
            this.hasBeenHarvested = true;
            return new Tomato(); // Yielding a generic edible item
        } else {
            System.out.println("This crop cannot be harvested yet.");
            return null;
        }
    }

    @Override
    public boolean isHasBeenFertilized() { return hasBeenFertilized; }

    @Override
    public void setHasBeenFertilized(boolean b) { this.hasBeenFertilized = b; }

    @Override
    public boolean isHasBeenHarvested() { return hasBeenHarvested; }

    @Override
    public void setHasBeenHarvested(boolean b) { this.hasBeenHarvested = b; }

    @Override
    public void fertilize() {
        this.hasBeenFertilized = true;
    }
}

// Vehicle classes
class Vehicle implements NoiseMaker, Rideable {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    @Override
    public void makeNoise() {
        System.out.println("The vehicle, " + name + ", is making a noise.");
    }

    @Override
    public void mount() {
        System.out.println("Someone is mounting the vehicle, " + name + ".");
    }

    @Override
    public void dismount() {
        System.out.println("Someone is dismounting the vehicle, " + name + ".");
    }
    
    // New method for vehicle maintenance
    public void performMaintenance() {
        System.out.println("The vehicle, " + this.name + ", is undergoing maintenance.");
    }
}

interface FarmVehicle {
    void operateOnFarm();
}

class Tractor extends Vehicle implements FarmVehicle {
    public Tractor(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("The tractor, " + name + ", is chugging along.");
    }

    @Override
    public void operateOnFarm() {
        System.out.println("The tractor is operating on the farm.");
    }

    public void harvest(Crop crop) {
        System.out.println(this.name + " is harvesting the " + crop.getName() + ".");
        crop.yieldProduce();
    }
    
    // New method for preparing a row
    public void prepareRow(CropRow row) {
        System.out.println("The " + this.name + " is preparing " + row.getName() + " for planting.");
    }
}

class Aircraft extends Vehicle {
    public Aircraft(String name) {
        super(name);
    }

    public void fly() {
        System.out.println("The aircraft, " + name + ", is flying.");
    }
}

class CropDuster extends Aircraft implements FarmVehicle {
    public CropDuster(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("The crop duster, " + name + ", is buzzing.");
    }

    @Override
    public void operateOnFarm() {
        System.out.println("The crop duster is operating on the farm.");
    }

    public void fertilize(CropRow cropRow) {
        System.out.println("The " + this.name + " is fertilizing " + cropRow.getName() + ".");
        for (Crop crop : cropRow.getCrops()) {
            crop.fertilize();
        }
    }
}

// Structures on the farm
class CropRow {
    private String name;
    private java.util.List<Crop> crops = new java.util.ArrayList<>();

    public CropRow(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public java.util.List<Crop> getCrops() {
        return crops;
    }

    public void addCrop(Crop crop) {
        crops.add(crop);
    }
}

class Field {
    private java.util.List<CropRow> cropRows = new java.util.ArrayList<>();

    public void addCropRow(CropRow row) {
        cropRows.add(row);
    }

    public java.util.List<CropRow> getCropRows() {
        return cropRows;
    }
}

class Stable {
    private java.util.List<Horse> horses = new java.util.ArrayList<>();
    private String name;
    
    public Stable(String name) {
        this.name = name;
    }
    
    public String getName() { return name; }

    public void addHorse(Horse horse) {
        horses.add(horse);
    }

    public java.util.List<Horse> getHorses() {
        return horses;
    }
    
    public void cleanStructure() {
        System.out.println("The " + this.name + " stable is being cleaned.");
    }
}

class ChickenCoop {
    private java.util.List<Chicken> chickens = new java.util.ArrayList<>();
    private String name;
    
    public ChickenCoop(String name) {
        this.name = name;
    }
    
    public String getName() { return name; }

    public void addChicken(Chicken chicken) {
        chickens.add(chicken);
    }

    public java.util.List<Chicken> getChickens() {
        return chickens;
    }
    
    public void cleanStructure() {
        System.out.println("The " + this.name + " chicken coop is being cleaned.");
    }
}

class FarmHouse {
    private java.util.List<Person> people = new java.util.ArrayList<>();

    public void addPerson(Person person) {
        people.add(person);
    }

    public java.util.List<Person> getPeople() {
        return people;
    }
}

class Farm {
    private Field field;
    private java.util.List<Stable> stables = new java.util.ArrayList<>();
    private java.util.List<ChickenCoop> chickenCoops = new java.util.ArrayList<>();
    private FarmHouse farmHouse;
    private java.util.List<FarmVehicle> farmVehicles = new java.util.ArrayList<>();
    private java.util.List<Aircraft> aircraft = new java.util.ArrayList<>();
    
    // New list to store produce
    private java.util.List<Edible> harvestedProduce = new java.util.ArrayList<>();

    public Farm(Field field, FarmHouse farmHouse) {
        this.field = field;
        this.farmHouse = farmHouse;
    }
    
    public void addHarvestedProduce(Edible item) {
        if (item != null) {
            harvestedProduce.add(item);
        }
    }
    
    public java.util.List<Edible> getHarvestedProduce() { return harvestedProduce; }
    public Field getField() { return field; }
    public java.util.List<Stable> getStables() { return stables; }
    public java.util.List<ChickenCoop> getChickenCoops() { return chickenCoops; }
    public FarmHouse getFarmHouse() { return farmHouse; }
    public java.util.List<FarmVehicle> getFarmVehicles() { return farmVehicles; }
    public java.util.List<Aircraft> getAircraft() { return aircraft; }

    public void addStable(Stable stable) { stables.add(stable); }
    public void addChickenCoop(ChickenCoop coop) { chickenCoops.add(coop); }
    public void addFarmVehicle(FarmVehicle vehicle) { farmVehicles.add(vehicle); }
    public void addAircraft(Aircraft plane) { aircraft.add(plane); }
}

// New class for the market
class Market {
    public void sellProduce(java.util.List<Edible> items) {
        System.out.println("The market is selling the following produce:");
        for(Edible item : items) {
            System.out.println("- " + item.getName());
        }
        System.out.println("Produce sold successfully!");
    }
}


/**
 * Main simulation class to set up the farm and daily routines.
 */
class FarmSimulation {
    private Froilan froilan;
    private Froilanda froilanda;
    private Farm froilanFarm;

    public FarmSimulation() {
        // Create the people
        froilan = new Froilan("Froilan");
        froilanda = new Froilanda("Froilanda");

        // Create the farm structures
        FarmHouse farmHouse = new FarmHouse();
        farmHouse.addPerson(froilan);
        farmHouse.addPerson(froilanda);

        Field field = new Field();
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

        // Assemble the farm
        froilanFarm = new Farm(field, farmHouse);
        froilanFarm.addStable(stable1);
        froilanFarm.addStable(stable2);
        froilanFarm.addStable(stable3);
        froilanFarm.addChickenCoop(coop1);
        froilanFarm.addChickenCoop(coop2);
        froilanFarm.addChickenCoop(coop3);
        froilanFarm.addChickenCoop(coop4);
        froilanFarm.addFarmVehicle(tractor);
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
                    froilanFarm.addHarvestedProduce(harvestedItem);
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
        for (ChickenCoop coop : froilanFarm.getChickenCoops()) {
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
        ChickenCoop coop = froilanFarm.getChickenCoops().get(0);
        System.out.println("\nFroilan and Froilanda are eating fresh eggs for dinner.");
        coop.getChickens().get(0).yieldProduce();
        coop.getChickens().get(1).yieldProduce();
        
        System.out.println("Saturday's rest and recreation complete.");
    }
}

/**
 * Separate Test Classes for each day
 */
class SundayTest {
    public static void main(String[] args) {
        System.out.println("### Running Sunday Simulation ###\n");
        FarmSimulation simulation = new FarmSimulation();
        simulation.runSunday();
    }
}

class MondayTest {
    public static void main(String[] args) {
        System.out.println("### Running Monday Simulation ###\n");
        FarmSimulation simulation = new FarmSimulation();
        simulation.runSunday();
        System.out.println("\n-------------------------------------------------\n");
        simulation.runMonday();
    }
}

class TuesdayTest {
    public static void main(String[] args) {
        System.out.println("### Running Tuesday Simulation ###\n");
        FarmSimulation simulation = new FarmSimulation();
        simulation.runSunday();
        simulation.runMonday();
        System.out.println("\n-------------------------------------------------\n");
        simulation.runTuesday();
    }
}

class WednesdayTest {
    public static void main(String[] args) {
        System.out.println("### Running Wednesday Simulation ###\n");
        FarmSimulation simulation = new FarmSimulation();
        simulation.runSunday();
        simulation.runMonday();
        simulation.runTuesday();
        System.out.println("\n-------------------------------------------------\n");
        simulation.runWednesday();
    }
}

class ThursdayTest {
    public static void main(String[] args) {
        System.out.println("### Running Thursday Simulation ###\n");
        FarmSimulation simulation = new FarmSimulation();
        simulation.runSunday();
        simulation.runMonday();
        simulation.runTuesday();
        System.out.println("\n-------------------------------------------------\n");
        simulation.runThursday();
    }
}

class FridayTest {
    public static void main(String[] args) {
        System.out.println("### Running Friday Simulation ###\n");
        FarmSimulation simulation = new FarmSimulation();
        simulation.runSunday();
        simulation.runMonday();
        simulation.runTuesday();
        System.out.println("\n-------------------------------------------------\n");
        simulation.runFriday();
    }
}

class SaturdayTest {
    public static void main(String[] args) {
        System.out.println("### Running Saturday Simulation ###\n");
        FarmSimulation simulation = new FarmSimulation();
        simulation.runSunday();
        simulation.runMonday();
        simulation.runTuesday();
        System.out.println("\n-------------------------------------------------\n");
        simulation.runSaturday();
    }
}
