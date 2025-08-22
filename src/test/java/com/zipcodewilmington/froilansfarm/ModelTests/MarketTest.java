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
        assertEquals(3, Market.getPrice(new EdibleEgg().getName()), "Egg price should be 2");
        assertEquals(4, Market.getPrice(new EarCorn().getName()), "Corn price should be 3");
        assertEquals(2, Market.getPrice(new Tomato().getName()), "Tomato price should be 1");

        System.out.println("Market pricing test complete.");
    }

    @Test
    public void testProduceSelling() {
        Market market = new Market();
        List<Edible> produce = new ArrayList<>();
        produce.add(new EdibleEgg()); // 2
        produce.add(new EarCorn()); // 3
        produce.add(new Tomato()); // 1

        market.sellProduce(produce);

        System.out.println("Produce selling test complete.");
    }


    @Test
    public void testProduceSellingReturnsTotal() {
        List<Edible> produce = new ArrayList<>();
        produce.add(new EdibleEgg());
        produce.add(new EarCorn());
        produce.add(new Tomato());
        int total = Market.calculateTotalSales(produce); // If this is public
        assertEquals(9, total, "Total sales should be 9 (3+4+2)");
    }

}
