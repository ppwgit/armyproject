package com.solvd.lab.army;

import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArmyApp {
    private static final Logger logger = LogManager.getLogger(ArmyApp.class);

    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        connectionPool.createConnections(5);

        Connection connection = connectionPool.getConnection();

        try {

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM soldier";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("first_name");
                String email = resultSet.getString("email");
                // Process the retrieved data
                System.out.println("Firstname: " + name + ", Email: " + email);
            }
        } catch (SQLException e) {
           logger.error(e);
        } finally {

            connectionPool.releaseConnection(connection);

        }
    }
}



