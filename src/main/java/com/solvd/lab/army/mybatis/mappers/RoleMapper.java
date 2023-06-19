package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.model.Role;
import com.solvd.lab.army.mybatis.IRoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoleMapper implements IRoleMapper {

    private SqlSessionFactory sqlSessionFactory;

    public RoleMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Role getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRoleMapper mapper = session.getMapper(RoleMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<Role> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRoleMapper mapper = session.getMapper(RoleMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Role role) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRoleMapper mapper = session.getMapper(RoleMapper.class);
            mapper.insert(role);
            session.commit();
        }
    }

    @Override
    public void update(Role role) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRoleMapper mapper = session.getMapper(RoleMapper.class);
            mapper.update(role);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRoleMapper mapper = session.getMapper(RoleMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


