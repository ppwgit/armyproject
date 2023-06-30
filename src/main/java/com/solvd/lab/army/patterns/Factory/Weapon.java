package com.solvd.lab.army.patterns.Factory;

import com.solvd.lab.army.patterns.Builder.WeaponBuilder;

public class Weapon implements IEquipment{

    @Override
    public void maintenance() {
        System.out.println("Maintenance on weapons");
    }

    @Override
    public void repair() {
        System.out.println("Repairing weapons");
    }

    @Override
    public void replace() {
        System.out.println("Replacing weapons");
    }
}
