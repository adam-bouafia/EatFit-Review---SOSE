package it.univaq.disim.sose.prosumer;

import javax.annotation.Resource; // Importing Resource annotation for injecting resources
import javax.servlet.http.HttpServletRequest; // Importing HttpServletRequest class for HTTP request handling
import javax.xml.ws.WebServiceContext; // Importing WebServiceContext for accessing web service context
import javax.xml.ws.handler.MessageContext; // Importing MessageContext for handling message context

import it.univaq.disim.sose.data.AuthDataClient;
import it.univaq.disim.sose.data.ClientAsync; // Importing ClientAsync class for asynchronous client operations
import it.univaq.disim.sose.data.RatingDataClient;
import it.univaq.disim.sose.data.ReviewDataClient;
import it.univaq.disim.sose.model.RatingData; // Importing RatingData model class
import it.univaq.disim.sose.model.Review; // Importing Review model class
import it.univaq.disim.sose.utils.Utility; // Importing Utility class for utility functions

// Implementation class for ReviewEditorProsumer web service
public class ReviewEditorProsumerImpl implements ReviewEditorProsumer {

    // Injecting WebServiceContext resource
    @Resource
    private WebServiceContext context;

    // Overriding insertReview method from ReviewEditorProsumer interface
    @Override
    public String insertReview(Review review, RatingData ratingData) {
        
        // Retrieving HTTP request from WebServiceContext
        HttpServletRequest req = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        
        // Extracting authToken from request header
        String authToken = req.getHeader("userToken");
        
        // Logging authToken if it is not empty
        if (!authToken.isEmpty()) {
            Utility.consoleLog(authToken);
        } else {
            return "You cannot insert reviews if not logged";
        }

        // Check if user is logged in
        if (!AuthDataClient.checkToken(authToken).equals("Logged")) return "You have to sign-in";

        // Insert review data
        if (!ReviewDataClient.insertReviewData(review).equals("inserted")) return "You cannot add more than one review for food";

        // Insert rating data
        if (!RatingDataClient.insertRatings(ratingData).equals("Rating inserted successfully")) return "You cannot add more than one rating for food";

        // Inserting ratings and reviews asynchronously using ClientAsync
        try {
            if (!ClientAsync.insertRatings(ratingData, review).equals("Review and Rating async inserted successfully")) {
                return "You cannot add more than one review and ratings for food";
            }
            return "Review inserted";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Review not inserted";
        }
    }
}
