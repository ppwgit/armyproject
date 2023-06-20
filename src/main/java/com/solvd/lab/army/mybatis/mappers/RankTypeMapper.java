package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.dao.IRankTypeDAO;
import com.solvd.lab.army.model.RankType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RankTypeMapper implements IRankTypeDAO {

    private SqlSessionFactory sqlSessionFactory;

    public RankTypeMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public RankType getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRankTypeDAO mapper = session.getMapper(RankTypeMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<RankType> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRankTypeDAO mapper = session.getMapper(RankTypeMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(RankType rankType) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRankTypeDAO mapper = session.getMapper(RankTypeMapper.class);
            mapper.insert(rankType);
            session.commit();
        }
    }

    @Override
    public void update(RankType rankType) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRankTypeDAO mapper = session.getMapper(RankTypeMapper.class);
            mapper.update(rankType);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRankTypeDAO mapper = session.getMapper(RankTypeMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


