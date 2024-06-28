package it.univaq.disim.sose.model;

// This class represents a review for a food item
public class Review {
    
    // Keys
    private String foodID; // The ID of the food item being reviewed
    private int userID; // The ID of the user who provided the review
    
    // Parameters
    private String title; // The title of the review
    private String comment; // The comment or body of the review

    // Constructor to initialize all fields
    public Review(String foodID, int userID, String title, String comment) {
        super();
        this.foodID = foodID;
        this.userID = userID;
        this.title = title;    
        this.comment = comment;
    }
    
    // Default constructor
    public Review() {};
    
    // Getter method for foodID
    public String getFoodID() {
        return foodID;
    }

    // Setter method for foodID
    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    // Getter method for userID
    public int getUserID() {
        return userID;
    }

    // Setter method for userID
    public void setUserID(int userID) {
        this.userID = userID;
    }

    // Getter method for comment
    public String getComment() {
        return comment;
    }

    // Setter method for comment
    public void setComment(String comment) {
        this.comment = comment;
    }

    // Getter method for title
    public String getTitle() {
        return title;
    }

    // Setter method for title
    public void setTitle(String title) {
        this.title = title;
    }
    
    // Override toString() method to provide a string representation of the object
    @Override
    public String toString() {
        return "Review [foodID=" + foodID + ", userID=" + userID + ", title=" + title + ", comment=" + comment + "]";
    }
}
