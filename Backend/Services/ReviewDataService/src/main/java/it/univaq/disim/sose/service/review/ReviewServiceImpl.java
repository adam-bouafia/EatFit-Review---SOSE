package it.univaq.disim.sose.service.review;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;


import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.service.DAO.DAOFactory;
import it.univaq.disim.sose.service.DAO.ReviewDAO;
import it.univaq.disim.sose.utils.Utils;

public class ReviewServiceImpl implements ReviewService{
	
	{
		ReviewDAO reviewDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getReviewDAO();
		try {
			reviewDAO.createTableDB();
			Utils.consoleLog("database created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		
	@Override
	public String getReviewsByUserID(int userID) throws SQLException {
		ReviewDAO reviewDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getReviewDAO();
		List<Review> reviewList = reviewDAO.getReviewsByUserID(userID);
		JSONArray jsonArray = new JSONArray(reviewList);
		return jsonArray.toString();
	}

	@Override
	public String getReviewsByFoodID(String foodID) throws SQLException {
		ReviewDAO reviewDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getReviewDAO();
		List<Review> reviewList = reviewDAO.getReviewsByFoodID(foodID);
		JSONArray jsonArray = new JSONArray(reviewList);
		return jsonArray.toString();
	}

	@Override
	public String getReviewByFoodIDUserID(String foodID, int userID) throws SQLException {
		ReviewDAO reviewDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getReviewDAO();
		Review rev = reviewDAO.getReviewByFoodIDByUserID(foodID, userID);
		if(rev != null)	return new JSONObject(rev).toString();	    
		else return "";
	}

	@Override
	public String insertReview(String foodID, String title, String text, int userID) {
		Utils.consoleLog("foodID: "+ foodID+ " title: "+ title+ " text: "+ text+ " userID: "+ userID);
		boolean response = false;
		try {
			 ReviewDAO reviewDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getReviewDAO();
			 response = reviewDAO.inserReview(new Review(foodID,userID, title, text));
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		if(response) {
			JSONObject jsonObject = new JSONObject("Response", "inserted");
			jsonObject.put("Response", "inserted");
			return jsonObject.toString();
			
		}
		JSONObject jsonObject = new JSONObject("Response", "inserted");
		jsonObject.put("Response", "not inserted, already inserted another for this food");
		return jsonObject.toString();
		
	}

	
	@Override
	public void insertReviewAsync(String foodID, String title, String text, int userID, AsyncResponse asyncResponse)
			throws Exception {
		// TODO Auto-generated method stub
		Utils.consoleLog("foodID: "+ foodID+ " title: "+ title+ " text: "+ text+ " userID: "+ userID);
		
		new Thread() {
			public void run() {
				Utils.consoleLog("foodID: "+ foodID+ " title: "+ title+ " text: "+ text+ " userID: "+ userID);
				boolean DAOResponse = false;
				try {
					 ReviewDAO reviewDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getReviewDAO();
					 DAOResponse = reviewDAO.inserReview(new Review(foodID,userID, title, text));
				} catch (SQLException e) {

					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
				if(DAOResponse) {
					JSONObject jsonObject = new JSONObject("Response", "inserted");
					
					String message = jsonObject.toString();
					Response response = Response.ok(message).type(MediaType.APPLICATION_JSON).build();
					Utils.consoleLog("Responding on background thread");
					asyncResponse.resume(response);
					
				}
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("Response", "not inserted, already inserted another for this food");
				String message = jsonObject.toString();
				Response response = Response.ok(message).type(MediaType.APPLICATION_JSON).build();
				Utils.consoleLog("Responding on background thread");
				asyncResponse.resume(response);
				
			}
			
		}.start();
		
		
		
	}



}
