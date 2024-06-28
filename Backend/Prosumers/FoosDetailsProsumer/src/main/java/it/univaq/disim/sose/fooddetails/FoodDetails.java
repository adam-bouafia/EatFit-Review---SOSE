package it.univaq.disim.sose.fooddetails;

import javax.jws.WebMethod;
import javax.jws.WebService;
import it.univaq.disim.sose.model.FoodData;

// Annotation to indicate that this is a web service
@WebService
public interface FoodDetails {
	
	// Annotation to indicate that this is a web method
	@WebMethod
	FoodData getFoodDetails(String foodId) throws Exception;
	
}
