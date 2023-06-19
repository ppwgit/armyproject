package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.model.Operation;
import com.solvd.lab.army.model.OperationType;
import com.solvd.lab.army.mybatis.IOperationTypeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OperationTypeMapper implements IOperationTypeMapper {

    private SqlSessionFactory sqlSessionFactory;

    public OperationTypeMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public OperationType getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOperationTypeMapper mapper = session.getMapper(OperationTypeMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<OperationType> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOperationTypeMapper mapper = session.getMapper(OperationTypeMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(OperationType operationType) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOperationTypeMapper mapper = session.getMapper(OperationTypeMapper.class);
            mapper.insert(operationType);
            session.commit();
        }
    }

    @Override
    public void update(OperationType operationType) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOperationTypeMapper mapper = session.getMapper(OperationTypeMapper.class);
            mapper.update(operationType);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOperationTypeMapper mapper = session.getMapper(OperationTypeMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


