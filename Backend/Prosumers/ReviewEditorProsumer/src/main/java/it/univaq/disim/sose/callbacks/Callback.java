package it.univaq.disim.sose.callbacks;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;

import it.univaq.disim.sose.utils.Utility;

// Callback class implementing the InvocationCallback interface for asynchronous HTTP requests
public class Callback implements InvocationCallback<Response> {

    // Variable to store the message received from the server
    private String messageFromTheServer;

    // Method called when the HTTP request completes successfully
    @Override
    public void completed(Response response) {
        // Check if the response status is 200 (OK)
        if (response.getStatus() == 200) {
            // Read and store the response entity as a string
            messageFromTheServer = response.readEntity(String.class);
        } else {
            // Log the error status if the response status is not 200
            Utility.consoleLog("REQUEST ERROR - " + response.getStatus());
        }
    }

    // Method called when the HTTP request fails
    @Override
    public void failed(Throwable throwable) {
        // Print the stack trace of the throwable
        throwable.printStackTrace();
    }

    // Method to get the response message from the server
    public String getResponse() {
        return this.messageFromTheServer;
    }
}
