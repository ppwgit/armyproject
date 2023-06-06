package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Skill;

import java.util.List;

public interface ISkillDAO {
    public void insert(Skill skill);
    public void update(Skill skill);
    public void delete(int skillId);
    public List<Skill> getAllSkills();
    public Skill getSkillById(int skillId);
}
