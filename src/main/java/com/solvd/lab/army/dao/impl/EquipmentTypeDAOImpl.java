package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.IEquipmentTypeDAO;
import com.solvd.lab.army.model.EquipmentType;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentTypeDAOImpl implements IEquipmentTypeDAO {
    private static final Logger logger = LogManager.getLogger(EquipmentTypeDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE equipment_type SET name = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM equipment_type WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM equipment_type";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM equipment_type WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO equipment_type (id, name) VALUES (?, ?)";

    private ConnectionPool connectionPool;
    private Connection connection;
    private PreparedStatement statement;

    public EquipmentTypeDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    private EquipmentType getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new EquipmentType(id, name);
    }


    @Override
    public EquipmentType getById(int id) {
        EquipmentType equipmentType = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                equipmentType = getDataFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return equipmentType;
    }

    @Override
    public List<EquipmentType> getAll() {
        List<EquipmentType> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                EquipmentType equipmentType = getDataFromResultSet(resultSet);
                list.add(equipmentType);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return list;
    }

    @Override
    public void insert(EquipmentType equipmentType) {
        try {
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, equipmentType.getId());
            statement.setString(2, equipmentType.getName());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(EquipmentType equipmentType) {
        try {
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, equipmentType.getName());
            statement.setLong(2, equipmentType.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        try {
            statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
