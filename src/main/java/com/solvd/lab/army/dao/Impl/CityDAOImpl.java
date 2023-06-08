package com.solvd.lab.army.dao.Impl;

import com.solvd.lab.army.dao.ICityDAO;
import com.solvd.lab.army.dao.IStateDAO;
import com.solvd.lab.army.model.City;
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

public class CityDAOImpl implements ICityDAO {
    private static final Logger logger = LogManager.getLogger(CityDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE city SET name = ?, zip_code = ?, state_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM city WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM city";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM city WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO city (id, name,zip_code,state_id) VALUES (?, ?,?,?)";

    private ConnectionPool connectionPool;
    private Connection connection;
    private PreparedStatement statement;

    public CityDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    private City getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String zipCode = resultSet.getString("zip_code");
        long stateId = resultSet.getLong("state_id");
        return new City(id, name,zipCode,stateId);
    }


    @Override
    public City getById(int id) {
        City city = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                city = getDataFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return city;
    }

    @Override
    public List<City> getAll() {
        List<City> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                City city = getDataFromResultSet(resultSet);
                list.add(city);
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
    public void insert(City city) {
        try {
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, city.getId());
            statement.setString(2, city.getName());
            statement.setString(3, city.getZipCode());
            statement.setLong(4, city.getStateId()); // Set the foreign key ID
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(City city) {
        try {
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, city.getName());
            statement.setString(2, city.getZipCode());
            statement.setLong(3, city.getStateId()); // Set the foreign key ID
            statement.setLong(4, city.getId());
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
