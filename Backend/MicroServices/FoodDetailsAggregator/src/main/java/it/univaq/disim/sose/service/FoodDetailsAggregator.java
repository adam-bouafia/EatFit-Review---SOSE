package it.univaq.disim.sose.service;

import java.util.concurrent.Future;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.ResponseWrapper;

import it.univaq.disim.sose.model.AggregatedDataResponse;
import it.univaq.disim.sose.model.AggregatedRatingData;

/**
 * This interface defines the contract for the FoodDetailsAggregator web service.
 * It provides methods for aggregating food ratings.
 */
@WebService
public interface FoodDetailsAggregator {

    /**
     * Synchronous method to aggregate ratings for a specific food item.
     *
     * @param foodId the unique identifier for the food item
     * @return AggregatedRatingData containing the aggregated ratings
     */
    @WebMethod
    AggregatedRatingData aggregateRatings(String foodId);

    /**
     * Asynchronous method to aggregate ratings for a specific food item.
     * The response will be handled by an AsyncHandler.
     *
     * @param foodId the unique identifier for the food item
     * @param asyncHandler the handler for processing the response asynchronously
     * @return a Future object representing the pending result of the asynchronous computation
     */
    @WebMethod
    @ResponseWrapper(
        localName = "AggregatedDataResponse",
        className = "it.univaq.disim.sose.model.AggregatedDataResponse"
    )
    public Future<?> aggregateRatingsAsync(String foodId, AsyncHandler<AggregatedDataResponse> asyncHandler);
}
