package it.univaq.disim.sose.application.models;

public class Review {

    private String  foodID;
    private String userID;
    private String title;
    private String comment;


    public Review(String foodID, String userID,String title, String comment) {
        super();
        this.foodID = foodID;
        this.userID = userID;
        this.title = title;
        this.comment = comment;
    }


    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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

    @Override
    public String toString() {
        return "Review [foodID=" + foodID + ", userID=" + userID + ", title=" + title + ", comment=" + comment + "]";
    }
}
