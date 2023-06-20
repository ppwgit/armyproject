package com.solvd.lab.army.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Role {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    @XmlElement(name = "name")
    private String name;

    @XmlElementWrapper(name = "soldiers")
    @XmlElement(name = "soldier")
    private List<Soldier> soldiers;

    public Role(){

    }
    public Role(Long id,String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
