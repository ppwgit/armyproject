package com.solvd.lab.army.service;

import com.solvd.lab.army.dao.Impl.RankDAOImpl;

public class RankService extends RankServiceAbstract {
    private RankDAOImpl rankDao;

    public RankService(RankDAOImpl rankDao) {
        this.rankDao = rankDao;
    }

    @Override
    protected RankDAOImpl getRankDao() {
        return rankDao;
    }
}
