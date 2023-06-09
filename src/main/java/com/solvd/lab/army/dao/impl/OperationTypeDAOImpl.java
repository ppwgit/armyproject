package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.IOperationTypeDAO;
import com.solvd.lab.army.model.OperationType;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationTypeDAOImpl implements IOperationTypeDAO {
    private static final Logger logger = LogManager.getLogger(OperationTypeDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE operation_type SET name = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM operation_type WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM operation_type";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM operation_type WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO operation_type (id, name) VALUES (?, ?)";

    private ConnectionPool connectionPool;
    private Connection connection;
    private PreparedStatement statement;

    public OperationTypeDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    private OperationType getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new OperationType(id, name);
    }


    @Override
    public OperationType getById(int id) {
        OperationType operationType = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                operationType = getDataFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return operationType;
    }

    @Override
    public List<OperationType> getAll() {
        List<OperationType> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                OperationType operationType = getDataFromResultSet(resultSet);
                list.add(operationType);
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
    public void insert(OperationType operationType) {
        try {
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, operationType.getId());
            statement.setString(2, operationType.getName());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(OperationType operationType) {
        try {
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, operationType.getName());
            statement.setLong(2, operationType.getId());
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
