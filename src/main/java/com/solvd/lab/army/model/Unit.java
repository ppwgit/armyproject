package com.solvd.lab.army.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Unit {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    @XmlElement(name = "name")
    private String name;

    @JsonProperty("unitType")
    @XmlElement(name = "unitType")
    private String unitType;

    @JsonProperty("soldierId")
    @XmlElement(name = "soldierId")
    private Long soldierId;

    @XmlElement(name = "soldier")
    private Soldier soldier;

    @JsonProperty("units")
    private List<Unit> units;

    public Unit() {

    }

    public Unit(long id, String name, String unitType, long soldierId) {
        this.id = id;
        this.name = name;
        this.unitType = unitType;
        this.soldierId = soldierId;
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

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Long getSoldierId() {
        return soldierId;
    }

    public void setSoldierId(Long soldierId) {
        this.soldierId = soldierId;
    }

    public List<Unit> getUnit() {
        return units;
    }

    public void setUnit(List<Unit> units) {
        this.units = units;
    }
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitType='" + unitType + '\'' +
                ", soldierId=" + soldierId +
                ", soldier=" + soldier +
                ", units=" + units + '\'' +
                '}';
    }
}
