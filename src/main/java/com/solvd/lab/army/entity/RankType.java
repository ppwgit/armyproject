package com.solvd.lab.army.entity;

import java.util.List;

public class RankType {
    private Integer id;
    private String name;
    private List<Rank> rank;
    public RankType() {

    }
    public RankType(Integer id) {
        this.id = id;
        this.name = name;
    }
    public RankType(Integer id,String name) {
        this.id = id;
        this.name = name;
    }

    public RankType(String name) {
        this.name = name;
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

    public String toString() {
        return "RankType{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
