package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.IOperationDAO;
import com.solvd.lab.army.model.Operation;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationDAOImpl implements  IOperationDAO{
    private static final Logger logger = LogManager.getLogger(OperationDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE operation SET name = ?, zip_code = ?, state_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM operation WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM operation";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM operation WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO operation (id, name,start_date,end_date,location,operation_type_id) VALUES (?, ?,?,?,?,?)";

    private ConnectionPool connectionPool;
    private Connection connection;
    private PreparedStatement statement;

    public OperationDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    private Operation getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        Date startDate = resultSet.getDate("start_date");
        Date endDate = resultSet.getDate("end_date");
        String location = resultSet.getString("location");
        long operationTypeId = resultSet.getLong("operation_type_id");

        return new Operation(id, name,startDate,endDate,location,operationTypeId);
    }


    @Override
    public Operation getById(int id) {
        Operation operation = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                operation = getDataFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return operation;
    }

    @Override
    public List<Operation> getAll() {
        List<Operation> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Operation operation = getDataFromResultSet(resultSet);
                list.add(operation);
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
    public void insert(Operation operation) {
        try {
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, operation.getId());
            statement.setString(2, operation.getName());
            statement.setDate(3, (java.sql.Date) operation.getStartDate());
            statement.setDate(4, (java.sql.Date) operation.getEndDate());
            statement.setString(5, operation.getLocation());
            statement.setLong(6, operation.getOperationTypeId()); // Set the foreign key ID

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Operation operation) {
        try {
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, operation.getName());
            statement.setDate(2, (java.sql.Date) operation.getStartDate());
            statement.setDate(3, (java.sql.Date) operation.getEndDate());
            statement.setString(4, operation.getLocation());
            statement.setLong(5, operation.getOperationTypeId()); // Set the foreign key ID
            statement.setLong(6, operation.getId());
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
