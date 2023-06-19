package com.solvd.lab.army.model;

import com.solvd.lab.army.utils.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Operation {

    private Long id;

    @XmlElement(name = "name")
    private String name;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date startDate;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date endDate;

    @XmlElement(name = "location")
    private String location;

    @XmlElement(name = "operationTypeId")
    private Long operationTypeId;

    @XmlElement(name = "operationType")
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
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                ", operationTypeId=" + operationTypeId +
                ", operationType=" + operationType +
                '}';
    }
}
