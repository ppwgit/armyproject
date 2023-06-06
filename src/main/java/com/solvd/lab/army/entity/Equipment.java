package com.solvd.lab.army.entity;

import java.util.List;

public class Equipment {
    private Integer id;
    private String name;
    private String manufacturer;
    private String yearOfManufacture;
    private Integer quantity;
    private Integer equipment_type;
    private List<EquipmentBase> equipmentBases;
    private EquipmentType equipmentType;

    public Equipment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getEquipment_type() {
        return equipment_type;
    }

    public void setEquipment_type(Integer equipment_type) {
        this.equipment_type = equipment_type;
    }

}
