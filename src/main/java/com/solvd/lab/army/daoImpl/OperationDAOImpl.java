package com.solvd.lab.army.daoImpl;

import com.solvd.lab.army.InterfaceDAO.IOperationDAO;
import com.solvd.lab.army.InterfaceDAO.IRankTypeDAO;
import com.solvd.lab.army.database.DBConnectionManager;
import com.solvd.lab.army.entity.Operation;
import com.solvd.lab.army.entity.RankType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationDAOImpl implements IOperationDAO {
    private static final Logger logger = LogManager.getLogger(OperationDAOImpl.class);
    private Connection connection;

    public OperationDAOImpl() {

        connection = DBConnectionManager.getConnection();
    }

    @Override
    public void insert(Operation operation) {

        try {

            String query = "INSERT INTO mydb.operation(name, start_date, end_date, location, operation_type_id) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, operation.getName());
            statement.setDate(2, (java.sql.Date) operation.getStartDate());
            statement.setDate(3, (java.sql.Date) operation.getEndDate());
            statement.setInt(4, operation.getOperationTypeId());
            statement.setInt(5, operation.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Operation operation) {

        try {
            String query = "UPDATE operation SET name = ?  WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, operation.getName());
            statement.setDate(2, (java.sql.Date) operation.getStartDate());
            statement.setDate(3, (java.sql.Date) operation.getEndDate());
            statement.setInt(4, operation.getOperationTypeId());
            statement.setInt(5, operation.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int operationId) {

        try {
            String query = "DELETE FROM operation WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, operationId);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Operation> getAllOperations() {
        List<Operation> operationList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM operation";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");
                Integer operationTypeId = resultSet.getInt("operation_type_id");

                Operation operation = new Operation(id, name,startDate,endDate,operationTypeId) ;

                operationList.add(operation);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return operationList;
    }

    @Override
    public Operation getOperationById(int operationId) {
        Operation operation = null;

        try {
            String query = "SELECT * FROM operation WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, operationId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");
                Integer operationTypeId = resultSet.getInt("operation_type_id");

                operation = new Operation(name,startDate,endDate,operationTypeId) ;

            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return operation;
    }

}