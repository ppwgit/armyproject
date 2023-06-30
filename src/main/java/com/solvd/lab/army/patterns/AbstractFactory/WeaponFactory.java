package com.solvd.lab.army.patterns.AbstractFactory;

import com.solvd.lab.army.patterns.Factory.IEquipment;
import com.solvd.lab.army.patterns.Factory.Weapon;

public class WeaponFactory extends EquipmentFactory{
    @Override
    public IEquipment createEquipment() {
        return new Weapon();
    }
}
