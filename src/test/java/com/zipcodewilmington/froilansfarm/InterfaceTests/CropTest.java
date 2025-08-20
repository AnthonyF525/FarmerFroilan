package com.zipcodewilmington.froilansfarm.InterfaceTests;


import com.zipcodewilmington.froilansfarm.interfaces.Crop;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import com.zipcodewilmington.froilansfarm.model.CornStalk;

public class CropTest {
    public static void main(String[] args) {
        System.out.println("\n--- Testing Crop Interface ---");
        Crop cornStalk = new CornStalk("Corn Stalk");
        
        // A Crop must be able to be fertilized and harvested
        cornStalk.fertilize();
        Edible produce = cornStalk.yieldProduce();
        System.out.println("Harvested: " + (produce != null ? produce.getName() : "null"));
        System.out.println("Is harvested: " + cornStalk.isHasBeenHarvested());
        
        System.out.println("Crop interface test complete.");
    }
}