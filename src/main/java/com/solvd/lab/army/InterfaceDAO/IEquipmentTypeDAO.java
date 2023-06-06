package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.EquipmentType;

import java.util.List;

public interface IEquipmentTypeDAO {
    public void insert(EquipmentType equipmentType);
    public void update(EquipmentType equipmentType);
    public void delete(int equipmentTypeId);
    public List<EquipmentType> getAllEquipments();
    public EquipmentType getEquipmentById(int equipmentTypeId);
}
