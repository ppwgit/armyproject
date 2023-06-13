package com.solvd.lab.army.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SoldierOperation {

    @XmlElement(name = "soldierOperationId")
    private Long soldierOperationId; //link to Soldier Table

    @XmlElement(name = "operationId")
    private Long operationId; //link to Operation Table

    @XmlElement(name = "soldier")
    private Soldier soldier;

    @XmlElement(name = "operation")
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