package it.univaq.disim.sose.data;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONObject;

import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.utils.Utility;

// This class handles interactions with the Review Data Service
public class ReviewDataClient {
	
	// URL of the Review Data Service
	private static final String ReviewDataServiceURL = "http://localhost:8080/ReviewDataService/rest/Review/insertReview";
	
	// Method to insert review data
	public static String insertReviewData(Review review) {
		// String insertReview(@QueryParam("foodID")String foodID, @QueryParam("title") String title, @QueryParam("text") String text, @QueryParam("userID") int userID) throws SQLException;

		// Create a WebClient and build the URL with query parameters from the Review object
		WebClient client = WebClient.create(ReviewDataServiceURL + "?foodID=" + review.getFoodID() + "&title=" + review.getTitle() + "&comment=" + review.getComment() + "&userID=" + review.getUserID());
		
		// Log the constructed URL
		Utility.consoleLog(ReviewDataServiceURL + "?foodID=" + review.getFoodID() + "&title=" + review.getTitle() + "&comment=" + review.getComment() + "&userID=" + review.getUserID());
		
		// Send the request and get the response
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		// Log the response content
		Utility.consoleLog("Content: " + response.readEntity(String.class));
		
		// Parse the response content to a JSONObject
		JSONObject jsonObject = new JSONObject(response.readEntity(String.class));
		
		// Return the "Response" field from the JSON object
		return jsonObject.get("Response").toString();
	}
}
