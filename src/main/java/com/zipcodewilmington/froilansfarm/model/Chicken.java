package com.zipcodewilmington.froilansfarm.model;

class Chicken extends Animal implements Produce {
    private boolean hasBeenFertilized = false;

    public Chicken(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("The chicken, " + this.name + ", is clucking.");
    }

    @Override
    public Edible yieldProduce() {
        if (!hasBeenFertilized) {
            System.out.println("The chicken, " + this.name + ", lays an egg.");
            return new EdibleEgg();
        } else {
            System.out.println("The chicken, " + this.name + ", lays an unedible fertilized egg.");
            return null;
        }
    }
