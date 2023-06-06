package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Base;
import com.solvd.lab.army.entity.Unit;

import java.util.List;

public abstract class UnitDAOAbstract {
    public abstract void insert(Unit unit);
    public abstract void update(Unit unit);
    public abstract void delete(int unitId);
    public abstract List<Unit> getAllUnits();
    public abstract Unit getUnitById(int unitId);
}
