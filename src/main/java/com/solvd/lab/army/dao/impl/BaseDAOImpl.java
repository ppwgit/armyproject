package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.IBaseDAO;
import com.solvd.lab.army.model.Base;
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

public class BaseDAOImpl implements IBaseDAO  {
    private static final Logger logger = LogManager.getLogger(BaseDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE base SET name = ?, geography = ?, location_id = ? ,contact_number = ?, email = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM base WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM base";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM base WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO base(id, name,geography,location_id,contact_number,email) VALUES (?, ?,?,?,?,?)";

    private ConnectionPool connectionPool;

    public BaseDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
    }

    private Base getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String geography = resultSet.getString("geography");
        String contactNumber = resultSet.getString("contact_number");
        String email = resultSet.getString("email");
        long locationId = resultSet.getLong("location_id");
        return new Base(id, name,geography,locationId,contactNumber,email);
    }


    @Override
    public Base getById(int id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Base base = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                base = getDataFromResultSet(resultSet);
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
        return base;
    }

    @Override
    public List<Base> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        List<Base> list = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Base base = getDataFromResultSet(resultSet);
                list.add(base);
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
    public void insert(Base base) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, base.getId());
            statement.setString(2, base.getName());
            statement.setString(3, base.getGeography());
            statement.setString(4, base.getContactNumber());
            statement.setString(5, base.getEmail());
            statement.setLong(6, base.getLocationId()); // Set the foreign key ID

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
    public void update(Base base) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, base.getName());
            statement.setString(2, base.getGeography());
            statement.setString(3, base.getContactNumber());
            statement.setString(4, base.getEmail());
            statement.setLong(5, base.getLocationId());
            statement.setLong(6, base.getId());
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
