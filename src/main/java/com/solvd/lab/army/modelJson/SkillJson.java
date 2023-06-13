package com.solvd.lab.army.modelJson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.lab.army.model.SoldierSkill;

import java.util.List;


public class SkillJson {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    public SkillJson() {

    }
    public SkillJson(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
