package it.univaq.disim.sose.data;

import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import it.univaq.disim.sose.callbacks.Callback;
import it.univaq.disim.sose.model.RatingData;
import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.utils.Utility;

// ClientAsync class for handling asynchronous HTTP requests related to ratings and reviews
public class ClientAsync {

    // URLs for asynchronous services
    private static final String RatingDataServiceAsyncURL = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/addRatingsAsync";
    private static final String ReviewDataServiceAsyncURL = "http://localhost:8080/ReviewDataService/rest/Review/insertReviewAsync";
    
    // Method to insert ratings and reviews asynchronously
    public static String insertRatings(RatingData ratingData, Review review) throws Exception {
        
        // Create a new HTTP client
        Client client = ClientBuilder.newClient();
        
        // Callback handlers for the asynchronous requests
        Callback handlerRating = new Callback();
        Callback handlerReview = new Callback();
        
        // Construct the URL for the ratings service with query parameters
        URL RatingAsyncURL = new URL(RatingDataServiceAsyncURL 
                + "?userId=" + ratingData.getUserId()
                + "&foodId=" + ratingData.getFoodId()
                + "&tasteRating=" + ratingData.getTasteRating()
                + "&nutritionalvalueRating=" + ratingData.getNutritionalvalueRating()
                + "&overallsatisfactionRating=" + ratingData.getOverallsatisfactionRating()
                + "&packagingRating=" + ratingData.getPackagingRating()
                + "&costumesRating=" + ratingData.getPriceRating());
        
        // Construct the URL for the reviews service with query parameters
        @SuppressWarnings("deprecation")
        URL ReviewAsyncURL = new URL(ReviewDataServiceAsyncURL 
                + "?foodID=" + review.getFoodID() 
                + "&title=" + URLEncoder.encode(review.getTitle())
                + "&text=" + URLEncoder.encode(review.getComment()) 
                + "&userID=" + review.getUserID());
        
        // Log the constructed URLs
        Utility.consoleLog("Calling " + RatingAsyncURL + " " + ReviewAsyncURL);
        
        // Asynchronously invoke the addRatings method from the RatingUpdaterService
        Utility.consoleLog("Invoking async addRatings method from RatingUpdaterService");
        Future<Response> futureResponseRating = client.target(RatingAsyncURL.toString()).request().async().get(handlerRating);
        
        // Asynchronously invoke the addReview method from the RatingUpdaterService
        Utility.consoleLog("Invoking async addReview method from RatingUpdaterService");
        Future<Response> futureResponseReview = client.target(ReviewAsyncURL.toString()).request().async().get(handlerReview);
        
        // Wait for both asynchronous requests to complete
        while (!futureResponseRating.isDone() || !futureResponseReview.isDone()) {
            // Doing something while waiting
            Thread.sleep(1000);
            Utility.consoleLog("Waiting for async completion [futureResponseRating " + futureResponseRating.isDone() + ", futureResponseReview " + futureResponseReview.isDone() + "]");
        }
        
        // Get the responses from the future objects
        Response reviewResponse = futureResponseReview.get();
        Response ratingResponse = futureResponseRating.get();
        
        // Log the responses
        Utility.consoleLog("Review Response Async: " + reviewResponse.readEntity(String.class));
        Utility.consoleLog("Rating Response Async: " + ratingResponse.readEntity(String.class));
        
        // Check if the review response contains an error
        if (reviewResponse.readEntity(String.class).contains("not")) {
            return "ERROR";
        }
        
        // Check if the rating response indicates a successful outcome
        if (!(new JSONObject(ratingResponse.readEntity(String.class)).getBoolean("Outcome"))) {
            return "ERROR";
        }
        
        // Log the successful insertion
        Utility.consoleLog("Received response from service - Inserted");
        
        // Return a success message
        return "Review and Rating async inserted successfully";
    }
}
