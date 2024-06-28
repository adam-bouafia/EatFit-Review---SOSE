package it.univaq.disim.sose.service;

import java.util.List;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;

import org.apache.cxf.jaxws.ServerAsyncResponse;

import it.univaq.disim.sose.data.RatingDataClient;
import it.univaq.disim.sose.model.AggregatedDataResponse;
import it.univaq.disim.sose.model.AggregatedRatingData;
import it.univaq.disim.sose.model.GlobalScoreData;
import it.univaq.disim.sose.model.RatingData;
import it.univaq.disim.sose.utils.Utility;

/**
 * Implementation of the FoodDetailsAggregator web service interface.
 * This class provides the functionality to aggregate food ratings.
 */
public class FoodDetailsAggregatorImpl implements FoodDetailsAggregator {

    /**
     * Synchronous method to aggregate ratings for a specific food item.
     *
     * @param foodId the unique identifier for the food item
     * @return AggregatedRatingData containing the aggregated ratings
     */
    @Override
    public AggregatedRatingData aggregateRatings(String foodId) {

        // Retrieve all ratings for the specified food item
        List<RatingData> ratings = RatingDataClient.getAllRatings(foodId);

        // Retrieve global score for the specified food item
        GlobalScoreData foodScore = RatingDataClient.getGlobalScore(foodId);

        // Create an initial AggregatedRatingData object
        AggregatedRatingData average = new AggregatedRatingData(foodId, -1, 0, 0, 0, 0, 0, 0, 0);

        // Calculate averages for each rating parameter
        average.setTasteRating(new Double(ratings.stream().mapToInt(p -> p.getTasteRating()).average().orElse(0)).intValue());
        average.setNutritionalvalueRating(new Double(ratings.stream().mapToInt(p -> p.getNutritionalvalueRating()).average().orElse(0)).intValue());
        average.setOverallsatisfactionRating(new Double(ratings.stream().mapToInt(p -> p.getOverallsatisfactionRating()).average().orElse(0)).intValue());
        average.setPackagingRating(new Double(ratings.stream().mapToInt(p -> p.getPackagingRating()).average().orElse(0)).intValue());
        average.setPriceRating(new Double(ratings.stream().mapToInt(p -> p.getPriceRating()).average().orElse(0)).intValue());

        // Set global score and number of ratings
        average.setGlobalScore(foodScore.getGlobalScore());
        average.setNumberOfRatings(foodScore.getNumberOfRatings());

        return average;
    }

    /**
     * Asynchronous method to aggregate ratings for a specific food item.
     * The response will be handled by an AsyncHandler.
     *
     * @param foodId the unique identifier for the food item
     * @param asyncHandler the handler for processing the response asynchronously
     * @return a Future object representing the pending result of the asynchronous computation
     */
    @Override
    public Future<?> aggregateRatingsAsync(String foodId, AsyncHandler<AggregatedDataResponse> asyncHandler) {

        Utility.consoleLog("executing aggregateRatingsAsync");

        // Create an asynchronous response object
        final ServerAsyncResponse<AggregatedDataResponse> asyncResponse = new ServerAsyncResponse<AggregatedDataResponse>();

        // Start a new thread for asynchronous processing
        new Thread() {
            public void run() {

                // Retrieve all ratings for the specified food item
                List<RatingData> ratings = RatingDataClient.getAllRatings(foodId);

                // Retrieve global score for the specified food item
                GlobalScoreData foodScore = RatingDataClient.getGlobalScore(foodId);

                // Create an initial AggregatedRatingData object
                AggregatedRatingData average = new AggregatedRatingData(foodId, -1, 0, 0, 0, 0, 0, 0, 0);

                // Calculate averages for each rating parameter
                average.setTasteRating(new Double(ratings.stream().mapToInt(p -> p.getTasteRating()).average().orElse(0)).intValue());
                average.setNutritionalvalueRating(new Double(ratings.stream().mapToInt(p -> p.getNutritionalvalueRating()).average().orElse(0)).intValue());
                average.setOverallsatisfactionRating(new Double(ratings.stream().mapToInt(p -> p.getOverallsatisfactionRating()).average().orElse(0)).intValue());
                average.setPackagingRating(new Double(ratings.stream().mapToInt(p -> p.getPackagingRating()).average().orElse(0)).intValue());
                average.setPriceRating(new Double(ratings.stream().mapToInt(p -> p.getPriceRating()).average().orElse(0)).intValue());

                // Set global score and number of ratings
                average.setGlobalScore(foodScore.getGlobalScore());
                average.setNumberOfRatings(foodScore.getNumberOfRatings());

                // Create a response object
                AggregatedDataResponse response = new AggregatedDataResponse();
                response.setAggregatedRatingData(average);

                // Set the response and handle it asynchronously
                asyncResponse.set(response);
                Utility.consoleLog("responding with " + average.toString());

                asyncHandler.handleResponse(asyncResponse);
            }
        }.start();

        return asyncResponse;
    }
}
