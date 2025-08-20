package com.zipcodewilmington.froilansfarm.model;

class Horse extends Animal implements Rideable {
    public Horse(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("The horse, " + this.name + ", is neighing.");
    }

    @Override
    public void mount() {
        System.out.println("The horse, " + this.name + ", has been mounted.");
    }

    @Override
    public void dismount() {
        System.out.println("The horse, " + this.name + ", has been dismounted.");
    }
}
