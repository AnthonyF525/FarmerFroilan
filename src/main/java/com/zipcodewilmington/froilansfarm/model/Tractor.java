package com.zipcodewilmington.froilansfarm.model;

import com.zipcodewilmington.froilansfarm.interfaces.Crop;
import com.zipcodewilmington.froilansfarm.structures.CropRow;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import com.zipcodewilmington.froilansfarm.interfaces.FarmVehicle;

public class Tractor extends Vehicle implements FarmVehicle {

    public Tractor(String name) {
        super(name);
    }

    @Override
    public void operateOnFarm() {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        if (name.equalsIgnoreCase("Froilan's Tractor")) {
            System.out.println(ANSI_BLUE + "Froilan's " + ANSI_RESET + "tractor is operating on the farm!");
        } else {
            System.out.println(name + " is operating on the farm!");
        }
    }

    @Override
    public void makeNoise() {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        if (name.contains("Froilan")) {
            System.out.println(ANSI_BLUE + "Froilan's " + ANSI_RESET + "tractor is humming.");
        } else {
            System.out.println("The " + name + " is humming. ");
        }
    }

    public Edible harvest(Crop crop) {
        Edible harvestedItem = crop.yieldProduce();
        return harvestedItem;

    }

    public void prepareRow(CropRow cropRow) {
        System.out.println("The " + cropRow.getName() + " is ready for sowing!");
    }

    public void loadHarvestedProduce() {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_MAGENTA = "\u001B[35m";
        final String ANSI_WHITE = "\u001B[37m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(
            ANSI_BLUE + "Froilan" + ANSI_RESET + " and " +
            ANSI_MAGENTA + "Froilanda" + ANSI_RESET + ANSI_WHITE +
            " are loading up the harvested produce." + ANSI_RESET
        );
    }
}
