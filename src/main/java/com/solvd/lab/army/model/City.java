package com.solvd.lab.army.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    private Long id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "stateId")
    private Long stateId;

    @XmlElement(name = "zipCode")
    private String zipCode;

    @XmlElementWrapper(name = "locations")
    @XmlElement(name = "location")
    private List<Location> locations;

    @XmlElement(name = "state")
    private State state;

    public City() {

    }

    public City(long id, String name, String zipCode, long stateId) {
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
        this.stateId = stateId;
    }

    public City(String name, String zipCode, long stateId) {
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

    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stateId=" + stateId +
                ", zipCode='" + zipCode + '\'' +
                ", locations=" + locations +
                ", state=" + state +
                '}';
    }
}

