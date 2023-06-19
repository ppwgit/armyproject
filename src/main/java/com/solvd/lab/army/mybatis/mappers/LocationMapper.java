package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.model.City;
import com.solvd.lab.army.model.Location;
import com.solvd.lab.army.mybatis.ILocationMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LocationMapper implements ILocationMapper {

    private SqlSessionFactory sqlSessionFactory;

    public LocationMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Location getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILocationMapper mapper = session.getMapper(LocationMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<Location> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILocationMapper mapper = session.getMapper(LocationMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Location location) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILocationMapper mapper = session.getMapper(LocationMapper.class);
            mapper.insert(location);
            session.commit();
        }
    }

    @Override
    public void update(Location location) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILocationMapper mapper = session.getMapper(LocationMapper.class);
            mapper.update(location);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILocationMapper mapper = session.getMapper(LocationMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


