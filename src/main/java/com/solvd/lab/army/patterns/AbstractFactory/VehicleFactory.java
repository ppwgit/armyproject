package com.solvd.lab.army.patterns.AbstractFactory;

import com.solvd.lab.army.patterns.Factory.IEquipment;
import com.solvd.lab.army.patterns.Factory.Vehicle;

public class VehicleFactory extends EquipmentFactory{
    @Override
    public IEquipment createEquipment() {
        return new Vehicle();
    }
}
