package com.solvd.lab.army.controller;

import com.solvd.lab.army.dao.ISoldierDAO;
import com.solvd.lab.army.dao.impl.SoldierDAOImpl;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.view.SoldierView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SoldierController {
    private SoldierDAOImpl soldierDAO;
    private SoldierView soldierView;

    public SoldierController(SoldierDAOImpl soldierDAO, SoldierView soldierView) {
        this.soldierDAO = soldierDAO;
        this.soldierView = soldierView;
    }

    public void displayAllSoldiers() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        List<Soldier> soldiers = soldierDAO.getAll();
        soldierView.displayAllSoldiersInfo(soldiers);
    }

    public void displaySoldierById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Soldier soldier = soldierDAO.getById(id);
        if (soldier != null) {
            soldierView.displaySoldierInfo(soldier);
        } else {
            System.out.println("Soldier not found with ID: " + id);
        }
    }
}
