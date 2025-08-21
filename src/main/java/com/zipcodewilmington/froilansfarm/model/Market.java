package com.zipcodewilmington.froilansfarm.model;

import java.util.List;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class Market {
    
    // Price constants
    private static final int EGG_PRICE = 2;
    private static final int CORN_PRICE = 3;
    private static final int TOMATO_PRICE = 1;
    
    // Static methods for buying/selling
    public void sellProduce(List<Edible> items) {
        System.out.println("The market is selling the following produce:");

        for (Edible item : items) {
            System.out.println(item.getName());
        }
        System.out.println("Produce sold successfully!");
    }

    public static int sellAnimal(String animalType) {
        switch (animalType) {
            case "Horse":
                return 100;
            case "Chicken":
                return 20;
            default:
                return 0;
        }
    }
    
    public static int getPrice(Edible item) {
        String itemName = item.getName();
        switch (itemName) {
            case "Egg":
                return EGG_PRICE;
            case "Corn":
                return CORN_PRICE;
            case "Tomato":
                return TOMATO_PRICE;
            default:
                return 0;
        }
    }
}
