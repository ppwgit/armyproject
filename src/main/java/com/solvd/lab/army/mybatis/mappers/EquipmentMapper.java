package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.model.Equipment;
import com.solvd.lab.army.mybatis.IEquipmentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EquipmentMapper implements IEquipmentMapper {

    private SqlSessionFactory sqlSessionFactory;

    public EquipmentMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Equipment getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEquipmentMapper mapper = session.getMapper(EquipmentMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<Equipment> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEquipmentMapper mapper = session.getMapper(EquipmentMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Equipment equipment) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEquipmentMapper mapper = session.getMapper(EquipmentMapper.class);
            mapper.insert(equipment);
            session.commit();
        }
    }

    @Override
    public void update(Equipment equipment) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEquipmentMapper mapper = session.getMapper(EquipmentMapper.class);
            mapper.update(equipment);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEquipmentMapper mapper = session.getMapper(EquipmentMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


