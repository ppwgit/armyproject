package com.solvd.lab.army.mybatis.mappers;

import com.solvd.lab.army.dao.IEquipmentTypeDAO;
import com.solvd.lab.army.model.EquipmentType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EquipmentTypeMapper implements IEquipmentTypeDAO {

    private SqlSessionFactory sqlSessionFactory;

    public EquipmentTypeMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public EquipmentType getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEquipmentTypeDAO mapper = session.getMapper(EquipmentTypeMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<EquipmentType> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEquipmentTypeDAO mapper = session.getMapper(EquipmentTypeMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(EquipmentType equipmentType) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEquipmentTypeDAO mapper = session.getMapper(EquipmentTypeMapper.class);
            mapper.insert(equipmentType);
            session.commit();
        }
    }

    @Override
    public void update(EquipmentType equipmentType) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEquipmentTypeDAO mapper = session.getMapper(EquipmentTypeMapper.class);
            mapper.update(equipmentType);
            session.commit();
        }
    }


    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEquipmentTypeDAO mapper = session.getMapper(EquipmentTypeMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }

}


