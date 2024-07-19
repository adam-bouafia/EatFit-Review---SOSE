package it.univaq.disim.sose.ratingupdater.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.sose.ratingupdater.model.RatingData;

public class RatingDataDAO_SQLLite implements RatingDataDAO {

    // Path to the SQLite database file
    private String FileURL = "rating_data.sql";

    // SQL Queries
    String CHECK_IF_ALREADY_EXISTS_SQL = "SELECT * FROM rating_data where food_id = ? AND user_id = ?";
    String INSERT_RATING_SQL = "INSERT INTO rating_data(food_id,user_id,food_direction_rating,actors_rating,global_score_rating,dialogues_rating,costumer_rating) VALUES(?,?,?,?,?,?,?)";
    String SELECT_ALL_RATINGS_SQL = "SELECT food_id,user_id,food_direction_rating,actors_rating,global_score_rating,dialogues_rating,costumer_rating from rating_data";
    String SELECT_RATINGS_BY_FOODID_SQL = "SELECT food_id,user_id,food_direction_rating,actors_rating,global_score_rating,dialogues_rating,costumer_rating from rating_data WHERE food_id = ?";

    // Method to establish connection with the SQLite database
    private Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String url = "jdbc:sqlite:" + FileURL;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Method to create the database table if it does not exist
    private void createDB() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS rating_data (food_id VARCHAR(255), user_id INT, food_direction_rating INT,actors_rating INT,global_score_rating INT, dialogues_rating INT, costumer_rating INT)";
        Statement statement = connect().createStatement();
        Connection connection = connect();
        if (connection == null) {
            System.out.println("Error creating connection");
        } else {
            statement.execute(sql);
        }
    }

    // Method to check if a rating already exists for a given foodId and userId
    public boolean checkIfAlreadyInserted(String foodId, int userId) throws SQLException {
        createDB();

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(CHECK_IF_ALREADY_EXISTS_SQL)) {

            pstmt.setString(1, foodId);
            pstmt.setInt(2, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) return true;

            return false;
        }
    }

    // Method to insert a single rating data into the database
    @Override
    public boolean insertRatingData(RatingData toAdd) throws SQLException {
        try {
            createDB();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        if (checkIfAlreadyInserted(toAdd.getFoodId(), toAdd.getUserId())) {
            System.out.println("Review already inserted. Aborting insert.");
            return false;
        }

        String sql = INSERT_RATING_SQL;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, toAdd.getFoodId());
            pstmt.setInt(2, toAdd.getUserId());
            pstmt.setInt(3, toAdd.getTasteRating());
            pstmt.setInt(4, toAdd.getNutritionalvalueRating());
            pstmt.setInt(5, toAdd.getOverallsatisfactionRating());
            pstmt.setInt(6, toAdd.getPackagingRating());
            pstmt.setInt(7, toAdd.getPriceRating());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // Method to insert multiple rating data into the database
    @Override
    public boolean insertRatingDatas(List<RatingData> toAdd) throws SQLException {
        try {
            createDB();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        toAdd.forEach((ratingData) -> {
            String sql = INSERT_RATING_SQL;

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, ratingData.getFoodId());
                pstmt.setInt(2, ratingData.getUserId());
                pstmt.setInt(3, ratingData.getTasteRating());
                pstmt.setInt(4, ratingData.getNutritionalvalueRating());
                pstmt.setInt(5, ratingData.getOverallsatisfactionRating());
                pstmt.setInt(6, ratingData.getPackagingRating());
                pstmt.setInt(7, ratingData.getPriceRating());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        });
        return true;
    }

    // Method to retrieve all rating data from the database
    @Override
    public List<RatingData> getAllRatingData() throws SQLException {
        try {
            createDB();

            String sql = SELECT_ALL_RATINGS_SQL;

            try (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                List<RatingData> returnList = new ArrayList<RatingData>();
                while (rs.next()) {
                    returnList.add(
                            new RatingData(
                                    rs.getString(1),
                                    rs.getInt(2),
                                    rs.getInt(3),
                                    rs.getInt(4),
                                    rs.getInt(5),
                                    rs.getInt(6),
                                    rs.getInt(7)
                            ));
                }
                return returnList;
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    // Method to retrieve all rating data for a specific foodId from the database
    @Override
    public List<RatingData> getAllRatingDataByFoodId(String foodId) throws SQLException {
        createDB();

        String sql = SELECT_RATINGS_BY_FOODID_SQL;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, foodId);
            ResultSet rs = pstmt.executeQuery();

            List<RatingData> returnList = new ArrayList<RatingData>();
            while (rs.next()) {
                returnList.add(
                        new RatingData(
                                rs.getString(1),
                                rs.getInt(2),
                                rs.getInt(3),
                                rs.getInt(4),
                                rs.getInt(5),
                                rs.getInt(6),
                                rs.getInt(7)
                        ));
            }
            return returnList;
        }
    }
}
