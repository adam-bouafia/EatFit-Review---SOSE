package it.univaq.disim.sose.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewList {
    
    // List to hold Review objects
    private List<Review> list;
    
    // Default constructor initializing an empty list
    public ReviewList() {
        this.list = new ArrayList<>();
    }

    // Constructor initializing the list with provided reviewList
    public ReviewList(List<Review> reviewList) {
        this.list = reviewList;
    }

    // Method to add a review to the list
    public void add(Review review) {
        list.add(review);
    }
    
    // Getter method to return the list of reviews
    public List<Review> getList() {
        return this.list;
    }
    
    // Override the toString method to provide a string representation of the review list
    @Override
    public String toString() {
        return list.stream()
            .map(n -> n.toString()) // Convert each review to its string representation
            .collect(Collectors.joining("-", "{", "}")); // Join them with "-" and enclose in "{}"
    }
}
