package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.RankType;

import java.util.List;

public interface IRankTypeDAO {
    public void insert(RankType rankType);
    public void update(RankType rankType);
    public void delete(int rankTypeId);
    public List<RankType> getAllRankTypes();
    public RankType getRankTypeById(int rankTypeId);
}
