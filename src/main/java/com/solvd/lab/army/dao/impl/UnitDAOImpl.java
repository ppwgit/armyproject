package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.IUnitDAO;
import com.solvd.lab.army.model.Operation;
import com.solvd.lab.army.model.Unit;
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

public class UnitDAOImpl implements IUnitDAO {
    private static final Logger logger = LogManager.getLogger(UnitDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE unit SET name = ?, unit_type = ?, soldier_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM unit WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM unit";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM unit WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO unit (id, name,unit_type,soldier_id) VALUES (?, ?,?,?)";
    private static final String SELECT_SOLDIER_UNITS = " SELECT u.* FROM mydb.unit AS u JOIN mydb.soldier AS s ON u.soldier_id = s.id WHERE soldier_id = ? ";

    private ConnectionPool connectionPool;

    public UnitDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
    }

    private Unit getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String unitType = resultSet.getString("unit_type");
        long soldierId = resultSet.getLong("soldier_id");
        return new Unit(id, name, unitType, soldierId);
    }


    @Override
    public Unit getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Unit unit = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                unit = getDataFromResultSet(resultSet);
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
        return unit;
    }

    @Override
    public List<Unit> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        List<Unit> list = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Unit unit = getDataFromResultSet(resultSet);
                list.add(unit);
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
    public void insert(Unit unit) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
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
            statement.close();
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Unit unit) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
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

    public List<Unit> findUnitsBySoldierId(long soldierId) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        List<Unit> units = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_SOLDIER_UNITS);
            statement.setLong(1, soldierId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Unit unit = getDataFromResultSet(resultSet);
                units.add(unit);
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
        return units;
}
}
