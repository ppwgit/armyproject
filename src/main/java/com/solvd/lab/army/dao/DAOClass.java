package com.solvd.lab.army.dao;

import com.solvd.lab.army.dao.Impl.SoldierDAOImpl;
import com.solvd.lab.army.database.DBConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DAOClass {
    private static final Logger logger = LogManager.getLogger(DAOClass.class);

    public void fetchData() {
        Connection connection = DBConnectionManager.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT id,first_name FROM soldier";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");

                System.out.println("ID: " + id + ", Name: " + firstName);

            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        DBConnectionManager.closeConnection();
    }
}