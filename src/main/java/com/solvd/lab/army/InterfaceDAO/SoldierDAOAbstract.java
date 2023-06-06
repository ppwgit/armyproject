package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Soldier;

import java.util.List;

public abstract class SoldierDAOAbstract {

    public abstract void insert(Soldier soldier);
    public abstract void update(Soldier soldier);
    public abstract void delete(int soldierId);
    public abstract List<Soldier> getAllSoldiers();
    public abstract Soldier getSoldierById(int soldierId);
}