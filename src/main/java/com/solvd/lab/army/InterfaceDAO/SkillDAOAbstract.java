package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.City;
import com.solvd.lab.army.entity.Skill;

import java.util.List;

public abstract class SkillDAOAbstract {
    public abstract void insert(Skill skill);
    public abstract void update(Skill skill);
    public abstract void delete(int skillId);
    public abstract List<Skill> getAllSkills();
    public abstract Skill getSkillById(int skillId);
}
