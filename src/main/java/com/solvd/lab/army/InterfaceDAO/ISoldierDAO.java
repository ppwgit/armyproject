package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Soldier;
import java.util.List;

public interface ISoldierDAO {
    public void insert(Soldier soldier);
    public void update(Soldier soldier);
    public void delete(int soldierId);
    public List<Soldier> getAllSoldiers();
    public Soldier getSoldierById(int soldierId);
}