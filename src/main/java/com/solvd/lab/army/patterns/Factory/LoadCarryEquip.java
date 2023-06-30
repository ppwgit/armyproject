package com.solvd.lab.army.patterns.Factory;

public class LoadCarryEquip implements IEquipment{
    @Override
    public void maintenance() {
        System.out.println("Maintenance on load-carrying equipment");
    }

    @Override
    public void repair() {
        System.out.println("Repairing load-carrying equipment");
    }

    @Override
    public void replace() {
        System.out.println("Replacing load-carrying equipment");
    }
}