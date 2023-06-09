package com.solvd.lab.army.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager {
    private static final Logger logger = LogManager.getLogger(DBConnectionManager.class);
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties properties = new Properties();
                InputStream inputStream = DBConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");
                properties.load(inputStream);

                String driverClassName = properties.getProperty("db.driverClassName");
                String url = properties.getProperty("db.url");
                String username = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");

                Class.forName(driverClassName);
                connection = DriverManager.getConnection(url, username, password);
            } catch (IOException | ClassNotFoundException | SQLException e) {
                logger.error(e);
                logger.error(e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }
}






