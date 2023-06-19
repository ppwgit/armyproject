package com.solvd.lab.army.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Location {
    private Long id;

    @XmlElement(name = "address")
    private String address;

    @XmlElement(name = "cityId")
    private Long cityId;

    @XmlElementWrapper(name = "bases")
    @XmlElement(name = "base")
    private List<Base> bases;

    @XmlElement(name = "city")
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
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", cityId=" + cityId +
                ", bases=" + bases +
                ", city=" + city +
                '}';
    }
}
