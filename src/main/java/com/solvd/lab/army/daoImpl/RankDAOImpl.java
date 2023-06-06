package com.solvd.lab.army.daoImpl;

import com.solvd.lab.army.InterfaceDAO.IRankDAO;
import com.solvd.lab.army.database.DBConnectionManager;
import com.solvd.lab.army.entity.Rank;
import com.solvd.lab.army.entity.RankType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RankDAOImpl implements IRankDAO {
    private static final Logger logger = LogManager.getLogger(RankTypeDAOImpl.class);
    private Connection connection;

    public RankDAOImpl() {

        connection = DBConnectionManager.getConnection();
    }

    @Override
    public void insert(Rank rank) {

        try {

            String query = "INSERT INTO rank (name,rank_type_id) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, rank.getName());
            statement.setInt(2, rank.getRankTypeId());


            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Rank rank) {

        try {
            String query = "UPDATE rank SET name = ?, rank_type_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, rank.getName());
            statement.setInt(2, rank.getRankTypeId());
            statement.setInt(3, rank.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int rankId) {

        try {
            String query = "DELETE FROM rank WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, rankId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Rank> getAllRanks() {
        List<Rank> rankList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM rank";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer rankTypeId = resultSet.getInt("rank_type_id");

                Rank rank = new Rank(id, name, rankTypeId ) ;

                rankList.add(rank);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rankList;
    }

    @Override
    public Rank getRankById(int rankId) {
        Rank rank = null;

        try {
            String query = "SELECT * FROM rank WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, rankId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer rankTypeId = resultSet.getInt("rank_type_id");
                rank = new Rank(name, rankTypeId ) ;

            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rank;

    }
    public List<Rank> getRankWithRankTypes() {
        List<Rank> rankList = new ArrayList<>();

        String query = "SELECT r.id,r.name as rankName,rt.name as rankTypeName" +
                "FROM mydb.rank " +
                "JOIN mydb.rank_type rt on r.rank_type_id = rt.id";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int rankId = resultSet.getInt("id");
                String rankName = resultSet.getString("rankName");
                String rankTypeName = resultSet.getString("rankTypeName");
                Integer rankTypeId = resultSet.getInt("rank_type_id");
                Rank rank = new Rank(rankId, rankName,rankTypeId);
                rank.addRankType(new RankType(rankTypeId));


                rankList.add(rank);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rankList;
    }

}