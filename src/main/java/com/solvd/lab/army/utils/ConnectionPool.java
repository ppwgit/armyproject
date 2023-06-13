package com.solvd.lab.army.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static ConnectionPool instance;
    private static int POOL_SIZE = 5;
    private final BlockingQueue<Connection> connectionsQue;

    private ConnectionPool(int POOL_SIZE) {
        this.POOL_SIZE = POOL_SIZE;
        this.connectionsQue = new LinkedBlockingQueue<>(POOL_SIZE);
    }

    // what is best way to use between synchronized (ConnectionPool.class) and  public static synchronized?
    public synchronized static ConnectionPool getInstance() {
        if (instance == null) {
                    instance = new ConnectionPool(POOL_SIZE);
        }
        return instance;
    }

    public synchronized Connection getConnection() throws InterruptedException, IOException, SQLException, IOException, SQLException, ClassNotFoundException {
        Connection connection = connectionsQue.poll();
        if (connection == null) {
            if (connectionsQue.size() < POOL_SIZE) {
                Class.forName("com.mysql.jdbc.Driver");
                Properties properties = new Properties();
                InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream("database.properties");
                properties.load(input);

                String url = properties.getProperty("db.url");
                String username = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");
                connection = DriverManager.getConnection(url, username, password);
            } else {
                connection = connectionsQue.take();
            }
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            connectionsQue.offer(connection);
        }
    }
}