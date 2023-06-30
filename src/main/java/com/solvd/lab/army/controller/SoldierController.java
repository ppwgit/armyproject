package com.solvd.lab.army.controller;

import com.solvd.lab.army.dao.ISoldierDAO;
import com.solvd.lab.army.dao.impl.SoldierDAOImpl;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.view.SoldierView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SoldierController {
    private SoldierView view;
    private Soldier model;


    public SoldierController(Soldier model, SoldierView view) {
        this.model = model;
        this.view = view;
    }

    public void setSoldierDetails(
            long id, String firstName, String lastName, String gender,
            String contactNumber, String emergencyNumber, String email, String address
    ) {
        model.setId(id);
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setGender(gender);
        model.setContactNumber(contactNumber);
        model.setEmergencyNumber(emergencyNumber);
        model.setEmail(email);
        model.setAddress(address);
    }

    public void updateView() {
        view.displaySoldierDetails(model);
    }
}