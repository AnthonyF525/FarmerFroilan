package com.zipcodewilmington.froilansfarm.structures;

import com.zipcodewilmington.froilansfarm.model.Person;
import java.util.List;
import java.util.ArrayList;

public class FarmHouse {
    private String name;
    private List<Person> people = new ArrayList<>();
    
    public FarmHouse (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public void cleanStructure() {
        System.out.println("FarmHouse is being cleaned.");
    }
}
