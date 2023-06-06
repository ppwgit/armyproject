package com.solvd.lab.army.entity;

import java.util.List;

public class State {

    private Integer id;
    private String name;
    private Integer countryId;
    private Country county;
    private List<City> cities;

    public State() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

}
