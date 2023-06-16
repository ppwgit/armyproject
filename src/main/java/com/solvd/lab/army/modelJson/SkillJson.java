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

    @JsonProperty("skills")
    private List<SkillJson> skills;



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
    public List<SkillJson> getSkill() {
        return skills;
    }

    public void setSkill(List<SkillJson> skills) {
        this.skills = skills;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String toString() {
        return "SKillJson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
