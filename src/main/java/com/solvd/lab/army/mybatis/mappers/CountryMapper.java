package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.dao.ICountryDAO;
import com.solvd.lab.army.model.Country;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CountryMapper implements ICountryDAO {

    private SqlSessionFactory sqlSessionFactory;

    public CountryMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Country getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICountryDAO mapper = session.getMapper(CountryMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<Country> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICountryDAO mapper = session.getMapper(CountryMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Country country) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICountryDAO mapper = session.getMapper(CountryMapper.class);
            mapper.insert(country);
            session.commit();
        }
    }

    @Override
    public void update(Country country) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICountryDAO mapper = session.getMapper(CountryMapper.class);
            mapper.update(country);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICountryDAO mapper = session.getMapper(CountryMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }
}


