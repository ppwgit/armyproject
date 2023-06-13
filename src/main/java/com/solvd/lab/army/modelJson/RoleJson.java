package com.solvd.lab.army.modelJson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.lab.army.model.Soldier;

import javax.xml.bind.annotation.XmlAccessType;
import java.util.List;


public class RoleJson {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    public RoleJson(){

    }
    public RoleJson(Long id, String name) {
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
        return "RoleJson{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
