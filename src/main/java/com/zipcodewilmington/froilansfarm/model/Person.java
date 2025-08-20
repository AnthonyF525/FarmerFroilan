package com.zipcodewilmington.froilansfarm.model;

class Person extends LivingEntity implements NoiseMaker, Eater {
    public Person(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println(this.name + " is speaking.");
    }

    @Override
    public void eat(Edible food) {
        System.out.println(this.name + " is eating " + food.getName() + ".");
    }
}
