package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.model.Unit;
import com.solvd.lab.army.mybatis.IUnitMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UnitMapper implements IUnitMapper {

    private SqlSessionFactory sqlSessionFactory;

    public UnitMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Unit getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IUnitMapper mapper = session.getMapper(UnitMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<Unit> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IUnitMapper mapper = session.getMapper(UnitMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Unit unit) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IUnitMapper mapper = session.getMapper(UnitMapper.class);
            mapper.insert(unit);
            session.commit();
        }
    }

    @Override
    public void update(Unit unit) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IUnitMapper mapper = session.getMapper(UnitMapper.class);
            mapper.update(unit);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IUnitMapper mapper = session.getMapper(UnitMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


