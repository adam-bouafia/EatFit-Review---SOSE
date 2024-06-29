package it.univaq.disim.sose.service.review;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.univaq.disim.sose.model.Review;

// Defines the path for the service
@Path("Review")
public interface ReviewService {

    // Defines an operation for retrieving all reviews by user ID
    @Operation(
            description = "Get all the reviews inserted by a User",
            responses = {
                    @ApiResponse(
                            description = "Return all the reviews as a Json response",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = Review.class)))
                            }
                    )
            }
    )
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getReviewsByUserID")
    String getReviewsByUserID(@QueryParam("userID") int userID) throws SQLException;

    // Defines an operation for retrieving all reviews by food ID
    @Operation(
            description = "Get all the reviews by FoodID",
            responses = {
                    @ApiResponse(
                            description = "Return all the reviews as a Json response",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = Review.class)))
                            }
                    )
            }
    )
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getReviewsByFoodID")
    String getReviewsByFoodID(@QueryParam("foodID") String foodID) throws SQLException;

    // Defines an operation for retrieving a review by food ID and user ID
    @Operation(
            description = "Get Review inserted by a User for a specific food",
            responses = {
                    @ApiResponse(
                            description = "Return the review as a Json response",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = Review.class)))
                            }
                    )
            }
    )
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getReviewByFoodIDUserID")
    String getReviewByFoodIDUserID(@QueryParam("foodID") String foodID, @QueryParam("userID") int userID) throws SQLException;

    // Defines an operation for inserting a review
    @Operation(
            description = "Insert review by specifying some parameters",
            responses = {
                    @ApiResponse(
                            description = "Return 'Inserted' if the user has not inserted already a review for the food, otherwise return 'Not inserted'",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON)
                            }
                    )
            }
    )
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/insertReview")
    String insertReview(@QueryParam("foodID") String foodID, @QueryParam("title") String title, @QueryParam("text") String text, @QueryParam("userID") int userID) throws SQLException;

    // Defines an operation for inserting a review asynchronously
    @Operation(
            description = "Insert review by specifying some parameters asynchronously",
            responses = {
                    @ApiResponse(
                            description = "Return 'Inserted' if the user has not inserted already a review for the food, otherwise return 'Not inserted' (async)",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON)
                            }
                    )
            }
    )
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/insertReviewAsync")
    void insertReviewAsync(
            @QueryParam("foodID") final String foodID,
            @QueryParam("title") final String title,
            @QueryParam("text") final String text,
            @QueryParam("userID") final int userID,
            @Suspended final AsyncResponse asyncResponse) throws Exception;
}
