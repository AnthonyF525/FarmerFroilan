package com.zipcodewilmington.froilansfarm.interfaces;

// An object that can yield a produce.
interface Produce {
    Edible yieldProduce();
    boolean isHasBeenFertilized();
    void setHasBeenFertilized(boolean b);
}