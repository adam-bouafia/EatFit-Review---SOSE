package it.univaq.disim.sose.service.DAO;

import java.sql.SQLException;
import java.util.List;

import it.univaq.disim.sose.model.Review;

// Interface for Review Data Access Object (DAO)
public interface ReviewDAO {
    
    // Method to get a list of reviews by food ID
    public List<Review> getReviewsByFoodID(String foodID) throws SQLException;
    
    // Method to get a list of reviews by user ID
    public List<Review> getReviewsByUserID(int userID) throws SQLException;
    
    // Method to get a review by food ID and user ID
    public Review getReviewByFoodIDByUserID(String foodID, int userID) throws SQLException;
    
    // Method to insert a review into the database
    public boolean inserReview(Review review) throws SQLException;

    // Method to create the reviews table in the database
    public void createTableDB() throws SQLException;
    
}
