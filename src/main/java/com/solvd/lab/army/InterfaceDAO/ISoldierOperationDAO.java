package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.SoldierOperation;

import java.util.List;

public interface ISoldierOperationDAO {
    public void insert(SoldierOperation soldierOperation);
    public void update(SoldierOperation soldierOperation);
    public void delete(int soldierOperationId);
    public List<SoldierOperation> getAllSoldierOperations();
    public SoldierOperation getSoldierOperationById(int soldierOperationId);
}
