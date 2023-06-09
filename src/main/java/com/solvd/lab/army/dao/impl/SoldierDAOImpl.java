package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.ISoldierDAO;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SoldierDAOImpl implements ISoldierDAO {
    private static final Logger logger = LogManager.getLogger(SoldierDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE soldier SET first_name = ?, last_name = ?, date_of_birth = ? , gender = ?, contact_number = ?, emergency_number = ?, email = ?, address = ?, rankId = ?, role_id = ?, base_id = ?, service_status = ?,soldier_status = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM soldier WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM soldier";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM soldier WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO soldier (id, first_name , last_name , date_of_birth  , gender , contact_number , emergency_number , email , address , rankId , role_id , base_id , service_status ,soldier_status ) VALUES (?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private ConnectionPool connectionPool;
    private Connection connection;
    private PreparedStatement statement;

    public SoldierDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    private Soldier getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        Date dateOfBirth = resultSet.getDate("date_of_birth");
        String gender = resultSet.getString("gender");
        String contactNumber = resultSet.getString("contact_number");
        String emergencyNumber = resultSet.getString("emergency_number");
        String email = resultSet.getString("email");
        String address = resultSet.getString("address");
        long rankId = resultSet.getLong("rank_id");
        long roleId = resultSet.getLong("role_id");
        long baseId = resultSet.getLong("base_id");
        String serviceStatus = resultSet.getString("service_status");
        String soldierStatus = resultSet.getString("soldier_status");

        return new Soldier(id, firstName , lastName , dateOfBirth  , gender , contactNumber , emergencyNumber , email , address , rankId , roleId , baseId , serviceStatus , serviceStatus, soldierStatus );
    }


    @Override
    public Soldier getById(int id) {
        Soldier soldier = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                soldier = getDataFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return soldier;
    }

    @Override
    public List<Soldier> getAll() {
        List<Soldier> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Soldier soldier = getDataFromResultSet(resultSet);
                list.add(soldier);
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
    public void insert(Soldier soldier) {
        try {
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, soldier.getId());
            statement.setString(2, soldier.getFirstName());
            statement.setString(3, soldier.getLastName());
            statement.setString(4, soldier.getLastName());
            statement.setDate(5, (java.sql.Date) soldier.getDateOfBirth()); // Set the foreign key ID
            statement.setString(6, soldier.getGender());
            statement.setString(7, soldier.getContactNumber());
            statement.setString(8, soldier.getEmergencyNumber());
            statement.setString(9, soldier.getEmail());
            statement.setString(10, soldier.getAddress());
            statement.setLong(11, soldier.getRankId());
            statement.setLong(12, soldier.getRoleId());
            statement.setLong(13, soldier.getBaseId());
            statement.setString(14, soldier.getServiceStatus());
            statement.setString(15, soldier.getSoldierStatus());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Soldier soldier) {
        try {
            statement = connection.prepareStatement(UPDATE_QUERY);

            statement.setString(1, soldier.getFirstName());
            statement.setString(2, soldier.getLastName());
            statement.setString(3, soldier.getLastName());
            statement.setDate(4, (java.sql.Date) soldier.getDateOfBirth()); // Set the foreign key ID
            statement.setString(5, soldier.getGender());
            statement.setString(6, soldier.getContactNumber());
            statement.setString(7, soldier.getEmergencyNumber());
            statement.setString(8, soldier.getEmail());
            statement.setString(9, soldier.getAddress());
            statement.setLong(10, soldier.getRankId());
            statement.setLong(11, soldier.getRoleId());
            statement.setLong(12, soldier.getBaseId());
            statement.setString(13, soldier.getServiceStatus());
            statement.setString(14, soldier.getSoldierStatus());
            statement.setLong(15, soldier.getId());
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
