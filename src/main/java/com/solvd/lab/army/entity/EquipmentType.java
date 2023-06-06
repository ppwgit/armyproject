package com.solvd.lab.army.entity;

import java.util.List;

public class EquipmentType {
    private Integer id;
    private String name;
    private List<Equipment> equipments;

    public EquipmentType() {

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
}
