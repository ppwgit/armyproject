package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.ILocationDAO;
import com.solvd.lab.army.model.Location;
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

public class LocationDAOImpl implements ILocationDAO {
    private static final Logger logger = LogManager.getLogger(LocationDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE location SET address = ?, city_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM location WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM location";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM location WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO state (id, address,city_id) VALUES (?, ?,?)";

    private ConnectionPool connectionPool;

    public LocationDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
    }

    private Location getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String address = resultSet.getString("address");
        long cityId = resultSet.getLong("city_id");
        return new Location(id, address,cityId);
    }


    @Override
    public Location getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Location location = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                location = getDataFromResultSet(resultSet);
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
        return location;
    }

    @Override
    public List<Location> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        List<Location> list = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Location location = getDataFromResultSet(resultSet);
                list.add(location);
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
    public void insert(Location location) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, location.getId());
            statement.setString(2, location.getAddress());
            statement.setLong(3, location.getCityId()); // Set the foreign key ID
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
    public void update(Location location) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, location.getAddress());
            statement.setLong(2, location.getCityId()); // Update the foreign key ID
            statement.setLong(3, location.getId());
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
