package it.univaq.disim.sose.service;

import java.util.concurrent.Future;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.ResponseWrapper;

import it.univaq.disim.sose.model.AggregatedDataResponse;
import it.univaq.disim.sose.model.AggregatedRatingData;

@WebService
public interface FoodDetailsAggregator {

	@WebMethod
	AggregatedRatingData aggregateRatings(String foodId);
	
	@WebMethod
	@ResponseWrapper(
			localName = "AggregatedDataResponse",
			className = "it.univaq.disim.sose.mode.AggregatedDataResponse"
	)
	public Future<?> aggregateRatingsAsync(String foodId, AsyncHandler<AggregatedDataResponse> asyncHandler);
	
}
