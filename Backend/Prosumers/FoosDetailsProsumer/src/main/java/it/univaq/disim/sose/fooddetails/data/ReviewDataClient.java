package it.univaq.disim.sose.fooddetails.data;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;
import org.json.JSONObject;

import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.model.ReviewList;
import it.univaq.disim.sose.util.Utility;

public class ReviewDataClient {
	
	// Base URL for the Review Data Service
	private static final String ReviewDataServiceURL = "http://localhost:8080/ReviewDataService/rest/Review/getReviewsByFoodID";
	
	// Method to fetch review data for a given foodId
	public static ReviewList getReviewData(String foodId) {
		
		// Creating a WebClient to make the request to the Review Data Service
		WebClient client = WebClient.create(ReviewDataServiceURL + "?foodID=" + foodId);
		Utility.consoleLog("Calling: " + ReviewDataServiceURL + "?foodID=" + foodId);
		
		// Making a GET request and getting the response
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		// Reading the response content as a String
		String content = response.readEntity(String.class);
		Utility.consoleLog("Content: " + content);
		
		// Parsing the response content to a JSON array
		JSONArray responseArray = new JSONArray(content);
		Utility.consoleLog(responseArray.toString(2));
		
		// List to hold the parsed review data
		List<Review> reviewList = new ArrayList<Review>();
		
		// Iterating through the JSON array to extract review data
		for (int i = 0; i < responseArray.length(); i++) {
			JSONObject reviewJSON = responseArray.getJSONObject(i);
			try {
				reviewList.add(
					new Review(
						reviewJSON.getString("foodID"), 
						reviewJSON.getInt("userID"), 
						reviewJSON.getString("title"), 
						reviewJSON.getString("comment")
					)
				);
			} catch (Exception ex) {
				ex.printStackTrace();
				Utility.consoleLog("Review not added " + reviewJSON.toString());
			}
		}
		
		// Creating a ReviewList object to hold the parsed reviews
		ReviewList responseList = new ReviewList(reviewList);
		
		// Returning the ReviewList object
		return responseList;
	}

}
