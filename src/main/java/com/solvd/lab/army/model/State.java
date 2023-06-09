package com.solvd.lab.army.model;

import java.util.List;

public class State {

    private Long id;
    private String name;
    private Long countryId;
    private Country country;
    private List<City> cities;

    public State() {

    }
    public State(long id, String name, long countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
    public Country getCounty() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
