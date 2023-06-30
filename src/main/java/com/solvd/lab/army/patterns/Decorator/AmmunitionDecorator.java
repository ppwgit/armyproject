package com.solvd.lab.army.patterns.Decorator;

public abstract class AmmunitionDecorator implements IAmmunition{
    private IAmmunition decoratedAmmunition;

    public AmmunitionDecorator(IAmmunition decoratedAmmunition) {
        this.decoratedAmmunition = decoratedAmmunition;
    }

    @Override
    public void fire() {
        decoratedAmmunition.fire();
    }

    @Override
    public double getDamage() {
        return decoratedAmmunition.getDamage();
    }

    @Override
    public String getDescription() {
        return decoratedAmmunition.getDescription();
    }
}
