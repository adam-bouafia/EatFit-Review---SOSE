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

		FoodData foodData = new FoodData();
		boolean othersDone = false;
		// foodData.setRatings(RatingDataClient.getRatingData(foodId));
		
		
		FoodDetailsAggregatorImplService service = new FoodDetailsAggregatorImplService();
		FoodDetailsAggregator port = service.getFoodDetailsAggregatorImplPort();
		
		MessageAsyncHandler messageAsyncHandler = new MessageAsyncHandler();
		
		Future<?> response = port.aggregateRatingsAsync(foodId, messageAsyncHandler);
		
		while (!response.isDone()) {
			
			Utility.consoleLog("Still waiting for aggregateRatingsAsync");
			
			if (!othersDone) {
				foodData = EdamamRestClient.getFoodData(foodId);
				foodData.setReviews(ReviewDataClient.getReviewData(foodId).getList());
				othersDone = true;
			}
			
			Thread.sleep(1000);
		}
		
		Utility.consoleLog("aggregateRatingsAsync replied");
		
		if (messageAsyncHandler.getAggregateRatingsResponse() == null) {
			Utility.consoleLog("No ratings for the selected food");
		}
		else {
			foodData.setRatings(new AggregatedRatingData(messageAsyncHandler.getAggregateRatingsResponse().getReturn()));
			
		}
		
		
		
		
		// System.out.println(foodData.getReviews().size());

		return foodData;
	}

}
