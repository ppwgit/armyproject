package com.solvd.lab.army.modelJson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.lab.army.model.Location;
import com.solvd.lab.army.model.Unit;
import com.solvd.lab.army.modelJson.SoldierJson;

import java.util.List;

public class BaseJson {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("geography")
    private String geography;

    @JsonProperty("locationId")
    private Long locationId;

    @JsonProperty("contactNumber")
    private String contactNumber;

    @JsonProperty("email")
    private String email;

    public BaseJson() {

    }

    public BaseJson(long id, String name, String geography, long locationId, String contactNumber, String email) {
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

