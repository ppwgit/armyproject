package com.solvd.lab.army.entity;

import java.util.Date;
import java.util.List;

public class Operation {

    private Integer id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Integer operationTypeId;
    private OperationType operationType;
    private List<SoldierOperation> soldierOperations;

    public Operation() {

    }

    public Operation(Integer id,String name,Date startDate, Date endDate,Integer operationTypeId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.operationTypeId = operationTypeId;
    }

    public Operation(String name,Date startDate, Date endDate,Integer operationTypeId) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.operationTypeId = operationTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(Integer operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

}
