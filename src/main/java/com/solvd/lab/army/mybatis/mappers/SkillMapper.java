package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.dao.ISkillDAO;
import com.solvd.lab.army.model.Skill;
import com.solvd.lab.army.mybatis.ISkillMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SkillMapper implements ISkillDAO {

    private SqlSessionFactory sqlSessionFactory;

    public SkillMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Skill getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISkillDAO mapper = session.getMapper(SkillMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<Skill> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISkillDAO mapper = session.getMapper(SkillMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Skill skill) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISkillDAO mapper = session.getMapper(SkillMapper.class);
            mapper.insert(skill);
            session.commit();
        }
    }

    @Override
    public void update(Skill skill) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISkillDAO mapper = session.getMapper(SkillMapper.class);
            mapper.update(skill);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ISkillDAO mapper = session.getMapper(SkillMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


