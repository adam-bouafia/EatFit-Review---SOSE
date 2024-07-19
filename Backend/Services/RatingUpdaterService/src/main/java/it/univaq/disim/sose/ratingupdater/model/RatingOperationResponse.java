package it.univaq.disim.sose.ratingupdater.model;

import org.json.JSONObject;

// Class to represent the response of a rating operation
public class RatingOperationResponse {

    // Message to indicate the status or result of the operation
    private String message;
    
    // Boolean to indicate the success or failure of the operation
    private Boolean outcome;

    // Constructor to initialize the fields
    public RatingOperationResponse(String message, Boolean outcome) {
        super();
        this.message = message;
        this.outcome = outcome;
    }

    // Override toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "InsertResponse [message=" + message + ", outcome=" + outcome + "]";
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for outcome
    public Boolean getOutcome() {
        return outcome;
    }

    // Setter for outcome
    public void setOutcome(Boolean outcome) {
        this.outcome = outcome;
    }
    
    // Method to generate a JSON representation of the response
    public String getJSONResponse() {
        // Create a new JSONObject
        JSONObject jsonObject = new JSONObject();
        // Add message and outcome to the JSON object
        jsonObject.put("Message", this.message);
        jsonObject.put("Outcome", this.outcome);
        // Return the JSON object as a string
        return jsonObject.toString();
    }
    
}
