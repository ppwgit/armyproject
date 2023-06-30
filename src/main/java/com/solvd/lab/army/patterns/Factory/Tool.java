package com.solvd.lab.army.patterns.Factory;

public class Tool implements IEquipment{
    @Override
    public void maintenance() {
        System.out.println("Maintenance on tools");
    }

    @Override
    public void repair() {
        System.out.println("Repairing tools");
    }

    @Override
    public void replace() {
        System.out.println("Replacing tools");
    }
}