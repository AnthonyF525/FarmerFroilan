package com.zipcodewilmington.froilansfarm.InterfaceTests;
import com.zipcodewilmington.froilansfarm.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.interfaces.Rider;
import com.zipcodewilmington.froilansfarm.people.Farmer;
import com.zipcodewilmington.froilansfarm.model.Horse;

public class RiderTest {
    public static void main(String[] args) {

        System.out.println("\n--- Testing Rider Interface ---");
        Rider froilan = new Farmer("Froilan");
        Rideable horse = new Horse("Jasper");
        
        // A Rider must be able to mount, dismount, and take a leisure ride
        froilan.mount(horse);
        froilan.dismount(horse);
        froilan.takeLeisureRide(new Horse("Spirit"));
        System.out.println("Rider interface test complete.");
    }
}