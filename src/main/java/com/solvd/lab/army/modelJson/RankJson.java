package com.solvd.lab.army.modelJson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.lab.army.model.RankType;

import java.util.List;

public class RankJson {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;


    public RankJson() {

    }

    public RankJson(long id, String name, long rankTypeId) {
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



