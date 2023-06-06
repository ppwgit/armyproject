package com.solvd.lab.army.database;

import com.solvd.lab.army.dao.Impl.SoldierDAOImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main1 {
    private static final Logger logger = LogManager.getLogger(Main1.class);

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            InputStream inputStream = Main1.class.getClassLoader().getResourceAsStream("database.properties");
            properties.load(inputStream);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            connection = DriverManager.getConnection(url, username, password);

            // Use the connection for database operations

        } catch (IOException e) {
            logger.error(e);
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            if (connection != null) {
                try {
                    System.out.print("Connect Success");
                    connection.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
    }
}