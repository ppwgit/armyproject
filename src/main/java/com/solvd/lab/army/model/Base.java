package com.solvd.lab.army.model;

import java.util.List;

public class Base {

    private Long id;
    private String name;
    private String geography;
    private Long locationId;
    private String contactNumber;
    private String email;
    private Location location;
    private List<EquipmentBase> equipmentBases;
    private List<Soldier> soldiers;

    public Base() {

    }

    public Base(long id, String name, String geography, long locationId, String contactNumber, String email) {
        this.id = id;
        this.name = name;
        this.geography = geography;
        this.locationId = locationId;
        this.contactNumber = contactNumber;
        this.email = email;
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

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

