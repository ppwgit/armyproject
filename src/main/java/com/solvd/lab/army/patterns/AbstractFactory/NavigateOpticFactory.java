package com.solvd.lab.army.patterns.AbstractFactory;

import com.solvd.lab.army.patterns.Factory.IEquipment;
import com.solvd.lab.army.patterns.Factory.NavigateOptic;

public class NavigateOpticFactory extends EquipmentFactory{
    @Override
    public IEquipment createEquipment() {
        return new NavigateOptic();
    }
}
