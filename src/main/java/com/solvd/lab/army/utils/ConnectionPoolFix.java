package com.solvd.lab.army.utils;

import com.solvd.lab.army.dao.Impl.SoldierDAOImpl;
import com.solvd.lab.army.database.DBConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPoolFix {
    private static final Logger logger = LogManager.getLogger(ConnectionPoolFix.class);

    private static ConnectionPoolFix instance;
    private List<Connection> connections;

    private ConnectionPoolFix() {
        connections = new ArrayList<>();
    }

    public static synchronized ConnectionPoolFix getInstance() {
        if (instance == null) {
            instance = new ConnectionPoolFix();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        while (connections.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }

        return connections.remove(connections.size() - 1);
    }

    public synchronized void releaseConnection(Connection connection) {
        connections.add(connection);
        notifyAll();
    }

    public synchronized void createConnections(int numConnections) {
        for (int i = 0; i < numConnections; i++) {
            try {
                Connection connection = createConnection();
                connections.add(connection);
            } catch (SQLException | IOException e) {
                logger.error(e);
            }
        }
    }

    private Connection createConnection() throws SQLException, IOException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }

        Properties properties = new Properties();
        InputStream inputStream = DBConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");
        properties.load(inputStream);

         String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, username, password);
    }
}