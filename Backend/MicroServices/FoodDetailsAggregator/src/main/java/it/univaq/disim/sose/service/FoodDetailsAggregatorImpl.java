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

public class FoodDetailsAggregatorImpl implements FoodDetailsAggregator {

	@Override
	public AggregatedRatingData aggregateRatings(String foodId) {
		// TODO Auto-generated method stub
		
		List<RatingData> ratings = RatingDataClient.getAllRatings(foodId);
		
		GlobalScoreData foodScore = RatingDataClient.getGlobalScore(foodId);
		
		AggregatedRatingData average = new AggregatedRatingData(foodId, -1, 0, 0, 0, 0, 0, 0, 0);
		average.setTasteRating(new Double(ratings.stream().mapToInt(p -> p.getTasteRating()).average().orElse(0)).intValue());
		average.setNutritionalvalueRating(new Double(ratings.stream().mapToInt(p -> p.getNutritionalvalueRating()).average().orElse(0)).intValue());
		average.setOverallsatisfactionRating(new Double(ratings.stream().mapToInt(p -> p.getOverallsatisfactionRating()).average().orElse(0)).intValue());
		average.setPackagingRating(new Double(ratings.stream().mapToInt(p -> p.getPackagingRating()).average().orElse(0)).intValue());
		average.setPriceRating(new Double(ratings.stream().mapToInt(p -> p.getPriceRating()).average().orElse(0)).intValue());
		average.setGlobalScore(foodScore.getGlobalScore());
		average.setNumberOfRatings(foodScore.getNumberOfRatings());
		return average;
	}

	@Override
	public Future<?> aggregateRatingsAsync(String foodId, AsyncHandler<AggregatedDataResponse> asyncHandler) {
		// TODO Auto-generated method stub
		
		Utility.consoleLog("executing aggregateRatingsAsync");
		
		final ServerAsyncResponse<AggregatedDataResponse> asyncResponse = new ServerAsyncResponse<AggregatedDataResponse>();
		
		new Thread() {
			public void run() {
				
				
				
				List<RatingData> ratings = RatingDataClient.getAllRatings(foodId);
				
				GlobalScoreData foodScore = RatingDataClient.getGlobalScore(foodId);
				
				AggregatedRatingData average = new AggregatedRatingData(foodId, -1, 0, 0, 0, 0, 0, 0, 0);
				average.setTasteRating(new Double(ratings.stream().mapToInt(p -> p.getTasteRating()).average().orElse(0)).intValue());
				average.setNutritionalvalueRating(new Double(ratings.stream().mapToInt(p -> p.getNutritionalvalueRating()).average().orElse(0)).intValue());
				average.setOverallsatisfactionRating(new Double(ratings.stream().mapToInt(p -> p.getOverallsatisfactionRating()).average().orElse(0)).intValue());
				average.setPackagingRating(new Double(ratings.stream().mapToInt(p -> p.getPackagingRating()).average().orElse(0)).intValue());
				average.setPriceRating(new Double(ratings.stream().mapToInt(p -> p.getPriceRating()).average().orElse(0)).intValue());
				average.setGlobalScore(foodScore.getGlobalScore());
				average.setNumberOfRatings(foodScore.getNumberOfRatings());
				
				AggregatedDataResponse response = new AggregatedDataResponse();
				
				response.setAggregatedRatingData(average);
				
				asyncResponse.set(response);
				Utility.consoleLog("responding with " + average.toString());
				
				asyncHandler.handleResponse(asyncResponse);
			}
		}.start();
		
		return asyncResponse;
	}

}
