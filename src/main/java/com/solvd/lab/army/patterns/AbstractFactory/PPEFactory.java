package com.solvd.lab.army.patterns.AbstractFactory;

import com.solvd.lab.army.patterns.Factory.IEquipment;
import com.solvd.lab.army.patterns.Factory.PPE;

public class PPEFactory extends EquipmentFactory{

    @Override
    public IEquipment createEquipment() {
        return new PPE();
    }
}
