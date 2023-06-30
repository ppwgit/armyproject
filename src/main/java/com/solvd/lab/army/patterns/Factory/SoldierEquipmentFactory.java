package com.solvd.lab.army.patterns.Factory;

public class SoldierEquipmentFactory {
    public static IEquipment createEquipment(String equipmentCategory) {
        switch (equipmentCategory) {
            case "PPE":
                return new PPE();
            case "Weapons":
                return new Weapon();
            case "Communication Devices":
                return new CommunicationDevice();
            case "Navigation and Optics":
                return new NavigateOptic();
            case "Load-Carrying Equipment":
                return new LoadCarryEquip();
            case "Tools":
                return new Tool();
            case "Vehicles":
                return new Vehicle();
            default:
                throw new IllegalArgumentException("Invalid equipment category: " + equipmentCategory);
        }
    }
}

