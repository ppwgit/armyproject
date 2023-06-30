package com.solvd.lab.army.patterns.AbstractFactory;

import com.solvd.lab.army.patterns.Factory.IEquipment;
import com.solvd.lab.army.patterns.Factory.LoadCarryEquip;

public class LoadCarryFactory extends EquipmentFactory{
    @Override
    public IEquipment createEquipment() {
        return new LoadCarryEquip();
    }
}
