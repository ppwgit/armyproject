package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Operation;

import java.util.List;

public interface IOperationDAO {
    public void insert(Operation operation);
    public void update(Operation operation);
    public void delete(int operationId);
    public List<Operation> getAllOperations();
    public Operation getOperationById(int operationId);
}
