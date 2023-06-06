package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Equipment;

import java.util.List;

public abstract class EquipmentDAOAbstract {
    public abstract void insert(Equipment equipment);
    public abstract void update(Equipment equipment);
    public abstract void delete(int equipmentId);
    public abstract List<Equipment> getAllEquipments();
    public abstract Equipment getEquipmentById(int equipmentId);
}
