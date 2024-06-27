package it.univaq.disim.sose.service.DAO;

import java.sql.SQLException;
import java.util.List;


import it.univaq.disim.sose.model.Review;

public interface ReviewDAO {
	
	public List<Review> getReviewsByFoodID(String foodID) throws SQLException;
	
	public List<Review> getReviewsByUserID(int userID) throws SQLException;
	
	public Review getReviewByFoodIDByUserID(String foodID, int userID) throws SQLException;
	
	public boolean inserReview(Review review) throws SQLException;

	public void createTableDB() throws SQLException;
	
	
	

}
