package com.solvd.lab.army.patterns.Factory;

public class PPE implements IEquipment{

    @Override
    public void maintenance() {
        System.out.println("Maintenance on personal protective equipment");
    }

    @Override
    public void repair() {
        System.out.println("Repairing personal protective equipment");
    }

    @Override
    public void replace() {
        System.out.println("Replacing personal protective equipment");
    }
}