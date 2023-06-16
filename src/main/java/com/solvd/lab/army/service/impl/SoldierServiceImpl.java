package com.solvd.lab.army.service.impl;

import com.solvd.lab.army.dao.IOperationDAO;
import com.solvd.lab.army.dao.IRankDAO;
import com.solvd.lab.army.dao.ISkillDAO;
import com.solvd.lab.army.dao.ISoldierDAO;
import com.solvd.lab.army.dao.impl.*;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.model.Unit;
import com.solvd.lab.army.service.ISoldierService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SoldierServiceImpl implements ISoldierService {

    private ISoldierDAO soldierDAO = new SoldierDAOImpl();
    private SoldierDAOImpl soldierDAOImpl;
    private RankDAOImpl rankDAO;
    private SkillDAOImpl skillDAO ;
    private OperationDAOImpl operationDAO;
    private UnitDAOImpl unitDAO;

    @Override
    public Soldier getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Soldier soldier = soldierDAOImpl.getById(id);
        if (soldier != null) {
            soldier.setRankName(soldierDAOImpl.findRankForSoldier(id));
            soldier.setSkills(skillDAO.findSkillsBySoldierId(id));
            soldier.setOperations(operationDAO.findOperationsBySoldierId(id));
            soldier.setUnits(unitDAO.findUnitsBySoldierId(id));
        }
        return soldier;

    }

    @Override
    public List<Soldier> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        return soldierDAO.getAll();
    }

    @Override
    public void insert(Soldier soldier) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        soldierDAO.insert(soldier);
    }

    @Override
    public void update(Soldier soldier) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        soldierDAO.update(soldier);
    }

    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        soldierDAO.delete(id);
    }

    public String findRankForSoldier(long soldierId) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        String rank = soldierDAOImpl.findRankForSoldier(soldierId);
        return rank;
    }
    public String findBaseForSoldier(long soldierId) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        String base = soldierDAOImpl.findBaseForSoldier(soldierId);
        return base;
    }

    public List<Soldier> findAllAliveSoldiers() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
        return soldierDAOImpl.getAliveSoldiers();
    }

}
