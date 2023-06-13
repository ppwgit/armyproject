package com.solvd.lab.army.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SoldierSkill {

    @XmlElement(name = "soldierSkillId")
    private Long soldierSkillId; //link to Soldier Table

    @XmlElement(name = "skillId")
    private Long skillId; //link to Skill Table

    @XmlElement(name = "soldier")
    private Soldier soldier;

    @XmlElement(name = "skill")
    private Skill skill;

    public SoldierSkill() {

    }

    public Long getSoldierSkillId() {
        return soldierSkillId;
    }

    public void setSoldierSkillId(Long soldierSkillId) {
        this.soldierSkillId = soldierSkillId;
    }
    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }
}
