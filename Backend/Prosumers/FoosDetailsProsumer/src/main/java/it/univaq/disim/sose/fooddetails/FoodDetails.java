package it.univaq.disim.sose.fooddetails;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.univaq.disim.sose.model.FoodData;

@WebService
public interface FoodDetails {
	
	@WebMethod
	FoodData getFoodDetails(String foodId) throws Exception;
	
}
