package com.solvd.lab.army.patterns.Builder;

import com.solvd.lab.army.patterns.Factory.Weapon;

public class WeaponBuilder {
    private String name;
    private String type;
    private String model;
    private Long quantity;

    public WeaponBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WeaponBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public WeaponBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public WeaponBuilder setQuantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    public Weapons build() {
        return new Weapons( name,  type,  model,  quantity);
    }
}