package com.solvd.lab.army.model;

import java.util.List;

public class Equipment {
    private Long id;
    private String name;
    private String manufacturer;
    private String yearOfManufacture;
    private Long quantity;
    private Long equipmentTypeId;
    private List<EquipmentBase> equipmentBases;
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

}
