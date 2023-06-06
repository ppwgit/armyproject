package com.solvd.lab.army.model;

public class SoldierSkill {
    private Long soldierSkillId; //link to Soldier Table
    private Long skillId; //link to Skill Table
    private Soldier soldier;
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
