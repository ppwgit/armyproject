package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.ISkillDAO;
import com.solvd.lab.army.model.Skill;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAOImpl implements ISkillDAO {
    private static final Logger logger = LogManager.getLogger(SkillDAOImpl.class);

    private static final String UPDATE_QUERY = "UPDATE skill SET name = ?, description = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM skill WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM skill";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM skill WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO skill (id, name,description) VALUES (?, ?,?)";

    private ConnectionPool connectionPool;

    public SkillDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
    }

    private Skill getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        return new Skill(id, name,description);
    }

    @Override
    public Skill getById(int id) {
        Skill skill = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                skill = getDataFromResultSet(resultSet);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return skill;
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Skill skill = getDataFromResultSet(resultSet);
                list.add(skill);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return list;
    }

    @Override
    public void insert(Skill skill) {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, skill.getId());
            statement.setString(2, skill.getName());
            statement.setString(3, skill.getDescription());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Skill skill) {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, skill.getName());
            statement.setString(2, skill.getDescription());
            statement.setLong(3, skill.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
