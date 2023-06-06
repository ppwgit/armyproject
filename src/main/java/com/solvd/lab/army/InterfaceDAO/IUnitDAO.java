package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Unit;

import java.util.List;

public interface IUnitDAO {
    public void insert(Unit unit);
    public void update(Unit unit);
    public void delete(int unitId);
    public List<Unit> getAllUnits();
    public Unit getUnitById(int unitId);
}
