package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.OperationType;

import java.util.List;

public interface IOperationTypeDAO {
    public void insert(OperationType operationType);
    public void update(OperationType operationType);
    public void delete(int operationTypeI);
    public List<OperationType> getAllOperationTypes();
    public OperationType getOperationTypeById(int operationTypeId);
}
