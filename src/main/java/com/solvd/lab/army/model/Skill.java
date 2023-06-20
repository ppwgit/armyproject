package com.solvd.lab.army.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Skill {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    @XmlElement(name = "name")
    private String name;

    @JsonProperty("description")
    @XmlElement(name = "description")
    private String description;

    @JsonProperty("skills")
    private List<Skill> skills;

    @XmlElementWrapper(name = "soldierSkills")
    @XmlElement(name = "soldierSkill")
    private List<SoldierSkill> soldierSkills;

    public Skill() {

    }
    public Skill(Long id,String name,String description) {
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

    public List<Skill> getSkill() {
        return skills;
    }
    public void setSkill(List<Skill> skills) {
        this.skills = skills;
    }
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", skills='" + skills + '\'' +
                ", soldierSkills=" + soldierSkills +
                '}';
    }

}
