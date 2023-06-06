package com.solvd.lab.army.daoImpl;

import com.solvd.lab.army.InterfaceDAO.IRankTypeDAO;
import com.solvd.lab.army.InterfaceDAO.IRoleDAO;
import com.solvd.lab.army.database.DBConnectionManager;
import com.solvd.lab.army.entity.RankType;
import com.solvd.lab.army.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements IRoleDAO {
    private static final Logger logger = LogManager.getLogger(RoleDAOImpl.class);
    private Connection connection;

    public RoleDAOImpl() {

        connection = DBConnectionManager.getConnection();
    }

    @Override
    public void insert(Role role) {

        try {

            String query = "INSERT INTO role (name) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, role.getName());
            statement.setInt(2, role.getId());


            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Role role) {

        try {
            String query = "UPDATE role SET name = ?  WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, role.getName());
            statement.setInt(2, role.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int roleId) {

        try {
            String query = "DELETE FROM rank_type WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, roleId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roleList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM role";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                Role rankType = new Role(id, name) ;

                roleList.add(rankType);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roleList;
    }

    @Override
    public Role getRoleById(int roleId) {
        Role role = null;

        try {
            String query = "SELECT * FROM role WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, roleId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                role = new Role(name) ;

            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

}