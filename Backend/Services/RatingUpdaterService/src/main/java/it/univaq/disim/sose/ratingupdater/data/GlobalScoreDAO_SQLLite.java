package it.univaq.disim.sose.ratingupdater.data; // Defines the package for the GlobalScoreDAO_SQLLite class

import java.sql.Connection; // Importing necessary classes for SQL connection
import java.sql.DriverManager; // Importing necessary classes for managing SQL drivers
import java.sql.PreparedStatement; // Importing necessary classes for SQL prepared statements
import java.sql.ResultSet; // Importing necessary classes for handling SQL result sets
import java.sql.SQLException; // Importing necessary classes for handling SQL exceptions
import java.sql.Statement; // Importing necessary classes for SQL statements

import it.univaq.disim.sose.ratingupdater.model.GlobalScoreData; // Importing the GlobalScoreData model class
import it.univaq.disim.sose.ratingupdater.utils.UtilityMethods; // Importing utility methods

public class GlobalScoreDAO_SQLLite implements GlobalScoreDAO {

    // Path to the SQLite database file
    private String FileURL = "rating_data.sql";

    // Method to establish a connection to the SQLite database
    private Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String url = "jdbc:sqlite:" + FileURL; // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url); // Establish the connection
        } catch (SQLException e) {
            UtilityMethods.consoleLog(e.getMessage());
        }
        return conn;
    }

    // Method to create the database table if it does not exist
    private void createDB() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS gloabl_score_data (food_id VARCHAR(255), global_score REAL, number_of_ratings INT)";
        UtilityMethods.consoleLog("CREATING GlobalScore");
        Statement statement = connect().createStatement();
        Connection connection = connect();
        if (connection == null) {
            UtilityMethods.consoleLog("Error creating connection");
        } else {
            statement.execute(sql); // Execute the SQL statement to create the table
        }
    }

    // Method to read the global score for a specific food ID
    @Override
    public GlobalScoreData readGlobalScore(String foodId) {
        try {
            createDB(); // Ensure the database table exists

            String sql = "SELECT food_id,global_score,number_of_ratings FROM gloabl_score_data WHERE food_id = ?";

            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, foodId); // Set the food ID parameter
                UtilityMethods.consoleLog(pstmt.toString());

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    UtilityMethods.consoleLog("Reading global score from food " + foodId + ", : " + rs.getDouble(2));
                    return new GlobalScoreData(rs.getString(1), rs.getDouble(2), rs.getInt(3));
                }

            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return null;
    }

    // Method to update the global score for a specific food ID
    @Override
    public boolean updateGlobalScore(GlobalScoreData newValue) {
        try {
            createDB(); // Ensure the database table exists
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        UtilityMethods.consoleLog("UPDATE SCORE");
        String sql = "";
        if (readGlobalScore(newValue.getFoodId()) != null) {

            sql = "UPDATE gloabl_score_data SET global_score = ?, number_of_ratings = ? WHERE food_id = ?";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // Set the corresponding parameters
                pstmt.setDouble(1, newValue.getGlobalScore());
                pstmt.setInt(2, newValue.getNumberOfRatings());
                pstmt.setString(3, newValue.getFoodId());
                // Execute the update
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                UtilityMethods.consoleLog(e.getMessage());
            }
        } else {
            UtilityMethods.consoleLog("INSERTING SCORE");
            sql = "INSERT INTO gloabl_score_data(food_id,global_score,number_of_ratings) VALUES(?,?,?)";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // Set the corresponding parameters
                pstmt.setString(1, newValue.getFoodId());
                pstmt.setDouble(2, newValue.getGlobalScore());
                pstmt.setInt(3, newValue.getNumberOfRatings());
                // Execute the insert
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                UtilityMethods.consoleLog(e.getMessage());
            }
        }

        return false;
    }

}
