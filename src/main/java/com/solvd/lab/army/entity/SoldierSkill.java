package com.solvd.lab.army.entity;

public class SoldierSkill {
    private Integer soldierSkillId; //link to Soldier Table
    private Integer skillId; //link to Skill Table
    private Soldier soldier;
    private Skill skill;
    public SoldierSkill() {

    }

    public Integer getSoldierSkillId() {
        return soldierSkillId;
    }

    public void setSoldierSkillId(Integer soldierSkillId) {
        this.soldierSkillId = soldierSkillId;
    }
    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }
}
