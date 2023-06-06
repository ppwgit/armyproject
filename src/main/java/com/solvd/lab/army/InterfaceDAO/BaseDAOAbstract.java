package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Base;
import com.solvd.lab.army.entity.Soldier;

import java.util.List;

public abstract class BaseDAOAbstract {

    public abstract void insert(Base base);
    public abstract void update(Base base);
    public abstract void delete(int baseId);
    public abstract List<Base> getAllBases();
    public abstract Base getBaseById(int baseId);
}
