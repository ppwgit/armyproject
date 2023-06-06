package com.solvd.lab.army.service;

import com.solvd.lab.army.dao.Impl.RankDAOImpl;
import com.solvd.lab.army.model.Rank;

import java.util.List;

public abstract class RankServiceAbstract {
    protected abstract RankDAOImpl getRankDao();
/*
    public Rank getRankById(int rankId) {
        return getRankDao().getRankById(rankId);
    }

    public List<Rank> getAllRanks()  {
        return getRankDao().getAllRanks();
    }

    public void insert(Rank rank) {
        getRankDao().insert(rank);
    }

    public void update(Rank rank) {
        getRankDao().update(rank);
    }

    public void delete(int rankId) {
        getRankDao().delete(rankId);
    }

    public  List<Rank> getRankWithRankTypes()  {
        return getRankDao().getRankWithRankTypes();
    }*/
}