package com.solvd.lab.army.model;

import java.util.List;

public class Role {
    private Long id;
    private String name;
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
