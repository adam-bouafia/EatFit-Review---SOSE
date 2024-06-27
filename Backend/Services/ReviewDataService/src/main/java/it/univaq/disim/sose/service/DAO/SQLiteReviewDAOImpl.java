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

public class SQLiteReviewDAOImpl implements ReviewDAO{

	private Connection conn = null;
	private PreparedStatement prep = null;
	private ResultSet res = null;
	
	private final String CREATE_DATABASE_TABLE = "CREATE TABLE IF NOT EXISTS review (review_id INTEGER PRIMARY KEY AUTOINCREMENT,food_id TEXT, title TEXT, comment TEXT, user_id INTEGER);";
	private final String SELECT_REVIEWS_BY_USERID = "SELECT food_id, user_id, title, comment FROM review where user_id = ?";
	private final String SELECT_REVIEWS_BY_FOODID = "SELECT food_id, user_id, title, comment FROM review where food_id = ?";
	private final String SELECT_REVIEW_BY_FOODID_USERID = "SELECT food_id, user_id, title, comment FROM review where food_id = ? AND user_id = ?";
	private final String INSERT_REVIEW = "INSERT INTO review(food_id, title, comment, user_id) VALUES (?, ?, ?, ?)";
	
	
	
	@Override
	public List<Review> getReviewsByFoodID(String foodID) throws SQLException {
		List<Review> reviewList = null;
		try {
		conn = SQLiteDAOFactory.createConnection();
		prep = (PreparedStatement) conn.prepareStatement(SELECT_REVIEWS_BY_FOODID);
		prep.setString(1, foodID);
		res = prep.executeQuery();
		Utils.consoleLog(String.valueOf(res.getFetchSize()));
		reviewList = new ArrayList<>();
		while(res.next()) {
			//System.out.println("id: "+res.getInt("food_id"));
			reviewList.add(new Review(res));
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);

		}

		return reviewList;
	}

	@Override
	public List<Review> getReviewsByUserID(int userID) {
		List<Review> reviewList = new ArrayList<>();

		try {
			conn = SQLiteDAOFactory.createConnection();
			prep = conn.prepareStatement(SELECT_REVIEWS_BY_USERID);
			prep.setInt(1, userID);
			res = prep.executeQuery();
			while(res.next()) {
				Review rev = new Review(res);
				Utils.consoleLog(rev.toString());
				reviewList.add(new Review(res));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
		
		return reviewList;
	}


	@Override
	public boolean inserReview(Review review)  {
		try {
		if(getReviewByFoodIDByUserID(review.getFoodID(), review.getUserID())!= null) return false;

		conn = SQLiteDAOFactory.createConnection();
		Utils.consoleLog(review.toString());
		
		
		
		prep = conn.prepareStatement(INSERT_REVIEW);
		prep.setString(1, review.getFoodID());
		prep.setString(2, review.getTitle());
		prep.setString(3, review.getComment());
		prep.setInt(4, review.getUserID());
		prep.executeUpdate();
		return true;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			//SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
	
	}


	@Override
	public Review getReviewByFoodIDByUserID(String foodID, int userID) {
		Review rev = null;
		
		try {
		conn = SQLiteDAOFactory.createConnection();
		prep = (PreparedStatement) conn.prepareStatement(SELECT_REVIEW_BY_FOODID_USERID);
		prep.setString(1, foodID);
		prep.setInt(2, userID);
		res = prep.executeQuery();
		
		if(res.next()) {
			rev = new Review(res);
		}		
		}
		catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
		return rev;
	}
	

	@Override
	public void createTableDB()  {
		try {
		conn = SQLiteDAOFactory.createConnection();
		
        Statement statement = conn.createStatement();
        statement.executeUpdate(CREATE_DATABASE_TABLE);
        Utils.consoleLog("database create");

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
	}

}
