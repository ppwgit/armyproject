package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.City;
import com.solvd.lab.army.entity.SoldierSkill;

import java.util.List;

public abstract class SoldierSkillDAOAbstract {
    public abstract void insert(SoldierSkill soldierSkill);
    public abstract void update(SoldierSkill soldierSkill);
    public abstract void delete(int soldierSkillId);
    public abstract List<SoldierSkill> getAllSoldierSkills();
    public abstract SoldierSkill getSoldierSkillById(int soldierSkillId);
}
