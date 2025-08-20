package com.zipcodewilmington.froilansfarm.InterfaceTests;

import com.zipcodewilmington.froilansfarm.interfaces.Botanist;
import com.zipcodewilmington.froilansfarm.model.CornStalk;
import com.zipcodewilmington.froilansfarm.interfaces.Crop;
import com.zipcodewilmington.froilansfarm.structures.CropRow;
import com.zipcodewilmington.froilansfarm.people.Farmer;

public class BotanistTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Botanist Interface ---");
        Botanist froilan = new Farmer("Froilan");
        Crop corn = new CornStalk("Corn");
        CropRow row = new CropRow("Test Row");
        
        // A Botanist must be able to plant a crop
        froilan.plant(corn, row);
        System.out.println("Botanist interface test complete.");
    }
}