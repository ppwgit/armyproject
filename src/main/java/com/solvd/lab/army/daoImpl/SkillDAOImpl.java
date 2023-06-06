package com.solvd.lab.army.daoImpl;

import com.solvd.lab.army.InterfaceDAO.IRankTypeDAO;
import com.solvd.lab.army.InterfaceDAO.ISkillDAO;
import com.solvd.lab.army.database.DBConnectionManager;
import com.solvd.lab.army.entity.RankType;
import com.solvd.lab.army.entity.Skill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAOImpl implements ISkillDAO {
    private static final Logger logger = LogManager.getLogger(SkillDAOImpl.class);
    private Connection connection;

    public SkillDAOImpl() {

        connection = DBConnectionManager.getConnection();
    }

    @Override
    public void insert(Skill skill) {

        try {

            String query = "INSERT INTO skill (name, description) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, skill.getName());
            statement.setString(2, skill.getDescription());
            statement.setInt(3, skill.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Skill skill) {

        try {
            String query = "UPDATE skill SET name, description = ?  WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, skill.getName());
            statement.setString(2, skill.getDescription());
            statement.setInt(3, skill.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int skillId) {

        try {
            String query = "DELETE FROM skill WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, skillId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Skill> getAllSkills() {
        List<Skill> skillList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM skill";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Skill skill = new Skill(id, name,description) ;

                skillList.add(skill);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skillList;
    }

    @Override
    public Skill getSkillById(int skillId) {
        Skill skill = null;

        try {
            String query = "SELECT * FROM skill WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, skillId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                skill = new Skill(name,description ) ;

            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skill;
    }

}