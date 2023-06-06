package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Equipment;

import java.util.List;

public interface IEquipmentDAO {
    public void insert(Equipment equipment);
    public void update(Equipment equipment);
    public void delete(int equipmentId);
    public List<Equipment> getAllEquipments();
    public Equipment getEquipmentById(int equipmentId);
}
