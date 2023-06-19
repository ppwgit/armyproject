package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.model.Operation;
import com.solvd.lab.army.mybatis.IOperationMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OperationMapper implements IOperationMapper {

    private SqlSessionFactory sqlSessionFactory;

    public OperationMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Operation getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOperationMapper mapper = session.getMapper(OperationMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<Operation> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOperationMapper mapper = session.getMapper(OperationMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Operation operation) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOperationMapper mapper = session.getMapper(OperationMapper.class);
            mapper.insert(operation);
            session.commit();
        }
    }

    @Override
    public void update(Operation operation) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOperationMapper mapper = session.getMapper(OperationMapper.class);
            mapper.update(operation);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOperationMapper mapper = session.getMapper(OperationMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


