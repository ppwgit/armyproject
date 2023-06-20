package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.dao.IRankDAO;
import com.solvd.lab.army.model.Rank;
import com.solvd.lab.army.mybatis.IRankMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RankMapper implements IRankDAO {

    private SqlSessionFactory sqlSessionFactory;

    public RankMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Rank getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRankDAO mapper = session.getMapper(RankMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<Rank> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRankDAO mapper = session.getMapper(RankMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Rank rank) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRankDAO mapper = session.getMapper(RankMapper.class);
            mapper.insert(rank);
            session.commit();
        }
    }

    @Override
    public void update(Rank rank) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRankDAO mapper = session.getMapper(RankMapper.class);
            mapper.update(rank);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRankDAO mapper = session.getMapper(RankMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


