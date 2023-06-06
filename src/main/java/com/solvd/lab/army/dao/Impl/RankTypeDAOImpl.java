package com.solvd.lab.army.dao.Impl;

import com.solvd.lab.army.dao.IRankTypeDAO;
import com.solvd.lab.army.model.RankType;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RankTypeDAOImpl implements IRankTypeDAO {
    private static final Logger logger = LogManager.getLogger(RankTypeDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE rank_type SET name = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM rank_type WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM rank_type";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM rank_type WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO rank_type (id, name) VALUES (?, ?)";

    private ConnectionPool connectionPool;
    private Connection connection;
    private PreparedStatement statement;

    public RankTypeDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    private RankType getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new RankType(id, name);
    }


    @Override
    public RankType getById(int id) {
        RankType rankType = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                rankType = getDataFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return rankType;
    }

    @Override
    public List<RankType> getAll() {
        List<RankType> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                RankType rankType = getDataFromResultSet(resultSet);
                list.add(rankType);
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
    public void insert(RankType rankType) {
        try {
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, rankType.getId());
            statement.setString(2, rankType.getName());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(RankType rankType) {
        try {
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, rankType.getName());
            statement.setLong(2, rankType.getId());
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