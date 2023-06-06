package com.solvd.lab.army.model;

import java.util.List;

public class OperationType {
    private Long id;
    private String name;
    private List<Operation> operations;

    public OperationType() {

    }
    public OperationType(long id, String name) {
        this.id = id;
        this.name = name;
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
}
