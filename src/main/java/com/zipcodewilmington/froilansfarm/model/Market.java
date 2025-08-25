package com.zipcodewilmington.froilansfarm.model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class Market {

    // Price constants
    private static final int EGG_PRICE = 3;
    private static final int CORN_PRICE = 5;
    private static final int TOMATO_PRICE = 4;
    private static final int SPINACH_PRICE = 2;

    // ANSI color codes for console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_ORANGE = "\u001B[38;5;208m";
    private static final String LIGHT_PURPLE = "\u001B[38;5;183m";
    final String BRIGHT_GREEN = "\u001B[38;5;46m";

    // Static methods for buying/selling
    public void sellProduce(List<Edible> produceList) {
        System.out.println("Items for sale: " + ANSI_YELLOW + "Corn" + ANSI_RESET + ", " + ANSI_RED + "Tomato"
                + ANSI_RESET + ", " + ANSI_ORANGE + "Egg" + ANSI_RESET + ", and " + ANSI_GREEN + "Spinach" + ANSI_RESET);
        System.out.println();
        System.out.println("Prices:");
        System.out.println(" - " + ANSI_YELLOW + "Corn" + ANSI_RESET + ": $" + CORN_PRICE);
        System.out.println(" - " + ANSI_RED + "Tomato" + ANSI_RESET + ": $" + TOMATO_PRICE);
        System.out.println(" - " + ANSI_ORANGE + "Egg" + ANSI_RESET + ": $" + EGG_PRICE);
        System.out.println(" - " + ANSI_GREEN + "Spinach" + ANSI_RESET + ": $" + SPINACH_PRICE);
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Local families, chefs, and bakers all stop by the stand." + ANSI_RESET);
        System.out.println();
        System.out.println(LIGHT_PURPLE + "Froilan and Froilanda sell produce to locals..." + ANSI_RESET);
        System.out.println();
        System.out.println(BRIGHT_GREEN + "Sales Completed!" + ANSI_RESET);
        System.out.println();

        // Count items
        Map<String, Integer> itemCounts = new HashMap<>();
        for (Edible item : produceList) {
            itemCounts.put(item.getName(), itemCounts.getOrDefault(item.getName(), 0) + 1);
        }

        // Print in desired order: Corn, Tomato, Egg, Spinach
        String[] order = {"Corn", "Tomato", "Egg", "Spinach"};
        for (String itemName : order) {
            if (itemCounts.containsKey(itemName)) {
                int count = itemCounts.get(itemName);
                String colorName;
                switch (itemName) {
                    case "Corn":
                        colorName = ANSI_YELLOW + "Corn" + ANSI_RESET;
                        break;
                    case "Tomato":
                        colorName = ANSI_RED + "Tomatoes" + ANSI_RESET;
                        break;
                    case "Egg":
                        colorName = ANSI_ORANGE + "Eggs" + ANSI_RESET;
                        break;
                    case "Spinach":
                        colorName = ANSI_GREEN + "Spinach" + ANSI_RESET;
                        break;
                    default:
                        colorName = itemName;
                }
                int price = getPrice(itemName) * count;
                System.out.println(" * Sold " + count + " " + colorName + " for $" + price);
            }
        }

        System.out.println();
        int totalSales = calculateTotalSales(produceList);
        System.out.printf("Total Produce Sold: %d%n", produceList.size());
        System.out.printf("Total Sales: $%d%n", totalSales);
    }

    public static int calculateTotalSales(List<Edible> items) {
        int total = 0;
        for (Edible item : items) {
            total += getPrice(item.getName());
        }
        return total;
    }

    public static int getPrice(String itemName) {
        switch (itemName) {
            case "Egg":
            case "EdibleEgg":
                return EGG_PRICE;
            case "Corn":
            case "EarCorn":
                return CORN_PRICE;
            case "Tomato":
                return TOMATO_PRICE;
            case "Spinach":
                return SPINACH_PRICE;
            default:
                return 0;
        }
    }
}
