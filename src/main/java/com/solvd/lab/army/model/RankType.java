package com.solvd.lab.army.model;

import java.util.List;

public class RankType {
    private Long id;
    private String name;
    private List<Rank> rank;
    public RankType() {

    }

    public RankType(Long id,String name) {
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

    public String toString() {
        return "RankType{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
