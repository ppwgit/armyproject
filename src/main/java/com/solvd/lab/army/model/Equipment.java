package com.solvd.lab.army.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Equipment {
    private Long id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "manufacturer")
    private String manufacturer;

    @XmlElement(name = "yearOfManufacture")
    private String yearOfManufacture;

    @XmlElement(name = "quantity")
    private Long quantity;

    @XmlElement(name = "equipmentTypeId")
    private Long equipmentTypeId;

    @XmlElementWrapper(name = "equipmentBases")
    @XmlElement(name = "equipmentBase")
    private List<EquipmentBase> equipmentBases;

    @XmlElement(name = "equipmentType")
    private EquipmentType equipmentType;

    public Equipment() {

    }

    public Equipment(long id, String name, String manufacturer, String yearOfManufacture, long quantity, long equipmentType) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.quantity = quantity;
       this.equipmentTypeId = equipmentTypeId;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipment_type(Long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", quantity=" + quantity +
                ", equipmentTypeId=" + equipmentTypeId +
                ", equipmentBases=" + equipmentBases +
                ", equipmentType=" + equipmentType +
                '}';
    }
}
