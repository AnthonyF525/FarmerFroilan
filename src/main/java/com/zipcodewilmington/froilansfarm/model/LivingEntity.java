package com.zipcodewilmington.froilansfarm.model;

abstract class LivingEntity {
    protected String name;

    public LivingEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    // New method for animal health check
    public void checkHealth() {
        System.out.println(this.name + " is being checked for health.");
    }
}
