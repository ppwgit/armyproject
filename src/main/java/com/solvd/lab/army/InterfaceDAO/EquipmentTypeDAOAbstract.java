package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.EquipmentType;

import java.util.List;

public abstract class EquipmentTypeDAOAbstract {
    public abstract void insert(EquipmentType equipmentType);
    public abstract void update(EquipmentType equipmentType);
    public abstract void delete(int equipmentId);
    public abstract List<EquipmentType> getAllEquipments();
    public abstract EquipmentType getEquipmentById(int equipmentTypeId);
}
