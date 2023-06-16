package com.solvd.lab.army.dao.impl;

import com.solvd.lab.army.dao.IRankDAO;
import com.solvd.lab.army.model.Rank;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RankDAOImpl implements IRankDAO {
    private static final Logger logger = LogManager.getLogger(RankDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE rank SET name = ?, rank_type_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM rank WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM rank";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM rank WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO rank (id, name,rank_type_id) VALUES (?, ?,?)";

    private ConnectionPool connectionPool;

    public RankDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
    }

    private Rank getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        long rankTypeId = resultSet.getLong("rank_type_id");
        return new Rank(id, name,rankTypeId);
    }


    @Override
    public Rank getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Rank rank = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                rank = getDataFromResultSet(resultSet);
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
        return rank;
    }

    @Override
    public List<Rank> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        List<Rank> list = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Rank rank = getDataFromResultSet(resultSet);
                list.add(rank);
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
    public void insert(Rank rank) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, rank.getId());
            statement.setString(2, rank.getName());
            statement.setLong(3, rank.getRankTypeId()); // Set the foreign key ID
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
    public void update(Rank rank) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, rank.getName());
            statement.setLong(2, rank.getRankTypeId()); // Update the foreign key ID
            statement.setLong(3, rank.getId());
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
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException {
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
