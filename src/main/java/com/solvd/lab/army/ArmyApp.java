package com.solvd.lab.army;

import com.solvd.lab.army.controller.SoldierController;
import com.solvd.lab.army.model.Operation;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.patterns.AbstractFactory.*;
import com.solvd.lab.army.patterns.Builder.WeaponBuilder;
import com.solvd.lab.army.patterns.Builder.Weapons;
import com.solvd.lab.army.patterns.Decorator.ArmorPiercingAmmoDecorator;
import com.solvd.lab.army.patterns.Decorator.BasicAmmunition;
import com.solvd.lab.army.patterns.Decorator.IAmmunition;
import com.solvd.lab.army.patterns.Facade.RifleStockFacade;
import com.solvd.lab.army.patterns.Factory.NavigateOptic;
import com.solvd.lab.army.patterns.Factory.SoldierEquipmentFactory;
import com.solvd.lab.army.patterns.Factory.IEquipment;

import com.solvd.lab.army.patterns.Observer.EquipmentStock;
import com.solvd.lab.army.patterns.Observer.InventoryManager;
import com.solvd.lab.army.patterns.Proxy.IOperationData;
import com.solvd.lab.army.patterns.Proxy.OperationProxy;
import com.solvd.lab.army.patterns.Proxy.UnauthorizedAccessException;
import com.solvd.lab.army.patterns.Strategy.*;
import com.solvd.lab.army.view.SoldierView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class ArmyApp {
    private static final Logger logger = LogManager.getLogger(ArmyApp.class);

    public static void main(String[] args) throws SQLException, IOException, InterruptedException, ClassNotFoundException {


        //------------------------- Factory ------------------------------
        IEquipment ppe = SoldierEquipmentFactory.createEquipment("PPE");
        ppe.maintenance();
        ppe.repair();
        ppe.replace();

        IEquipment weapon = SoldierEquipmentFactory.createEquipment("Weapons");
        weapon.maintenance();
        weapon.repair();
        weapon.replace();

        IEquipment communicationDevice = SoldierEquipmentFactory.createEquipment("Communication Devices");
        communicationDevice.maintenance();
        communicationDevice.repair();
        communicationDevice.replace();

        IEquipment navigationAndOptic = SoldierEquipmentFactory.createEquipment("Navigation and Optics");
        navigationAndOptic.maintenance();
        navigationAndOptic.repair();
        navigationAndOptic.replace();

        IEquipment loadCarryingEquipment = SoldierEquipmentFactory.createEquipment("Load-Carrying Equipment");
        loadCarryingEquipment.maintenance();
        loadCarryingEquipment.repair();
        loadCarryingEquipment.replace();

        IEquipment tool = SoldierEquipmentFactory.createEquipment("Tools");
        tool.maintenance();
        tool.repair();
        tool.replace();

        IEquipment vehicle = SoldierEquipmentFactory.createEquipment("Vehicles");
        vehicle.maintenance();
        vehicle.repair();
        vehicle.replace();


        //------------------------- Abstract Factory ------------------------------
        EquipmentFactory ppeFactory = new PPEFactory();
        IEquipment ppeAb = ppeFactory.createEquipment();
        ppe.maintenance();
        ppe.repair();
        ppe.replace();

        EquipmentFactory weaponsFactory = new WeaponFactory();
        IEquipment weapons = weaponsFactory.createEquipment();
        weapons.maintenance();
        weapons.repair();
        weapons.replace();

        EquipmentFactory communicationDevicesFactory = new CommunicateDeviceFactory();
        IEquipment communicationDevices = communicationDevicesFactory.createEquipment();
        communicationDevices.maintenance();
        communicationDevices.repair();
        communicationDevices.replace();

        EquipmentFactory navigationAndOpticsFactory = new NavigateOpticFactory();
        IEquipment navigationAndOptics = navigationAndOpticsFactory.createEquipment();
        navigationAndOptics.maintenance();
        navigationAndOptics.repair();
        navigationAndOptics.replace();

        EquipmentFactory loadCarryingEquipmentFactory = new LoadCarryFactory();
        IEquipment loadCarryEquipment = loadCarryingEquipmentFactory.createEquipment();
        loadCarryingEquipment.maintenance();
        loadCarryingEquipment.repair();
        loadCarryingEquipment.replace();

        EquipmentFactory toolsFactory = new ToolFactory();
        IEquipment tools = toolsFactory.createEquipment();
        tools.maintenance();
        tools.repair();
        tools.replace();

        EquipmentFactory vehiclesFactory = new VehicleFactory();
        IEquipment vehicles = vehiclesFactory.createEquipment();
        vehicles.maintenance();
        vehicles.repair();
        vehicles.replace();

        //------------------------- Builder ------------------------------

        WeaponBuilder builder = new WeaponBuilder()
                .setName("M16")
                .setType("Rifle")
                .setModel("A4")
                .setQuantity(10L);

        Weapons weaponsbuilder = builder.build();
        System.out.println(weaponsbuilder.getName());
        System.out.println(weaponsbuilder.getType());
        System.out.println(weaponsbuilder.getModel());
        System.out.println(weaponsbuilder.getQuantity());

        //------------------------- Observer ------------------------------

        EquipmentStock equipmentStock = new EquipmentStock();
        InventoryManager inventoryManager = new InventoryManager(equipmentStock);
        equipmentStock.setRifleAmount(20L);
        equipmentStock.setSubmachineGunAmount(15L);
        equipmentStock.setMachineGunAmount(10L);


//------------------------- Facade ------------------------------
        String rifleNumber = "ABC123";
        Long initialRifleStock = 20L;
        RifleStockFacade rifleStockFacade = new RifleStockFacade(rifleNumber, initialRifleStock);

        Long requisitionAmount = 10L;
        System.out.println("Checking availability of " + requisitionAmount + " Rifle Number: " + rifleNumber );
        if (rifleStockFacade.checkAvailability(requisitionAmount)) {
            System.out.println("Rifles are available.");
            rifleStockFacade.processRequisition(requisitionAmount);
        } else {
            System.out.println("Rifles are not available.");
        }
        Long returnAmount = 5L;
        System.out.println("return Rifle Number: " + rifleNumber );
        rifleStockFacade.processReturn(returnAmount);

//------------------------- Decorator ------------------------------


        IAmmunition basicAmmunition = new BasicAmmunition(100, "Standard Ammo");
        basicAmmunition.fire();

        IAmmunition decoratedAmmunition = new ArmorPiercingAmmoDecorator(basicAmmunition);
        decoratedAmmunition.fire();
        System.out.println(decoratedAmmunition.getDamage());
        System.out.println(decoratedAmmunition.getDescription());

//------------------------- Strategy ------------------------------
        Training soldier = new Training();

        ITrainingStrategy basicStrategy = new BasicTrainingStrategy();
        ITrainingStrategy infantryStrategy = new InfantryTrainingStrategy();
        ITrainingStrategy medicStrategy = new MedicTrainingStrategy();
        ITrainingStrategy sniperStrategy = new SniperTrainingStrategy();

        soldier.setTrainingStrategy(basicStrategy);
        soldier.train();

        soldier.setTrainingStrategy(infantryStrategy);
        soldier.train();

        soldier.setTrainingStrategy(medicStrategy);
        soldier.train();

        soldier.setTrainingStrategy(sniperStrategy);
        soldier.train();


        //------------------------- Proxy ------------------------------
        Soldier soldierProxy = new Soldier(1L, 1);
        //Soldier soldierProxy = new Soldier(1L, 2);

        IOperationData proxy = new OperationProxy(soldierProxy);

        try {
            Operation operation = proxy.getOperationData();
            System.out.println("Operation ID: " + operation.getId());
            System.out.println("Operation Name: " + operation.getName());
            System.out.println("Operation Start Date: " + operation.getStartDate());
            System.out.println("Operation End Date: " + operation.getEndDate());
            System.out.println("Operation Location: " + operation.getLocation());
        } catch (UnauthorizedAccessException e) {
            System.out.println("Unauthorized access: " + e.getMessage());
        }

//------------------------- MVC ------------------------------
        Soldier model = new Soldier();
        SoldierView view = new SoldierView();
        SoldierController controller = new SoldierController(model, view);
        controller.setSoldierDetails(
                1L, "Papaya", "Salad", "Female",
                "1234567890", "9876543210", "papaya@mail.com", "547 Rose Street,AA city,Michigan,USA"
        );

        controller.updateView();
       }
    }



