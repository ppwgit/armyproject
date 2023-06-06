package com.solvd.lab.army.dao.Impl;

import com.solvd.lab.army.dao.IRankDAO;
import com.solvd.lab.army.dao.IRoleDAO;
import com.solvd.lab.army.database.DBConnectionManager;
import com.solvd.lab.army.model.RankType;
import com.solvd.lab.army.model.Role;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements IRoleDAO {
    private static final Logger logger = LogManager.getLogger(RoleDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE role SET name = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM role WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM role";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM role WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO role (id, name) VALUES (?, ?)";

    private ConnectionPool connectionPool;
    private Connection connection;
    private PreparedStatement statement;

    public RoleDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    private Role getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new Role(id, name);
    }


    @Override
    public Role getById(int id) {
        Role role = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                role = getDataFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return role;
    }

    @Override
    public List<Role> getAll() {
        List<Role> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Role role = getDataFromResultSet(resultSet);
                list.add(role);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return list;
    }

    @Override
    public void insert(Role role) {
        try {
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, role.getId());
            statement.setString(2, role.getName());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Role role) {
        try {
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, role.getName());
            statement.setLong(2, role.getId());
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
        try {
            statement = connection.prepareStatement(DELETE_QUERY);
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
