package com.zipcodewilmington.froilansfarm.people;

class Pilot extends Person implements Rider {
    public Pilot(String name) {
        super(name);
    }

    @Override
    public void mount(Rideable rideable) {
        rideable.mount();
    }

    @Override
    public void dismount(Rideable rideable) {
        rideable.dismount();
    }
    
    @Override
    public void takeLeisureRide(Horse horse) {
        System.out.println(this.name + " is taking a leisure ride on " + horse.getName() + ".");
        horse.mount();
        horse.dismount();
    }
}
