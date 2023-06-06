package com.solvd.lab.army.daoImpl;

import com.solvd.lab.army.database.DBConnectionManager;

import java.sql.*;

public class DAOClass {
    public void fetchData() {
        Connection connection = DBConnectionManager.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT id,first_name FROM soldier";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");

                System.out.println("ID: " + id + ", Name: " + firstName);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        DBConnectionManager.closeConnection();
    }
}