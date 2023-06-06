package com.solvd.lab.army.model;

public class SoldierOperation {
    private Long soldierOperationId; //link to Soldier Table
    private Long operationId; //link to Operation Table
    private Soldier soldier;
    private Operation operation;

    public SoldierOperation() {

    }

    public Long getSoldierOperationId() {
        return soldierOperationId;
    }

    public void setSoldierOperationId(Long soldierOperationId) {
        this.soldierOperationId = soldierOperationId;
    }
    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }
}