package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.SoldierSkill;

import java.util.List;

public interface ISoldierSkillDAO {
    public void insert(SoldierSkill soldierSkill);
    public void update(SoldierSkill soldierSkill);
    public void delete(int soldierSkillId);
    public List<SoldierSkill> getAllSoldierSkills();
    public SoldierSkill getSoldierSkillById(int soldierSkillId);
}
