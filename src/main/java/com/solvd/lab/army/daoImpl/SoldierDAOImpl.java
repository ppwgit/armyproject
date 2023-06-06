package com.solvd.lab.army.daoImpl;

import com.solvd.lab.army.InterfaceDAO.ISoldierDAO;
import com.solvd.lab.army.database.DBConnectionManager;
import com.solvd.lab.army.entity.Soldier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SoldierDAOImpl implements ISoldierDAO {
    private static final Logger logger = LogManager.getLogger(SoldierDAOImpl.class);
    private Connection connection;

    public SoldierDAOImpl() {

        connection = DBConnectionManager.getConnection();
    }



    @Override
    public List<Soldier> getAllSoldiers() {
            List<Soldier> soldierList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM soldier";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Date dateOfBirth = resultSet.getDate("date_of_birth");
                String gender = resultSet.getString("gender");
                String contactNumber = resultSet.getString("contact_number");
                String emergencyNumber = resultSet.getString("emergency_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String serviceStatus = resultSet.getString("service_status");
                String soldierStatus = resultSet.getString("soldier_status");

                Soldier soldier = new Soldier(id, firstName, lastName,dateOfBirth, gender, contactNumber,emergencyNumber,
                       email, address,serviceStatus ,soldierStatus   ) ;

                soldierList.add(soldier);
            }
           resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return soldierList;
    }


    @Override
    public void insert(Soldier soldier) {
        try {

            String query = "INSERT INTO mydb.soldier (first_name, last_name, date_of_birth, gender, contact_number, emergency_number, email, address, rank_id, role_id, base_id, service_status, soldier_status) VALUES (?, ?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, soldier.getFirstName());
            statement.setString(2, soldier.getLastName());
            statement.setDate(3, (java.sql.Date) soldier.getDateOfBirth());
            statement.setString(4, soldier.getGender());
            statement.setString(5, soldier.getContactNumber());
            statement.setString(6, soldier.getEmergencyNumber());
            statement.setString(7, soldier.getEmail());
            statement.setString(8, soldier.getAddress());
            statement.setInt(9, soldier.getRankId());
            statement.setInt(10, soldier.getRoleId());
            statement.setInt(11, soldier.getBaseId());
            statement.setString(12, soldier.getServiceStatus());
            statement.setString(13, soldier.getSoldierStatus());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Soldier soldier) {
        try {
            String query = "UPDATE soldier SET first_name = ?, email = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, soldier.getFirstName());
            statement.setString(2, soldier.getEmail());
            statement.setInt(3, soldier.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int soldierId) {
        try {
            String query = "DELETE FROM soldier WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, soldierId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Soldier getSoldierById(int soldierId) {
        Soldier soldier = null;

        try {
            String query = "SELECT * FROM soldier WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, soldierId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Date dateOfBirth = resultSet.getDate("date_of_birth");
                String gender = resultSet.getString("gender");
                String contactNumber = resultSet.getString("contact_number");
                String emergencyNumber = resultSet.getString("emergency_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String serviceStatus = resultSet.getString("service_status");
                String soldierStatus = resultSet.getString("soldier_status");

                soldier = new Soldier(firstName, lastName,dateOfBirth, gender, contactNumber,emergencyNumber,
                        email, address,serviceStatus ,soldierStatus   ) ;

            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return soldier;
    }

}



