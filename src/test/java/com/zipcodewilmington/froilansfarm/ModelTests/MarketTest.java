// MarketTest.java
package com.zipcodewilmington.froilansfarm.ModelTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import java.util.ArrayList;
import java.util.List;

public class MarketTest {
    
    @Test
    public void testMarketPricing() {
        System.out.println("\n--- Testing Market Class ---");
        
        // Test individual prices
        assertEquals(2, Market.getPrice(new EdibleEgg()), "Egg price should be 2");
        assertEquals(3, Market.getPrice(new EarCorn()), "Corn price should be 3");
        assertEquals(1, Market.getPrice(new Tomato()), "Tomato price should be 1");
        
        System.out.println("Market pricing test complete.");
    }
    
    @Test
    public void testProduceSelling() {
        Market market = new Market();
        List<Edible> produce = new ArrayList<>();
        produce.add(new EdibleEgg());  // 2
        produce.add(new EarCorn());    // 3
        produce.add(new Tomato());     // 1
        
        market.sellProduce(produce);
        
        System.out.println("Produce selling test complete.");
    }
    
    @Test
    public void testAnimalSelling() {
        assertEquals(100, Market.sellAnimal("Horse"), "Horse should sell for 100");
        assertEquals(20, Market.sellAnimal("Chicken"), "Chicken should sell for 20");
        assertEquals(0, Market.sellAnimal("Unknown"), "Unknown animal should return 0");
        
        System.out.println("Animal selling test complete.");
    }
}
