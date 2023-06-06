package com.solvd.lab.army.model;

public class EquipmentBase {

    private Long equipmentBaseId; //link to Base Table
    private Long equipmentId; //link to Equipment Table
    private Base base;
    private Equipment equipment;
    public EquipmentBase() {

    }

    public Long getEquipmentBaseId() {
        return equipmentBaseId;
    }

    public void setEquipmentBaseId(Long equipmentBaseId) {
        this.equipmentBaseId = equipmentBaseId;
    }
    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }
}

