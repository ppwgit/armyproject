package com.solvd.lab.army.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class EquipmentBase {

    @XmlElement(name = "equipmentBaseId")
    private Long equipmentBaseId; //link to Base Table

    @XmlElement(name = "equipmentId")
    private Long equipmentId; //link to Equipment Table

    @XmlElement(name = "base")
    private Base base;

    @XmlElement(name = "equipment")
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

