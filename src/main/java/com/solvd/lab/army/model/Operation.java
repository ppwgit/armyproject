package com.solvd.lab.army.model;

import java.util.Date;
import java.util.List;

public class Operation {

    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String location;
    private Long operationTypeId;
    private OperationType operationType;
    //private List<SoldierOperation> soldierOperations;

    public Operation() {

    }

    public Operation(Long id,String name,Date startDate, Date endDate,String location,Long operationTypeId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.operationTypeId = operationTypeId;
        this.operationType = operationType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(Long operationTypeId) {
        this.operationTypeId = operationTypeId;
    }
    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
