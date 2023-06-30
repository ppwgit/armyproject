package com.solvd.lab.army.patterns.AbstractFactory;

import com.solvd.lab.army.patterns.Factory.IEquipment;

public abstract class EquipmentFactory {

    public EquipmentFactory() {
    }
    public abstract IEquipment createEquipment();
}

