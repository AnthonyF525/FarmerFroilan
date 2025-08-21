// MarketTest.java
package com.zipcodewilmington.froilansfarm.ModelTests;

import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import java.util.ArrayList;
import java.util.List;

public class MarketTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Market Class ---");
        
        // Create produce to sell
        List<Edible> produce = new ArrayList<>();
        produce.add(new EdibleEgg());
        produce.add(new EarCorn());
        produce.add(new Tomato());
        
        // Test selling produce
        int totalValue = Market.sellProduce(produce);
        System.out.println("Total value of produce: $" + totalValue);
        
        // Test individual prices
        System.out.println("Egg price: $" + Market.getPrice(new EdibleEgg()));
        System.out.println("Corn price: $" + Market.getPrice(new EarCorn()));
        System.out.println("Tomato price: $" + Market.getPrice(new Tomato()));
        
        // Test animal selling
        System.out.println("Horse sale price: $" + Market.sellAnimal("Horse"));
        System.out.println("Chicken sale price: $" + Market.sellAnimal("Chicken"));
        
        System.out.println("Market test complete.");
    }
}
