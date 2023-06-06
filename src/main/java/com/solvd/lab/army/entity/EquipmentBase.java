package com.solvd.lab.army.entity;

public class EquipmentBase {

    private Integer equipmentBaseId; //link to Base Table
    private Integer equipmentId; //link to Equipment Table
    private Base base;
    private Equipment equipment;
    public EquipmentBase() {

    }

    public Integer getEquipmentBaseId() {
        return equipmentBaseId;
    }

    public void setEquipmentBaseId(Integer equipmentBaseId) {
        this.equipmentBaseId = equipmentBaseId;
    }
    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }
}

