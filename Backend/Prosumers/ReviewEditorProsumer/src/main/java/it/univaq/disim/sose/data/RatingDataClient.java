package it.univaq.disim.sose.data;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import it.univaq.disim.sose.model.RatingData;

// This class handles interactions with the Rating Data Service
public class RatingDataClient {

    // URL of the Rating Data Service
    private static final String ReviewDataServiceURL = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/addRatings";
    
    // Method to insert rating data
    public static String insertRatings(RatingData ratingData) {
        
        // Create a WebClient and build the URL with query parameters from the RatingData object
        WebClient client = WebClient.create(ReviewDataServiceURL 
                + "?userId=" + ratingData.getUserId()
                + "&foodId=" + ratingData.getFoodId()
                + "&tasteRating=" + ratingData.getTasteRating()
                + "&nutritionalvalueRating=" + ratingData.getNutritionalvalueRating()
                + "&overallsatisfactionRating=" + ratingData.getOverallsatisfactionRating()
                + "&packagingRating=" + ratingData.getPackagingRating()
                + "&costumesRating=" + ratingData.getPriceRating());
                
        // Send the request and get the response
        @SuppressWarnings("unused")
        Response response = client.accept(MediaType.APPLICATION_JSON).get();
        
        
        return ""; // Placeholder return statement
    }
}
