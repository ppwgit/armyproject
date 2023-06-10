package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.ICountryDAO;
import com.solvd.lab.army.model.Country;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOImpl implements ICountryDAO {
    private static final Logger logger = LogManager.getLogger(CountryDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE country SET name = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM country WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM country";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM country WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO country (id, name) VALUES (?, ?)";

    private ConnectionPool connectionPool;

    public CountryDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
    }

    private Country getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new Country(id, name);
    }


    @Override
    public Country getById(int id) {
        Country country = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                country = getDataFromResultSet(resultSet);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return country;
    }

    @Override
    public List<Country> getAll() {
        List<Country> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Country country = getDataFromResultSet(resultSet);
                list.add(country);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return list;
    }

    @Override
    public void insert(Country country) {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, country.getId());
            statement.setString(2, country.getName());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Country country) {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, country.getName());
            statement.setLong(2, country.getId());
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
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
    public Country findStatebyCountryId(int id) {
        Country country = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                country = getDataFromResultSet(resultSet);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return country;
    }
}
