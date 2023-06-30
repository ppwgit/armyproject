package com.solvd.lab.army.patterns.Factory;

public class CommunicationDevice implements IEquipment{
    @Override
    public void maintenance() {
        System.out.println("Maintenance on communication devices");
    }

    @Override
    public void repair() {
        System.out.println("Repairing communication devices");
    }

    @Override
    public void replace() {
        System.out.println("Replacing communication devices");
    }
}
