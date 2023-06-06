package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Base;
import com.solvd.lab.army.entity.Soldier;

import java.util.List;

public interface IBaseDAO {
    public void insert(Base base);
    public void update(Base base);
    public void delete(int baseId);
    public List<Base> getAllBases();
    public Base getBaseById(int baseId);
}
