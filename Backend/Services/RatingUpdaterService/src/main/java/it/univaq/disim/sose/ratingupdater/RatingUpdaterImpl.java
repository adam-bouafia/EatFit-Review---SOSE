package it.univaq.disim.sose.ratingupdater;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univaq.disim.sose.ratingupdater.model.RatingData;
import it.univaq.disim.sose.ratingupdater.model.RatingOperationResponse;
import it.univaq.disim.sose.ratingupdater.service.RatingUpdaterService;
import it.univaq.disim.sose.ratingupdater.utils.UtilityMethods;

public class RatingUpdaterImpl implements RatingUpdater {
    
    // Synchronous method to add ratings
    @Override
    public String addRatings(int userId, String foodId, int tasteRating, int nutritionalvalueRating, int overallsatisfactionRating, int packagingRating, int costumesRating) {
        
        // Create a RatingData object from the parameters
        RatingData objToAdd = new RatingData(foodId, userId, tasteRating, nutritionalvalueRating, overallsatisfactionRating, packagingRating, costumesRating);
        
        try {
            // Attempt to add the rating
            boolean done = RatingUpdaterService.getInstance().addRating(objToAdd);
            
            if (done) {
                // If successful, update the global score
                RatingUpdaterService.getInstance().updateGlobalScore(objToAdd);
                return new RatingOperationResponse("Rating inserted and global score updated", true).getJSONResponse();
            }
            return new RatingOperationResponse("User has already inserted the ratings for the food", false).getJSONResponse();
        } catch (Exception e) {
            // Handle exceptions and return an error response
            e.printStackTrace();
            return new RatingOperationResponse("Exception during add ratings", false).getJSONResponse();
        }
    }

    // Method to get average rating for a food
    @Override
    public String getRatingAvgs(String foodId) {
        try {
            // Get the average rating and return it as a JSON string
            return new JSONObject(RatingUpdaterService.getInstance().getRatingAverages(foodId)).toString();
        } catch (Exception e) {
            // Handle exceptions and return an error response
            e.printStackTrace();
            return new JSONObject(new RatingOperationResponse("Exception retrieving averages", false)).toString();
        }
    }

    // Method to get all ratings for a food
    @Override
    public String getAllRatings(String foodId) {
        try {
            // Get all ratings and return them as a JSON array string
            return new JSONArray(RatingUpdaterService.getInstance().getAllRatings(foodId)).toString();
        } catch (Exception e) {
            // Handle exceptions and return an error response
            e.printStackTrace();
            return new JSONObject(new RatingOperationResponse("Exception retrieving all ratings", false)).toString();
        }
    }

    // Method to get the global score for a food
    @Override
    public String getGlobalScore(String foodId) {
        try {
            // Get the global score and return it as a JSON string
            return new JSONObject(RatingUpdaterService.getInstance().getGlobalScore(foodId)).toString();
        } catch (Exception e) {
            // Handle exceptions and return an error response
            e.printStackTrace();
            return new JSONObject(new RatingOperationResponse("Exception retrieving global score", false)).toString();
        }
    }

    // Asynchronous method to add ratings
    @Override
    public void addRatingsAsync(int userId, String foodId, int tasteRating, int nutritionalvalueRating,
            int overallsatisfactionRating, int packagingRating, int costumesRating, AsyncResponse asyncResponse) throws Exception {
        
        UtilityMethods.consoleLog("Executing asynchronous addRatings method");
        
        new Thread() {
            public void run() {
                try {
                    // Create a RatingData object from the parameters
                    RatingData objToAdd = new RatingData(foodId, userId, tasteRating, nutritionalvalueRating, overallsatisfactionRating, packagingRating, costumesRating);
                    UtilityMethods.consoleLog(objToAdd.toString());
                    
                    // Attempt to add the rating
                    boolean done = RatingUpdaterService.getInstance().addRating(objToAdd);
                    
                    if (done) {
                        // If successful, update the global score
                        RatingUpdaterService.getInstance().updateGlobalScore(objToAdd);
                        String message = new RatingOperationResponse("Rating inserted and global score updated", true).getJSONResponse();
                        Response response = Response.ok(message).type(MediaType.APPLICATION_JSON).build();
                        UtilityMethods.consoleLog("Responding on background thread OK");
                        asyncResponse.resume(response);
                    } else {
                        // If the user has already inserted the rating, return an error response
                        String message = new RatingOperationResponse("User has already inserted the ratings for the food", false).getJSONResponse();
                        Response response = Response.ok(message).type(MediaType.APPLICATION_JSON).build();
                        UtilityMethods.consoleLog("Responding on background thread NOT INSERTED");
                        asyncResponse.resume(response);
                    }
                } catch (Exception e) {
                    // Handle exceptions and return an error response
                    e.printStackTrace();
                    String message = new RatingOperationResponse("Exception during add ratings", false).getJSONResponse();
                    Response response = Response.ok(message).type(MediaType.APPLICATION_JSON).build();
                    UtilityMethods.consoleLog("Responding on background thread NOT INSERTED, EXCEPTION");
                    asyncResponse.resume(response);
                }
            }
        }.start();
    }
}
