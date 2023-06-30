package com.solvd.lab.army.patterns.AbstractFactory;

import com.solvd.lab.army.patterns.Factory.IEquipment;
import com.solvd.lab.army.patterns.Factory.Tool;

public class ToolFactory extends EquipmentFactory{
    @Override
    public IEquipment createEquipment() {
        return new Tool();
    }
}
