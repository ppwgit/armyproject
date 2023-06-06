package com.solvd.lab.army.daoImpl;

import com.solvd.lab.army.InterfaceDAO.IRankDAO;
import com.solvd.lab.army.InterfaceDAO.IRankTypeDAO;
import com.solvd.lab.army.database.DBConnectionManager;
import com.solvd.lab.army.entity.Rank;
import com.solvd.lab.army.entity.RankType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RankTypeDAOImpl implements IRankTypeDAO {
    private static final Logger logger = LogManager.getLogger(RankTypeDAOImpl.class);
    private Connection connection;

    public RankTypeDAOImpl() {

        connection = DBConnectionManager.getConnection();
    }

    @Override
    public void insert(RankType rankType) {

        try {

            String query = "INSERT INTO rank_type (name) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, rankType.getName());
            statement.setInt(2, rankType.getId());


            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(RankType rankType) {

        try {
            String query = "UPDATE rank_type SET name = ?  WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, rankType.getName());
            statement.setInt(2, rankType.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int rankTypeId) {

        try {
            String query = "DELETE FROM rank_type WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, rankTypeId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RankType> getAllRankTypes() {
        List<RankType> ranTypekList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM rank_type";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                RankType rankType = new RankType(id, name) ;

                ranTypekList.add(rankType);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ranTypekList;
    }

    @Override
    public RankType getRankTypeById(int rankTypeId) {
        RankType rankType = null;

        try {
            String query = "SELECT * FROM rank_type WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, rankTypeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                rankType = new RankType(name ) ;

            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rankType;
    }

}