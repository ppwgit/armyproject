package com.solvd.lab.army.mybatis;

import com.solvd.lab.army.model.Operation;
import com.solvd.lab.army.model.Skill;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.model.Unit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ISoldierMapper extends IMapper<Soldier>{
    String findRankForSoldier(long id)throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    String findBaseForSoldier(long id)throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public List<Soldier> findAllAliveSoldiers() throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public List<Skill> findSkillsBySoldierId() throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public List<Operation> findOperationsBySoldierId() throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public List<Unit> findUnitsBySoldierId() throws SQLException, IOException, InterruptedException, ClassNotFoundException;
}
