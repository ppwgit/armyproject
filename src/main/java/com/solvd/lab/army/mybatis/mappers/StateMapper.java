package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.model.State;
import com.solvd.lab.army.mybatis.IStateMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StateMapper implements IStateMapper {

    private SqlSessionFactory sqlSessionFactory;

    public StateMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public State getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStateMapper mapper = session.getMapper(StateMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<State> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStateMapper mapper = session.getMapper(StateMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(State state) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStateMapper mapper = session.getMapper(StateMapper.class);
            mapper.insert(state);
            session.commit();
        }
    }

    @Override
    public void update(State state) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStateMapper mapper = session.getMapper(StateMapper.class);
            mapper.update(state);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStateMapper mapper = session.getMapper(StateMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


