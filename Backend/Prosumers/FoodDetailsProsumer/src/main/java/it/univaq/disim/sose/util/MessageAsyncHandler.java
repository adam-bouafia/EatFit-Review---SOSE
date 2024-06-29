package it.univaq.disim.sose.util;

import java.util.concurrent.ExecutionException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import it.univaq.disim.sose.service.AggregateRatingsResponse;

// This class implements AsyncHandler to handle asynchronous responses
public class MessageAsyncHandler implements AsyncHandler<AggregateRatingsResponse> {

    // Field to store the asynchronous response
    private AggregateRatingsResponse aggregateRatingsResponse;
    
    // Override method to handle the response when it's received
    @Override
    public void handleResponse(Response<AggregateRatingsResponse> res) {
        try {
            // Retrieve the response and store it in the field
            aggregateRatingsResponse = res.get();
        } catch (InterruptedException | ExecutionException e) {
            // Print the stack trace if an exception occurs
            e.printStackTrace();
        }
    }
    
    // Getter method to return the stored response
    public AggregateRatingsResponse getAggregateRatingsResponse() {
        return aggregateRatingsResponse;
    }
}
