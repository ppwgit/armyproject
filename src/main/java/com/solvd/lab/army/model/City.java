package com.solvd.lab.army.model;

import java.util.List;

public class City {

    private Long id;
    private String name;
    private Long stateId;
    private String zipCode;
    private List<Location> locations;
    private State state;

    public City() {

    }

    public City(long id, String name, String zipCode, long stateId) {
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
        this.stateId = stateId;
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

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}

