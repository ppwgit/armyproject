package com.solvd.lab.army.dao.Impl;

import com.solvd.lab.army.dao.ILocationDAO;
import com.solvd.lab.army.dao.IStateDAO;
import com.solvd.lab.army.model.Location;
import com.solvd.lab.army.model.State;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private Connection connection;
    private PreparedStatement statement;

    public LocationDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    private Location getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String address = resultSet.getString("address");
        long cityId = resultSet.getLong("city_id");
        return new Location(id, address,cityId);
    }


    @Override
    public Location getById(int id) {
        Location location = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                location = getDataFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return location;
    }

    @Override
    public List<Location> getAll() {
        List<Location> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Location location = getDataFromResultSet(resultSet);
                list.add(location);
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
    public void insert(Location location) {
        try {
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, location.getId());
            statement.setString(2, location.getAddress());
            statement.setLong(3, location.getCityId()); // Set the foreign key ID
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Location location) {
        try {
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, location.getAddress());
            statement.setLong(2, location.getCityId()); // Update the foreign key ID
            statement.setLong(3, location.getId());
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
