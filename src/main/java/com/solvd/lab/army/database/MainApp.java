package com.solvd.lab.army.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://127.0.0.1:3306/mydb";
        String username = "root";
        String password = "Root@1902";
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb",
                    "root", "Root@1902");
            System.out.println("Success to connect to the database.");
            connection.close();
        }
        catch (Exception exception) {
            System.out.println("Failed to connect to the database.");
            System.out.println(exception);
        }
    } // function ends
} // class ends

