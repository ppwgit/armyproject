package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.City;
import com.solvd.lab.army.entity.SoldierOperation;

import java.util.List;

public abstract class SoldierOperationDAOAbstract {
    public abstract void insert(SoldierOperation soldierOperation);
    public abstract void update(SoldierOperation soldierOperation);
    public abstract void delete(int soldierOperationId);
    public abstract List<SoldierOperation> getAllSoldierOperations();
    public abstract SoldierOperation getSoldierOperationById(int soldierOperationId);
}
