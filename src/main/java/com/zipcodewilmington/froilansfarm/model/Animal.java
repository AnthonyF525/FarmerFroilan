package com.zipcodewilmington.froilansfarm.model;

// Animal implements Eater and NoiseMaker interfaces.
class Animal extends LivingEntity implements Eater, NoiseMaker {
    public Animal(String name) {
        super(name);
    }

    @Override
    public void eat(Edible food) {
        System.out.println(this.name + " is eating a " + food.getName() + ".");
    }

    @Override
    public void makeNoise() {
        System.out.println(this.name + " is making a noise.");
    }
}
