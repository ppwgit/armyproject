package com.solvd.lab.army.patterns.Factory;

public class Vehicle implements IEquipment{
    @Override
    public void maintenance() {
        System.out.println("Maintenance on vehicles");
    }

    @Override
    public void repair() {
        System.out.println("Repairing vehicles");
    }

    @Override
    public void replace() {
        System.out.println("Replacing vehicles");
    }
}
