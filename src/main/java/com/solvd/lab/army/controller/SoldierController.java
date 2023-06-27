package com.solvd.lab.army.controller;

import com.solvd.lab.army.dao.ISoldierDAO;
import com.solvd.lab.army.dao.impl.SoldierDAOImpl;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.view.SoldierView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SoldierController {
    private SoldierView soldierView;
    private ISoldierDAO soldierDAO;

    public SoldierController() {
        soldierView = new SoldierView();
        soldierDAO = new SoldierDAOImpl();
    }

    public void getAllSoldiers() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        List<Soldier> soldiers = soldierDAO.getAll();
        if (soldiers.isEmpty()) {
            soldierView.displayErrorMessage("No soldiers found.");
        } else {
            for (Soldier soldier : soldiers) {
                soldierView.displaySoldierInfo(soldier);
            }
        }
    }

    public void getSoldierById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Soldier soldier = soldierDAO.getById(id);
        if (soldier == null) {
            soldierView.displayErrorMessage("Soldier with ID " + id + " not found.");
        } else {
            soldierView.displaySoldierInfo(soldier);
        }
    }

    public static void main(String[] args) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        SoldierController soldierController = new SoldierController();
        soldierController.getAllSoldiers();
        soldierController.getSoldierById(5);
    }
}