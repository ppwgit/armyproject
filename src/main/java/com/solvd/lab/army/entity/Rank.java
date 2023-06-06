package com.solvd.lab.army.entity;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private Integer id;
    private String name;
    private Integer rankTypeId;
    private RankType rankType;
    private List<RankType> rankTypes;

    public Rank() {

    }

    public Rank(Integer id,String name,Integer rankTypeId) {
        this.id = id;
        this.name = name;
        this.rankTypeId = rankTypeId;
        this.rankTypes = new ArrayList<>();

    }
    public Rank(String name,Integer rankTypeId) {
        this.id = id;
        this.name = name;
        this.rankTypeId = rankTypeId;

    }
    public Rank(Integer id,String name,Integer rankTypeId,RankType rankType) {
        this.id = id;
        this.name = name;
        this.rankTypeId = rankTypeId;
        this.rankType = rankType;
    }
    public Rank(String name,Integer rankTypeId,RankType rankType) {
        this.id = id;
        this.name = name;
        this.rankTypeId = rankTypeId;
        this.rankType = rankType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRankTypeId() {
        return rankTypeId;
    }

    public void setRankTypeId(Integer rankTypeId) {
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




