package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.IRankTypeDAO;
import com.solvd.lab.army.model.RankType;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
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

    public RankTypeDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
    }

    private RankType getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new RankType(id, name);
    }


    @Override
    public RankType getById(int id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        RankType rankType = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                rankType = getDataFromResultSet(resultSet);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            resultSet.close();
            statement.close();
            connectionPool.releaseConnection(connection);
        }
        return rankType;
    }

    @Override
    public List<RankType> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        List<RankType> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                RankType rankType = getDataFromResultSet(resultSet);
                list.add(rankType);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            resultSet.close();
            statement.close();
            connectionPool.releaseConnection(connection);
        }
        return list;
    }

    @Override
    public void insert(RankType rankType) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, rankType.getId());
            statement.setString(2, rankType.getName());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            statement.close();
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(RankType rankType) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, rankType.getName());
            statement.setLong(2, rankType.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            statement.close();
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            statement.close();
            connectionPool.releaseConnection(connection);
        }
    }
}
