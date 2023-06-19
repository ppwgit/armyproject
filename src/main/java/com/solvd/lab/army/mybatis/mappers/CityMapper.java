package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.model.City;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.mybatis.ICityMapper;
import com.solvd.lab.army.mybatis.ISoldierMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CityMapper implements ICityMapper {

    private SqlSessionFactory sqlSessionFactory;

    public CityMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public City getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICityMapper mapper = session.getMapper(CityMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<City> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICityMapper mapper = session.getMapper(CityMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(City city) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICityMapper mapper = session.getMapper(CityMapper.class);
            mapper.insert(city);
            session.commit();
        }
    }

    @Override
    public void update(City city) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICityMapper mapper = session.getMapper(CityMapper.class);
            mapper.update(city);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICityMapper mapper = session.getMapper(CityMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


