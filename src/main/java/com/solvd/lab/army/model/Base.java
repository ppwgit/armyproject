package com.solvd.lab.army.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Base {

    private Long id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "geography")
    private String geography;

    @XmlElement(name = "locationId")
    private Long locationId;

    @XmlElement(name = "contactNumber")
    private String contactNumber;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "location")
    private Location location;

   /* @XmlElementWrapper(name = "skills")
    @XmlElement(name = "skill")
    private List<EquipmentBase> equipmentBases;*/

    @XmlElementWrapper(name = "soldiers")
    @XmlElement(name = "soldier")
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

