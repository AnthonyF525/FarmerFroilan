package com.zipcodewilmington.froilansfarm.PeopleTests;

//import com.zipcodewilmington.froilansfarm.model.CornStalk;
import com.zipcodewilmington.froilansfarm.people.Farmer;
import com.zipcodewilmington.froilansfarm.model.Horse;
import com.zipcodewilmington.froilansfarm.structures.CropRow;

public class FarmerTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Farmer ---");
        Farmer froilan = new Farmer("Froilan");
        Horse horse = new Horse("Jasper");
        
        // Test Rider interface (mount/dismount)
        System.out.print("Testing mount()... ");
        froilan.mount(horse);
        System.out.print("Testing dismount()... ");
        froilan.dismount(horse);

        // Test takeLeisureRide()
        System.out.print("Testing takeLeisureRide()... ");
        froilan.takeLeisureRide(horse);
        
        // Test Botanist interface (plant)
        System.out.print("Testing plant()... ");
        froilan.plant(new CornStalk("Corn Stalk"), new CropRow("Row 1"));
    }
}