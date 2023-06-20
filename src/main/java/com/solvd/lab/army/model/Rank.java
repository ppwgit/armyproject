package com.solvd.lab.army.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Rank {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "rankTypeId")
    private Long rankTypeId;

    @XmlElement(name = "rankType")
    private RankType rankType;

    @XmlElementWrapper(name = "rankTypes")
    @XmlElement(name = "rankType")
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


    public RankType getRankType() {
        return rankType;
    }

    public void setRankType(RankType rankType) {
        this.rankType = rankType;
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





