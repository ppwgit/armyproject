package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.City;
import com.solvd.lab.army.entity.Operation;

import java.util.List;

public abstract class OperationDAOAbstract {
    public abstract void insert(Operation operation);
    public abstract void update(Operation operation);
    public abstract void delete(int operationId);
    public abstract List<Operation> getAllOperations();
    public abstract Operation getOperationById(int operationId);
}
