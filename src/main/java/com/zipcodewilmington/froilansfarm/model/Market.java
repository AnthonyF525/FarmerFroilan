package com.zipcodewilmington.froilansfarm.model;

import java.util.List;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import java.util.Map;
import java.util.stream.Collectors;

public class Market {

    // Price constants
    private static final int EGG_PRICE = 2;
    private static final int CORN_PRICE = 3;
    private static final int TOMATO_PRICE = 1;

    // Static methods for buying/selling
    public void sellProduce(List<Edible> items) {

        // Use a map to count the number of each type of produce
        Map<String, Long> salesReport = items.stream()
                .collect(Collectors.groupingBy(Edible::getName, Collectors.counting()));

        // Simulate the sale of each item
        System.out.println("Selling items...");
        for (Map.Entry<String, Long> entry : salesReport.entrySet()) {
            String itemName = entry.getKey();
            Long quantity = entry.getValue();
            int price = getPrice(itemName); // Use itemName directly
            int totalItemPrice = price * quantity.intValue();
            System.out.printf("  Sold %d %s for $%d%n", quantity, itemName, totalItemPrice);
        }


        System.out.println("\nSale Completed!");
        int totalSales = calculateTotalSales(items);
        System.out.printf("\nTOTAL ITEMS SOLD: %d%n", items.size());
        System.out.printf("\nTOTAL SALES: $%d%n", totalSales);
    }

    private int calculateTotalSales(List<Edible> items) {
        int total = 0;
        for (Edible item : items) {
            total += getPrice(item.getName());
        }
        return total;
    }

    public int getPrice(String itemName) {
        switch (itemName) {
            case "EdibleEgg":
                return EGG_PRICE;
            case "EarCorn":
                return CORN_PRICE;
            case "Tomato":
                return TOMATO_PRICE;
            default:
                return 0;
        }
    }
}
