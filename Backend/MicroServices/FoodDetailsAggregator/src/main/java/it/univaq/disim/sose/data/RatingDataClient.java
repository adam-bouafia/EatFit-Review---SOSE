package it.univaq.disim.sose.data;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;
import org.json.JSONObject;

import it.univaq.disim.sose.model.GlobalScoreData;
import it.univaq.disim.sose.model.RatingData;
import it.univaq.disim.sose.utils.Utility;

public class RatingDataClient {

	// URLs to access the RatingDataService REST endpoints
	private static final String RatingDataService_URL_GET_ALL_RATINGS = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/getAllRatings";
	private static final String RatingDataService_URL_GET_GLOBAL_SCORE = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/getGlobalScore";


    /**
     * Fetches the global score data for a given food ID by making a GET request to the RatingDataService.
     * 
     * @param foodId The ID of the food item for which the global score is to be fetched.
     * @return A GlobalScoreData object containing the global score and the number of ratings.
     */

	public static GlobalScoreData getGlobalScore(String foodId) {
		// Create a WebClient to make the GET request
		WebClient client = WebClient.create(RatingDataService_URL_GET_GLOBAL_SCORE + "?foodId=" + foodId);
		Utility.consoleLog("Calling: " + RatingDataService_URL_GET_GLOBAL_SCORE + "?foodId=" + foodId);
		
		// Make the GET request and accept the response as JSON
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		 // Read the response content as a string
		
		String content = response.readEntity(String.class);
		Utility.consoleLog("Content: " + content);
		

		// Parse the response content into a JSONObject
		JSONObject responseJSON = new JSONObject(content);

		// Create and populate a GlobalScoreData object with the response data
		GlobalScoreData foodScore = new GlobalScoreData();
		foodScore.setFoodId(foodId);
		foodScore.setGlobalScore(responseJSON.getDouble("globalScore"));
		foodScore.setNumberOfRatings(responseJSON.getInt("numberOfRatings"));
		return foodScore;
	}
	

	    /**
     * Fetches all ratings for a given food ID by making a GET request to the RatingDataService.
     * 
     * @param foodId The ID of the food item for which the ratings are to be fetched.
     * @return A list of RatingData objects containing the ratings for the food item.
     */

	public static List<RatingData> getAllRatings(String foodId) {
		// Create a WebClient to make the GET request
		WebClient client = WebClient.create(RatingDataService_URL_GET_ALL_RATINGS + "?foodId=" + foodId);
		Utility.consoleLog("Calling: " + RatingDataService_URL_GET_ALL_RATINGS + "?foodId=" + foodId);
		
		// Make the GET request and accept the response as JSON
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		
		// Read the response content as a string
		String content = response.readEntity(String.class);
		Utility.consoleLog("Content: " + content);
		
		// Parse the response content into a JSONArray
		JSONArray responseArray = new JSONArray(content);
		
		// Create a list to hold the RatingData objects
		List<RatingData> ratingList = new ArrayList<RatingData>();
		
		// Iterate through the JSONArray and populate the list with RatingData objects
		for (int i = 0; i < responseArray.length(); i++) {
			JSONObject ratingJSON = responseArray.getJSONObject(i);
			ratingList.add(
					new RatingData(
							ratingJSON.getString("foodId"), 
							ratingJSON.getInt("userId"), 
							ratingJSON.getInt("tasteRating"), 
							ratingJSON.getInt("nutritionalvalueRating"),
							ratingJSON.getInt("overallsatisfactionRating"),
							ratingJSON.getInt("packagingRating"),
							ratingJSON.getInt("priceRating")
							));
		}
		return ratingList;
		
	}
	
}
