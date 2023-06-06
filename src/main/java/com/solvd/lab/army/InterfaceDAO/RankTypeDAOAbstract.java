package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Rank;
import com.solvd.lab.army.entity.RankType;

import java.util.List;

public abstract class RankTypeDAOAbstract {
    public abstract void insert(RankType rankType);
    public abstract void update(RankType rankType);
    public abstract void delete(int rankTypeId);
    public abstract List<RankType> getAllRankTypes();
    public abstract RankType getRankTypeById(int rankTypeId);
}
