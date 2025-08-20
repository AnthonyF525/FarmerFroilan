package com.zipcodewilmington.froilansfarm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SundayTest {

    @Test
    void testSundayRoutine() {
        FarmSim sim = new FarmSim();
        sim.runSunday();

        // Verify crops planted
        assertFalse(sim.getFarm().getField().getCropRow(0).getCrops().isEmpty());
        assertFalse(sim.getFarm().getField().getCropRow(1).getCrops().isEmpty());
        assertFalse(sim.getFarm().getField().getCropRow(2).getCrops().isEmpty());
    }
}
