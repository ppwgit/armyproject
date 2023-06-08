package com.solvd.lab.army.dao.Impl;

import com.solvd.lab.army.dao.IRankDAO;
import com.solvd.lab.army.dao.IStateDAO;
import com.solvd.lab.army.model.Rank;
import com.solvd.lab.army.model.State;
import com.solvd.lab.army.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateDAOImpl implements IStateDAO {
    private static final Logger logger = LogManager.getLogger(StateDAOImpl.class);
    private static final String UPDATE_QUERY = "UPDATE state SET name = ?, country_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM state WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM state";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM state WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO state (id, name,country_id) VALUES (?, ?,?)";

    private ConnectionPool connectionPool;
    private Connection connection;
    private PreparedStatement statement;

    public StateDAOImpl() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    private State getDataFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        long countryId = resultSet.getLong("country_id");
        return new State(id, name,countryId);
    }


    @Override
    public State getById(int id) {
        State state = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                state = getDataFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return state;
    }

    @Override
    public List<State> getAll() {
        List<State> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                State state = getDataFromResultSet(resultSet);
                list.add(state);
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
    public void insert(State state) {
        try {
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, state.getId());
            statement.setString(2, state.getName());
            statement.setLong(3, state.getCountryId()); // Set the foreign key ID
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(State state) {
        try {
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, state.getName());
            statement.setLong(2, state.getCountryId()); // Update the foreign key ID
            statement.setLong(3, state.getId());
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
