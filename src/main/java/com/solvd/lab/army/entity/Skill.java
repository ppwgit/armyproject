package com.solvd.lab.army.entity;

import java.util.List;

public class Skill {
    private Integer id;
    private String name;
    private String description;
    private List<SoldierSkill> soldierSkills;

    public Skill() {

    }
    public Skill(Integer id,String name,String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Skill(String name,String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
