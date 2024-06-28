package it.univaq.disim.sose.fooddetails;

import java.util.concurrent.Future;

import it.univaq.disim.sose.fooddetails.data.EdamamRestClient;
import it.univaq.disim.sose.fooddetails.data.ReviewDataClient;
import it.univaq.disim.sose.model.AggregatedRatingData;
import it.univaq.disim.sose.model.FoodData;
import it.univaq.disim.sose.service.FoodDetailsAggregator;
import it.univaq.disim.sose.service.FoodDetailsAggregatorImplService;
import it.univaq.disim.sose.util.MessageAsyncHandler;
import it.univaq.disim.sose.util.Utility;

public class FoodDetailsImpl implements FoodDetails {

    @Override
    public FoodData getFoodDetails(String foodId) throws Exception {

        FoodData foodData = new FoodData(); // Create a new instance of FoodData to store the details
        boolean othersDone = false; // Flag to check if other data fetching is done
        
        // Create a service and get the port for FoodDetailsAggregator
        FoodDetailsAggregatorImplService service = new FoodDetailsAggregatorImplService();
        FoodDetailsAggregator port = service.getFoodDetailsAggregatorImplPort();
        
        // Create an instance of MessageAsyncHandler to handle asynchronous responses
        MessageAsyncHandler messageAsyncHandler = new MessageAsyncHandler();
        
        // Call the asynchronous method to get aggregated ratings
        Future<?> response = port.aggregateRatingsAsync(foodId, messageAsyncHandler);
        
        // Wait for the asynchronous response to complete
        while (!response.isDone()) {
            
            Utility.consoleLog("Still waiting for aggregateRatingsAsync");
            
            if (!othersDone) {
                // Fetch food details and reviews if not already done
                foodData = EdamamRestClient.getFoodData(foodId);
                foodData.setReviews(ReviewDataClient.getReviewData(foodId).getList());
                othersDone = true;
            }
            
            Thread.sleep(1000); // Sleep for 1 second before checking again
        }
        
        Utility.consoleLog("aggregateRatingsAsync replied");
        
        // Check if the asynchronous response contains aggregated ratings
        if (messageAsyncHandler.getAggregateRatingsResponse() == null) {
            Utility.consoleLog("No ratings for the selected food");
        } else {
            // Set the aggregated ratings to the food data
            foodData.setRatings(new AggregatedRatingData(messageAsyncHandler.getAggregateRatingsResponse().getReturn()));
        }
        
        return foodData; // Return the complete food data with details, reviews, and ratings
    }
}
