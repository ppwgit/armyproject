package com.solvd.lab.army.patterns.Builder;

public class Weapons {
    private final String name;
    private final String type;
    private final String model;
    private final Long quantity;

    protected Weapons(String name, String type, String model, Long quantity){

        this.name = name;
        this.type = type;
        this.model = model;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public Long getQuantity() {
        return quantity;
    }

}