package com.zipcodewilmington.froilansfarm.PeopleTests;

import com.zipcodewilmington.froilansfarm.model.Horse;
import com.zipcodewilmington.froilansfarm.people.Pilot;

public class PilotTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Pilot ---");
        Pilot froilanda = new Pilot("Froilanda");
        Horse horse = new Horse("Jasper");
        
        // Test Rider interface (mount/dismount)
        System.out.print("Testing mount()... ");
        froilanda.mount(horse);
        System.out.print("Testing dismount()... ");
        froilanda.dismount(horse);

        // Test takeLeisureRide()
        System.out.print("Testing takeLeisureRide()... ");
        froilanda.takeLeisureRide(horse);
    }
}