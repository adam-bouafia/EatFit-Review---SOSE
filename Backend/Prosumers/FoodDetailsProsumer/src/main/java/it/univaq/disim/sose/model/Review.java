package it.univaq.disim.sose.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

// Annotate the class to indicate that it is a root element in XML
@XmlRootElement(name = "Review")
public class Review {

    // Fields representing the review data
    private String foodID;  // Unique identifier for the food item
    private int userID;     // Unique identifier for the user
    private String title;   // Title of the review
    private String comment; // Comment or content of the review

    // Default constructor
    public Review() {
    }

    // Constructor with parameters
    public Review(String foodID, int userID, String title, String comment) {
        super();
        this.foodID = foodID;
        this.userID = userID;
        this.title = title;
        this.comment = comment;
    }

    // Constructor that initializes fields from a ResultSet
    public Review(ResultSet resultSet) throws SQLException {
        this.foodID = resultSet.getString(1);     // Get the foodID from the first column of the ResultSet
        this.userID = resultSet.getInt(2);        // Get the userID from the second column of the ResultSet
        this.title = resultSet.getString(3);      // Get the title from the third column of the ResultSet
        this.comment = resultSet.getString(4);    // Get the comment from the fourth column of the ResultSet
    }

    // Getter and Setter methods

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Override the toString method for easy printing
    @Override
    public String toString() {
        return "Review [foodID=" + foodID + ", userID=" + userID + ", title=" + title + ", comment=" + comment + "]";
    }
}
