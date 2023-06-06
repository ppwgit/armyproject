package com.solvd.lab.army.database;

import java.sql.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//Test DB Connection Manager
public class MainClass {
    public static void main(String[] args) {
        Connection connection = DBConnectionManager.getConnection();

        if (connection != null) {
            System.out.println("Connected to the database!");
        }

        DBConnectionManager.closeConnection();
    }
}