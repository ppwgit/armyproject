package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Rank;

import java.util.List;

public interface IRankDAO {
    public void insert(Rank rank);
    public void update(Rank rank);
    public void delete(int rankId);
    public List<Rank> getAllRanks();
    public Rank getRankById(int rankId);
}
