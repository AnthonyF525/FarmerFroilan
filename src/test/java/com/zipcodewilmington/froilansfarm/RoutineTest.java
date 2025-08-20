package com.zipcodewilmington.froilansfarm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoutineTest {

    void morningRoutine(Farm farm, Farmer froilan, Pilot froilanda) {
        // Ride each horse
        farm.getStables().forEach(stable ->
            stable.getHorses().forEach(horse -> {
                froilan.mount(horse);
                froilan.dismount(horse);
                froilanda.mount(horse);
                froilanda.dismount(horse);
            })
        );

        // Feed each horse 3 corn
        farm.getStables().forEach(stable ->
            stable.getHorses().forEach(horse -> {
                for (int i = 0; i < 3; i++) {
                    horse.eat(new EarCorn());
                }
                assertEquals(3, horse.getMealsEaten().size());
            })
        );

        // Froilan eats
        froilan.eat(new EarCorn());
        froilan.eat(new Tomato());
        froilan.eat(new Tomato());
        for (int i = 0; i < 5; i++) froilan.eat(new Egg());

        // Froilanda eats
        froilanda.eat(new EarCorn());
        froilanda.eat(new EarCorn());
        froilanda.eat(new Tomato());
        for (int i = 0; i < 2; i++) froilanda.eat(new Egg());

        assertTrue(froilan.getMealsEaten().size() >= 8);
        assertTrue(froilanda.getMealsEaten().size() >= 5);
    }

}
