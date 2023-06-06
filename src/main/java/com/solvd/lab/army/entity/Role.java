package com.solvd.lab.army.entity;

import java.util.List;

public class Role {
    private Integer id;
    private String name;
    private List<Soldier> soldiers;
    public Role(){

    }
    public Role(Integer id,String name) {
        this.id = id;
        this.name = name;
    }
    public Role(String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
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
