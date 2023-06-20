package com.solvd.lab.army.dao;

import com.solvd.lab.army.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ISoldierDAO extends IDAO<Soldier> {
    String findRankForSoldier(long id)throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    String findBaseForSoldier(long id)throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public List<Soldier> findAllAliveSoldiers() throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public List<Skill> findSkillsBySoldierId() throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public List<Operation> findOperationsBySoldierId() throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public List<Unit> findUnitsBySoldierId() throws SQLException, IOException, InterruptedException, ClassNotFoundException;

}