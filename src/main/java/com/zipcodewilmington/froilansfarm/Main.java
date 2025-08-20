package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.structures.*;
import com.zipcodewilmington.froilansfarm.interfaces.*;
import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.people.*;


public class Main {
    public static void main(String[] args) {
        Field field = new Field("Field");
        FarmHouse farmHouse = new FarmHouse("FarmHouse");
        Farm farm = new Farm(field, farmHouse);

        Farmer froilan = new Farmer("Froilan");
        Pilot froilanda = new Pilot("Froilanda");
        Tractor tractor = new Tractor("Tractor");
        CropDuster cropDuster = new CropDuster("CropDuster");
        Market market = new Market();

        FarmSimulation simulation = new FarmSimulation(farm, froilan, froilanda, tractor, cropDuster, market);
        simulation.runWeek();
    }
}
