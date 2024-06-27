package it.univaq.disim.sose.application.models;

import org.json.JSONObject;
import org.ksoap2.serialization.SoapObject;

public class RatingData {
    // Keys
    private String foodId;
    private String userId;

    // Parameters
    private String foodDirectionRating;
    private String actorsRating;
    private String globalScoreRating;
    private String dialoguesRating;
    private String costumerRating;
    private String globalScore;
    private String numberRatings;

    public RatingData() {
        super();
        this.foodId = "0";
        this.userId = "0";
        this.foodDirectionRating = "0";
        this.actorsRating = "0";
        this.globalScoreRating = "0";
        this.dialoguesRating = "0";
        this.costumerRating = "0";
        this.globalScore="0";
        this.numberRatings="0";
    }

    public RatingData(String foodId, String userId, String foodDirectionRating, String actorsRating, String globalScoreRating,
                      String dialoguesRating, String costumerRating,String globalScore,String numberRatings) {
        super();
        this.foodId = foodId;
        this.userId = userId;
        this.foodDirectionRating = foodDirectionRating;
        this.actorsRating = actorsRating;
        this.globalScoreRating = globalScoreRating;
        this.dialoguesRating = dialoguesRating;
        this.costumerRating = costumerRating;
        this.globalScore=globalScore;
        this.numberRatings=numberRatings;
    }

    public RatingData(SoapObject object){
        super();
        this.foodId = object.getPropertyAsString("foodId");
        this.userId = object.getPropertyAsString("userId");
        this.foodDirectionRating = object.getPropertyAsString("foodDirectionRating");
        this.actorsRating = object.getPropertyAsString("actorsRating");
        this.globalScoreRating = object.getPropertyAsString("globalScoreRating");
        this.dialoguesRating = object.getPropertyAsString("dialoguesRating");
        this.costumerRating = object.getPropertyAsString("costumerRating");
        this.numberRatings = object.getPropertyAsString("numberOfRatings");
        this.globalScore = object.getPropertyAsString("globalScore");
    }

    public String getFoodId() {
        return foodId;
    }


    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getFoodDirectionRating() {
        return foodDirectionRating;
    }


    public void setFoodDirectionRating(String foodDirectionRating) {
        this.foodDirectionRating = foodDirectionRating;
    }


    public String getTasteRating() {
        return actorsRating;
    }


    public void setTasteRating(String actorsRating) {
        this.actorsRating = actorsRating;
    }


    public String getGlobalScoreRating() {
        return globalScoreRating;
    }


    public void setGlobalScoreRating(String globalScoreRating) {
        this.globalScoreRating = globalScoreRating;
    }


    public String getDialoguesRating() {
        return dialoguesRating;
    }


    public void setDialoguesRating(String dialoguesRating) {
        this.dialoguesRating = dialoguesRating;
    }


    public String getCostumerRating() {
        return costumerRating;
    }


    public void setCostumerRating(String costumerRating) {
        this.costumerRating = costumerRating;
    }


    public String getGlobalScore() {
        return globalScore;
    }

    public void setGlobalScore(String globalScore) {
        this.globalScore = globalScore;
    }

    public String getNumberRatings() {
        return numberRatings;
    }

    public void setNumberRatings(String numberRatings) {
        this.numberRatings = numberRatings;
    }

    @Override
    public String toString() {
        return "foodDirectionRating: " + foodDirectionRating + "\nactorsRating: " + actorsRating  + "\ndialoguesRating: "
                + dialoguesRating + "\ncostumerRating: " + costumerRating + "\nglobalScoreRating: " + globalScoreRating
                + "\nnumber of Ratings: " + numberRatings;
    }

    public String globalScoreText(){
        return "This food has a globalscore of " + globalScore;
    }
}
