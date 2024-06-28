package it.univaq.disim.sose.prosumer;

import javax.jws.WebMethod; // Importing WebMethod annotation for exposing methods as web services
import javax.jws.WebService; // Importing WebService annotation to define the interface as a web service

import it.univaq.disim.sose.model.RatingData; // Importing the RatingData model class
import it.univaq.disim.sose.model.Review; // Importing the Review model class

// Defining this interface as a web service
@WebService
public interface ReviewEditorProsumer {
	
    // Exposing the insertReview method as a web service method
    @WebMethod
    String insertReview(Review review, RatingData ratingData);
}
