package com.solvd.lab.army.patterns.Factory;

public class NavigateOptic implements IEquipment{
    @Override
    public void maintenance() {
        System.out.println("Maintenance on navigation and optics equipment");
    }

    @Override
    public void repair() {
        System.out.println("Repairing navigation and optics equipment");
    }

    @Override
    public void replace() {
        System.out.println("Replacing navigation and optics equipment");
    }
}
