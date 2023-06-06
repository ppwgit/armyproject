package com.solvd.lab.army.entity;

import java.util.List;

public class OperationType {
    private Integer id;
    private String name;
    private List<Operation> operations;

    public OperationType() {

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
}
