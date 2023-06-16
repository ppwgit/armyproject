package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.IEquipmentTypeDAO;
import com.solvd.lab.army.model.EquipmentType;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
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


    public EquipmentTypeDAOImpl() {
        connectionPool = ConnectionPool.getInstance();

    }

    private EquipmentType getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new EquipmentType(id, name);
    }


    @Override
    public EquipmentType getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        EquipmentType equipmentType = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                equipmentType = getDataFromResultSet(resultSet);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            resultSet.close();
            statement.close();
            connectionPool.releaseConnection(connection);
        }
        return equipmentType;
    }

    @Override
    public List<EquipmentType> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        List<EquipmentType> list = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                EquipmentType equipmentType = getDataFromResultSet(resultSet);
                list.add(equipmentType);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            resultSet.close();
            statement.close();
            connectionPool.releaseConnection(connection);
        }
        return list;
    }

    @Override
    public void insert(EquipmentType equipmentType) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, equipmentType.getId());
            statement.setString(2, equipmentType.getName());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            statement.close();
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(EquipmentType equipmentType) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, equipmentType.getName());
            statement.setLong(2, equipmentType.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            statement.close();
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            statement.close();
            connectionPool.releaseConnection(connection);
        }
    }
}
