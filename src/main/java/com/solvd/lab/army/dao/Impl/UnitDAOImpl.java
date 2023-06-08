package com.solvd.lab.army.dao.Impl;

import com.solvd.lab.army.dao.ICityDAO;
import com.solvd.lab.army.dao.IUnitDAO;
import com.solvd.lab.army.model.City;
import com.solvd.lab.army.model.Unit;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitDAOImpl implements IUnitDAO {
    private static final Logger logger = LogManager.getLogger(UnitDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE unit SET name = ?, unit_type = ?, soldier_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM unit WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM unit";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM unit WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO unit (id, name,unit_type,soldier_id) VALUES (?, ?,?,?)";

    private ConnectionPool connectionPool;
    private Connection connection;
    private PreparedStatement statement;

    public UnitDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    private Unit getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String unitType = resultSet.getString("unit_type");
        long soldierId = resultSet.getLong("soldier_id");
        return new Unit(id, name,unitType,soldierId);
    }


    @Override
    public Unit getById(int id) {
        Unit unit = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                unit = getDataFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return unit;
    }

    @Override
    public List<Unit> getAll() {
        List<Unit> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Unit unit = getDataFromResultSet(resultSet);
                list.add(unit);
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
    public void insert(Unit unit) {
        try {
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, unit.getId());
            statement.setString(2, unit.getName());
            statement.setString(3, unit.getUnitType());
            statement.setLong(4, unit.getSoldierId()); // Set the foreign key ID
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Unit unit) {
        try {
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, unit.getName());
            statement.setString(2, unit.getUnitType());
            statement.setLong(3, unit.getSoldierId()); // Set the foreign key ID
            statement.setLong(4, unit.getId());
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
