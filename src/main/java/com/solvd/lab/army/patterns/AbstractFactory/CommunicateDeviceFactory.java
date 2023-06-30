package com.solvd.lab.army.patterns.AbstractFactory;

import com.solvd.lab.army.patterns.Factory.CommunicationDevice;
import com.solvd.lab.army.patterns.Factory.IEquipment;

public class CommunicateDeviceFactory extends  EquipmentFactory{
    @Override
    public IEquipment createEquipment() {
        return new CommunicationDevice();
    }
}
