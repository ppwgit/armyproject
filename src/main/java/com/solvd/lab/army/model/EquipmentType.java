package com.solvd.lab.army.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class EquipmentType {
    private Long id;

    @XmlElement(name = "name")
    private String name;

    @XmlElementWrapper(name = "equipments")
    @XmlElement(name = "equipment")
    private List<Equipment> equipments;

    public EquipmentType() {

    }
    public EquipmentType(long id, String name) {
        this.id = id;
        this.name = name;
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
    public String toString() {
        return "EquipmentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", equipments=" + equipments +
                '}';
    }
}
