package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.City;
import com.solvd.lab.army.entity.Rank;

import java.util.List;

public abstract class RankDAOAbstract {
    public abstract void insert(Rank rank);
    public abstract void update(Rank rank);
    public abstract void delete(int rankId);
    public abstract List<Rank> getAllRanks();
    public abstract Rank getRankById(int rankId);
}
