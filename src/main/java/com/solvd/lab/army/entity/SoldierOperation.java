package com.solvd.lab.army.entity;

public class SoldierOperation {
    private Integer soldierOperationId; //link to Soldier Table
    private Integer operationId; //link to Operation Table
    private Soldier soldier;
    private Operation operation;

    public SoldierOperation() {

    }

    public Integer getSoldierOperationId() {
        return soldierOperationId;
    }

    public void setSoldierOperationId(Integer soldierOperationId) {
        this.soldierOperationId = soldierOperationId;
    }
    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }
}