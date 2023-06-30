package com.solvd.lab.army.patterns.Decorator;

public class BasicAmmunition implements  IAmmunition{
    private double damage;
    private String description;

    public BasicAmmunition(double damage, String description) {
        this.damage = damage;
        this.description = description;
    }

    @Override
    public void fire() {
        System.out.println("Firing basic ammunition: " + getDescription());
    }

    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
