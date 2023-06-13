package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.IEquipmentDAO;
import com.solvd.lab.army.model.Equipment;
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

public class EquipmentDAOImpl implements IEquipmentDAO {
    private static final Logger logger = LogManager.getLogger(EquipmentDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE equipment SET name = ?, zip_code = ?, state_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM equipment WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM equipment";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM equipment WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO equipment (id,name,manufacturer,year_of_manufacture,quantity,equipment_type) VALUES (?, ?,?,?,?,?)";


    private ConnectionPool connectionPool;

    public EquipmentDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
    }

    private Equipment getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String manufacturer = resultSet.getString("manufacturer");
        String yearOfManufacture = resultSet.getString("year_of_manufacture");
        long quantity = resultSet.getLong("quantity");
        long equipmentTypeId = resultSet.getLong("equipment_type");
        return new Equipment(id,name,manufacturer,yearOfManufacture,quantity,equipmentTypeId) ;
    }


    @Override
    public Equipment getById(int id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Equipment equipment = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                equipment = getDataFromResultSet(resultSet);
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
        return equipment;
    }

    @Override
    public List<Equipment> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        List<Equipment> list = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Equipment equipment = getDataFromResultSet(resultSet);
                list.add(equipment);
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
    public void insert(Equipment equipment) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, equipment.getId());
            statement.setString(2, equipment.getName());
            statement.setString(3, equipment.getManufacturer());
            statement.setString(4, equipment.getYearOfManufacture());
            statement.setLong(5, equipment.getQuantity());
            statement.setLong(6, equipment.getEquipmentTypeId()); // Set the foreign key ID
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
    public void update(Equipment equipment) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, equipment.getName());
            statement.setString(2, equipment.getManufacturer());
            statement.setString(3, equipment.getYearOfManufacture());
            statement.setLong(4, equipment.getQuantity());
            statement.setLong(5, equipment.getEquipmentTypeId()); // Set the foreign key ID
            statement.setLong(6, equipment.getId());
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
    public void delete(int id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
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
