package br.com.logique.java8.util;

import java.util.List;

/**
 *
 * Created by Gustavo on 19/11/2015.
 */
public class Cidade {

    private long id;
    private String state;
    private String name;
    private long population;
    private List<String> streets;

    public Cidade(long id, String state, String name, long population, List<String> streets) {
        this.id = id;
        this.state = state;
        this.name = name;
        this.population = population;
        this.streets = streets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public List<String> getStreets() {
        return streets;
    }

    public void setStreets(List<String> streets) {
        this.streets = streets;
    }

    @Override
    public String toString() {
        return name + "/" + state;
    }

}