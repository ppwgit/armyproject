package com.solvd.lab.army.model;

import java.util.List;

public class Location {
    private Long id;
    private String address;
    private Long cityId;
    private List<Base> bases;
    private City city;

    public Location() {

    }
    public Location(long id, String address, long cityId) {
        this.id = id;
        this.address = address;
        this.cityId = cityId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
