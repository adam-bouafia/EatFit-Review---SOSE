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

	private static final String RatingDataService_URL_GET_ALL_RATINGS = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/getAllRatings";
	private static final String RatingDataService_URL_GET_GLOBAL_SCORE = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/getGlobalScore";
	
	public static GlobalScoreData getGlobalScore(String foodId) {
		WebClient client = WebClient.create(RatingDataService_URL_GET_GLOBAL_SCORE + "?foodId=" + foodId);
		Utility.consoleLog("Calling: " + RatingDataService_URL_GET_GLOBAL_SCORE + "?foodId=" + foodId);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		
		//xstream.allowTypesByWildcard(new String[]{"com.baeldung.**"});
		
		String content = response.readEntity(String.class);
		Utility.consoleLog("Content: " + content);
		
		JSONObject responseJSON = new JSONObject(content);
		//Utility.consoleLog(responseJSON.toString(2));
		
		GlobalScoreData movieScore = new GlobalScoreData();
		movieScore.setFoodId(foodId);
		movieScore.setGlobalScore(responseJSON.getDouble("globalScore"));
		movieScore.setNumberOfRatings(responseJSON.getInt("numberOfRatings"));
		return movieScore;
	}
	
	public static List<RatingData> getAllRatings(String foodId) {
		WebClient client = WebClient.create(RatingDataService_URL_GET_ALL_RATINGS + "?foodId=" + foodId);
		Utility.consoleLog("Calling: " + RatingDataService_URL_GET_ALL_RATINGS + "?foodId=" + foodId);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		
		//xstream.allowTypesByWildcard(new String[]{"com.baeldung.**"});
		
		String content = response.readEntity(String.class);
		Utility.consoleLog("Content: " + content);
		
		JSONArray responseArray = new JSONArray(content);
		//Utility.consoleLog(responseArray.toString(2));
		
		List<RatingData> ratingList = new ArrayList<RatingData>();
		
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
