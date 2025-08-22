package com.zipcodewilmington.froilansfarm.model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public class Market {

    // Price constants
    private static final int EGG_PRICE = 3;
    private static final int CORN_PRICE = 4;
    private static final int TOMATO_PRICE = 2;
    private static final int VEGETATION_PRICE = 1;

    // ANSI color codes for console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    // Static methods for buying/selling
    public void sellProduce(List<Edible> produceList) {
        System.out.println("Selling items...");
        Map<String, Integer> itemCounts = new HashMap<>();
        for (Edible item : produceList) {
            itemCounts.put(item.getName(), itemCounts.getOrDefault(item.getName(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            String itemName = entry.getKey();
            int count = entry.getValue();
            String colorName;
            switch (itemName) {
                case "Corn":
                    colorName = ANSI_YELLOW + "Corn" + ANSI_RESET;
                    break;
                case "Tomato":
                    colorName = ANSI_RED + "Tomato" + ANSI_RESET;
                    break;
                case "Vegetation":
                    colorName = ANSI_GREEN + "Vegetation" + ANSI_RESET;
                    break;
                default:
                    colorName = itemName;
            }
            int price = getPrice(itemName) * count;
            System.out.println("  Sold " + count + " " + colorName + " for $" + price);
        }

        final String BRIGHT_GREEN = "\u001B[38;5;46m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(BRIGHT_GREEN + "Sale Completed!" + ANSI_RESET);
        ;
        int totalSales = calculateTotalSales(produceList);
        System.out.printf("\nTOTAL ITEMS SOLD: %d%n", produceList.size());
        System.out.printf("\nTOTAL SALES: $%d%n", totalSales);
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
            case "Vegetation":
                return VEGETATION_PRICE;
            default:
                return 0;
        }
    }
}
