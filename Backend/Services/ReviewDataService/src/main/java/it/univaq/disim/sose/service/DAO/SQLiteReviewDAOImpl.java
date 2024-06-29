package it.univaq.disim.sose.service.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.utils.Utils;

// Implementation class for ReviewDAO interface using SQLite
public class SQLiteReviewDAOImpl implements ReviewDAO {

    // Database connection and statement variables
    private Connection conn = null;
    private PreparedStatement prep = null;
    private ResultSet res = null;
    
    // SQL queries for various operations
    private final String CREATE_DATABASE_TABLE = "CREATE TABLE IF NOT EXISTS review (review_id INTEGER PRIMARY KEY AUTOINCREMENT,food_id TEXT, title TEXT, comment TEXT, user_id INTEGER);";
    private final String SELECT_REVIEWS_BY_USERID = "SELECT food_id, user_id, title, comment FROM review where user_id = ?";
    private final String SELECT_REVIEWS_BY_FOODID = "SELECT food_id, user_id, title, comment FROM review where food_id = ?";
    private final String SELECT_REVIEW_BY_FOODID_USERID = "SELECT food_id, user_id, title, comment FROM review where food_id = ? AND user_id = ?";
    private final String INSERT_REVIEW = "INSERT INTO review(food_id, title, comment, user_id) VALUES (?, ?, ?, ?)";
    
    @Override
    public List<Review> getReviewsByFoodID(String foodID) throws SQLException {
        List<Review> reviewList = null;
        try {
            // Create a connection to the SQLite database
            conn = SQLiteDAOFactory.createConnection();
            // Prepare the SQL statement to select reviews by food ID
            prep = (PreparedStatement) conn.prepareStatement(SELECT_REVIEWS_BY_FOODID);
            prep.setString(1, foodID);
            res = prep.executeQuery();
            Utils.consoleLog(String.valueOf(res.getFetchSize()));
            // Initialize the review list
            reviewList = new ArrayList<>();
            // Loop through the result set and add each review to the list
            while(res.next()) {
                reviewList.add(new Review(res));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection and resources
            SQLiteDAOFactory.closeDbConnection(res, prep, conn);
        }
        return reviewList;
    }

    @Override
    public List<Review> getReviewsByUserID(int userID) {
        List<Review> reviewList = new ArrayList<>();
        try {
            // Create a connection to the SQLite database
            conn = SQLiteDAOFactory.createConnection();
            // Prepare the SQL statement to select reviews by user ID
            prep = conn.prepareStatement(SELECT_REVIEWS_BY_USERID);
            prep.setInt(1, userID);
            res = prep.executeQuery();
            // Loop through the result set and add each review to the list
            while(res.next()) {
                Review rev = new Review(res);
                Utils.consoleLog(rev.toString());
                reviewList.add(new Review(res));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection and resources
            SQLiteDAOFactory.closeDbConnection(res, prep, conn);
        }
        return reviewList;
    }

    @Override
    public boolean inserReview(Review review) {
        try {
            // Check if a review already exists for the given food ID and user ID
            if(getReviewByFoodIDByUserID(review.getFoodID(), review.getUserID()) != null) return false;
            // Create a connection to the SQLite database
            conn = SQLiteDAOFactory.createConnection();
            Utils.consoleLog(review.toString());
            // Prepare the SQL statement to insert a new review
            prep = conn.prepareStatement(INSERT_REVIEW);
            prep.setString(1, review.getFoodID());
            prep.setString(2, review.getTitle());
            prep.setString(3, review.getComment());
            prep.setInt(4, review.getUserID());
            prep.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Do not close the connection here as it is being handled elsewhere
        }
    }

    @Override
    public Review getReviewByFoodIDByUserID(String foodID, int userID) {
        Review rev = null;
        try {
            // Create a connection to the SQLite database
            conn = SQLiteDAOFactory.createConnection();
            // Prepare the SQL statement to select a review by food ID and user ID
            prep = (PreparedStatement) conn.prepareStatement(SELECT_REVIEW_BY_FOODID_USERID);
            prep.setString(1, foodID);
            prep.setInt(2, userID);
            res = prep.executeQuery();
            // If a review is found, create a new Review object
            if(res.next()) {
                rev = new Review(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection and resources
            SQLiteDAOFactory.closeDbConnection(res, prep, conn);
        }
        return rev;
    }

    @Override
    public void createTableDB() {
        try {
            // Create a connection to the SQLite database
            conn = SQLiteDAOFactory.createConnection();
            // Create the review table if it does not exist
            Statement statement = conn.createStatement();
            statement.executeUpdate(CREATE_DATABASE_TABLE);
            Utils.consoleLog("database create");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection and resources
            SQLiteDAOFactory.closeDbConnection(res, prep, conn);
        }
    }
}
