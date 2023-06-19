package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.model.Operation;
import com.solvd.lab.army.model.Skill;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.model.Unit;
import com.solvd.lab.army.mybatis.ISoldierMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SoldierMapper implements ISoldierMapper {

    private SqlSessionFactory sqlSessionFactory;

    public SoldierMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Soldier getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISoldierMapper mapper = session.getMapper(SoldierMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<Soldier> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISoldierMapper mapper = session.getMapper(SoldierMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Soldier soldier) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISoldierMapper mapper = session.getMapper(SoldierMapper.class);
            mapper.insert(soldier);
            session.commit();
        }
    }

    @Override
    public void update(Soldier soldier) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISoldierMapper mapper = session.getMapper(SoldierMapper.class);
            mapper.update(soldier);
            session.commit();
        }
    }

    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISoldierMapper mapper = session.getMapper(SoldierMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

    public String findRankForSoldier(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISoldierMapper mapper = session.getMapper(SoldierMapper.class);
            return mapper.findRankForSoldier(id);
        }

    }

    @Override
    public String findBaseForSoldier(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISoldierMapper mapper = session.getMapper(SoldierMapper.class);
            return mapper.findBaseForSoldier(id);
        }
    }

    @Override
    public List<Soldier> findAllAliveSoldiers() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISoldierMapper mapper = session.getMapper(SoldierMapper.class);
            return mapper.findAllAliveSoldiers();
        }
    }

    @Override
    public List<Skill> findSkillsBySoldierId() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISoldierMapper mapper = session.getMapper(SoldierMapper.class);
            return mapper.findSkillsBySoldierId();
        }
    }

    @Override
    public List<Operation> findOperationsBySoldierId() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISoldierMapper mapper = session.getMapper(SoldierMapper.class);
            return mapper.findOperationsBySoldierId();
        }
    }

    @Override
    public List<Unit> findUnitsBySoldierId() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISoldierMapper mapper = session.getMapper(SoldierMapper.class);
            return mapper.findUnitsBySoldierId();
        }
    }
}


