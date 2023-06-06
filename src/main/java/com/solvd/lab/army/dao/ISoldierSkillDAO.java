package com.solvd.lab.army.dao;

import com.solvd.lab.army.model.SoldierSkill;

import java.util.List;

public interface ISoldierSkillDAO {
    public void insert(SoldierSkill soldierSkill);
    public void update(SoldierSkill soldierSkill);
    public void delete(int soldierSkillId);
    public List<SoldierSkill> getAllSoldierSkills();
    public SoldierSkill getSoldierSkillById(int soldierSkillId);
}
