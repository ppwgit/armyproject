package com.solvd.lab.army.model;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private Long id;
    private String name;
    private Long rankTypeId;
    private RankType rankType;
    private List<RankType> rankTypes;

    public Rank() {

    }

    public Rank(long id, String name, long rankTypeId) {
        this.id = id;
        this.name = name;
        this.rankTypeId = rankTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRankTypeId() {
        return rankTypeId;
    }

    public void setRankTypeId(Long rankTypeId) {
        this.rankTypeId = rankTypeId;
    }

    public void addRankType(RankType rankType) {
        rankTypes.add(rankType);
    }

    public List<RankType> getRankTypes() {
        return rankTypes;
    }
    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rankTypeId='" + rankTypeId + '\'' +
                ", rankTypes=" + rankTypes +
                '}';
    }
}




