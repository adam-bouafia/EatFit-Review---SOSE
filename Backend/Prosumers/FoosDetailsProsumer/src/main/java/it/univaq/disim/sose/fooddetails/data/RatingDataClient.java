package it.univaq.disim.sose.fooddetails.data;

import it.univaq.disim.sose.model.AggregatedRatingData;
import it.univaq.disim.sose.service.FoodDetailsAggregator;
import it.univaq.disim.sose.service.FoodDetailsAggregatorImplService;

public class RatingDataClient {

    // Method to fetch rating data for a given foodId
    public static AggregatedRatingData getRatingData(String foodId) {
        
        // Creating an instance of the service
        FoodDetailsAggregatorImplService service = new FoodDetailsAggregatorImplService();
        
        // Getting the port from the service to interact with the FoodDetailsAggregator
        FoodDetailsAggregator port = service.getFoodDetailsAggregatorImplPort();
        
        // Calling the aggregateRatings method on the port with the provided foodId
        it.univaq.disim.sose.service.AggregatedRatingData ratingAvg = port.aggregateRatings(foodId);
        
        // Creating an object of AggregatedRatingData to store the response
        AggregatedRatingData objToReturn = new AggregatedRatingData();
        
        // Setting the properties of the AggregatedRatingData object from the response
        objToReturn.setFoodId(ratingAvg.getFoodId());
        objToReturn.setUserId(ratingAvg.getUserId());
        objToReturn.setNutritionalvalueRating(ratingAvg.getNutritionalvalueRating());
        objToReturn.setPriceRating(ratingAvg.getPriceRating());
        objToReturn.setTasteRating(ratingAvg.getTasteRating());
        objToReturn.setOverallsatisfactionRating(ratingAvg.getOverallsatisfactionRating());
        objToReturn.setPackagingRating(ratingAvg.getPackagingRating());
        objToReturn.setGlobalScore(ratingAvg.getGlobalScore());
        objToReturn.setNumberOfRatings(ratingAvg.getNumberOfRatings());
        
        // Returning the populated AggregatedRatingData object
        return objToReturn;
    }
}
