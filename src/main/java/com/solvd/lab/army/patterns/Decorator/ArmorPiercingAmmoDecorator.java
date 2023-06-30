package com.solvd.lab.army.patterns.Decorator;

public class ArmorPiercingAmmoDecorator extends  AmmunitionDecorator{
    public ArmorPiercingAmmoDecorator(IAmmunition decoratedAmmunition) {
        super(decoratedAmmunition);
    }

    @Override
    public void fire() {
        System.out.println("Firing armor piercing");
        super.fire();
    }

    @Override
    public double getDamage() {
        return super.getDamage() + 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " (Armor Piercing)";
    }
}

