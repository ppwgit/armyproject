package com.solvd.lab.army.entity;

import java.util.List;

public class Location {
    private Integer id;
    private String address;
    private Integer cityId;
    private List<Base> bases;
    private City city;

    public Location() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
