package com.solvd.lab.army.view;

import com.solvd.lab.army.controller.SoldierController;
import com.solvd.lab.army.dao.ISoldierDAO;
import com.solvd.lab.army.dao.impl.SoldierDAOImpl;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.service.ISoldierService;
import com.solvd.lab.army.service.impl.SoldierServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SoldierView {
    public void displaySoldierDetails(Soldier soldier) {
        System.out.println("Soldier Details:");
        System.out.println("ID: " + soldier.getId());
        System.out.println("First Name: " + soldier.getFirstName());
        System.out.println("Last Name: " + soldier.getLastName());
        System.out.println("Gender: " + soldier.getGender());
        System.out.println("Contact Number: " + soldier.getContactNumber());
        System.out.println("Emergency Number: " + soldier.getEmergencyNumber());
        System.out.println("Email: " + soldier.getEmail());
        System.out.println("Address: " + soldier.getAddress());
         }
}