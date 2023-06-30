package com.solvd.lab.army.patterns.Observer;

public class InventoryManager implements  Observer{
    private IEquipmentStock equipmentStock;

    public InventoryManager(IEquipmentStock equipmentStock) {
        this.equipmentStock = equipmentStock;
        equipmentStock.register(this);
    }

    @Override
    public void update(Long rifleAmount, Long submachineGunAmount, Long machineGunAmount) {
        System.out.println("Inventory Manager - Rifles: " + rifleAmount);
        System.out.println("Inventory Manager - Submachine Guns: " + submachineGunAmount);
        System.out.println("Inventory Manager - Machine Guns: " + machineGunAmount);
    }
}
