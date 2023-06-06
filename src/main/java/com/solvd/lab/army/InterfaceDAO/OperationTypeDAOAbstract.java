package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Operation;
import com.solvd.lab.army.entity.OperationType;

import java.util.List;

public abstract class OperationTypeDAOAbstract {
    public abstract void insert(OperationType operationType);
    public abstract void update(OperationType operationType);
    public abstract void delete(int operationTypeId);
    public abstract List<OperationType> getAllOperationTypes();
    public abstract OperationType getOperationTypeById(int operationTypeId);
}

