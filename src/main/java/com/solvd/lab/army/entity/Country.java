package com.solvd.lab.army.entity;

import java.util.List;

public class Country {
    private Integer id;
    private String name;
    private List<State> state;

    public Country() {

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

