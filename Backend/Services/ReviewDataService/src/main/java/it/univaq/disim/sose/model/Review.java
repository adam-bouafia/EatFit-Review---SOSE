package it.univaq.disim.sose.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Review")
public class Review {

    // Attributes
    private String foodID;
    private int userID; 
    private String title;
    private String comment;

    // Constructor with parameters
    public Review(String foodID, int userID, String title, String comment) {
        super();
        this.foodID = foodID;
        this.userID = userID;
        this.title = title;
        this.comment = comment;
    }

    // Constructor to create a Review object from a ResultSet
    public Review(ResultSet resultSet) throws SQLException {
        this.foodID = resultSet.getString(1);
        this.userID = resultSet.getInt(2);
        this.title = resultSet.getString(3);
        this.comment = resultSet.getString(4);
    }

    // Getter and setter for foodID
    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    // Getter and setter for userID
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    // Getter and setter for comment
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // Getter and setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    // Override toString method to provide a string representation of the Review object
    @Override
    public String toString() {
        return "Review [foodID=" + foodID + ", userID=" + userID + ", title=" + title + ", comment=" + comment + "]";
    }
}
