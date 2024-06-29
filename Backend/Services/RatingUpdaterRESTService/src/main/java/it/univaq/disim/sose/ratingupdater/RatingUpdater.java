package it.univaq.disim.sose.ratingupdater;

import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.univaq.disim.sose.ratingupdater.model.RatingData;

@Path("/ratingupdaterservice")
public interface RatingUpdater {

    // Asynchronous method to add ratings
    @Operation( 
               description = "Add Rating by specifying some fields asynchronously",
               responses = {
                   @ApiResponse(
                      description = "Return Inserted or not if it has been already inserted a rating (asynchronously)",
                      content = {
                             @Content(mediaType = MediaType.APPLICATION_JSON)
                      }
                   )
                }
             )    
    @GET
    @Path("/addRatingsAsync")
    void addRatingsAsync(
            @QueryParam("userId") final int userId,
            @QueryParam("foodId") final String foodId,
            @QueryParam("tasteRating") final int tasteRating,
            @QueryParam("nutritionalvalueRating") final int nutritionalvalueRating,
            @QueryParam("overallsatisfactionRating") final int overallsatisfactionRating,
            @QueryParam("packagingRating") final int packagingRating,
            @QueryParam("costumesRating") final int costumesRating,
            @Suspended final AsyncResponse asyncResponse) throws Exception;
    
    // Synchronous method to add ratings
    @Operation( 
               description = "Add Rating by specifying some fields",
               responses = {
                   @ApiResponse(
                      description = "Return Inserted or not if it has been already inserted a rating",
                      content = {
                             @Content(mediaType = MediaType.APPLICATION_JSON)
                      }
                   )
                }
             )    
    @GET
    @Path("/addRatings")
    @Produces({MediaType.APPLICATION_JSON})
    String addRatings(
            @QueryParam("userId") int userId,
            @QueryParam("foodId") String foodId,
            @QueryParam("tasteRating") int tasteRating,
            @QueryParam("nutritionalvalueRating") int nutritionalvalueRating,
            @QueryParam("overallsatisfactionRating") int overallsatisfactionRating,
            @QueryParam("packagingRating") int packagingRating,
            @QueryParam("costumesRating") int costumesRating);
    
    // Method to get average rating for a food
    @Operation( 
               description = "Get average rating for a food",
               responses = {
                   @ApiResponse(
                      description = "Return the average rating as Json response",
                      content = {
                             @Content(mediaType = MediaType.APPLICATION_JSON)
                      }
                   )
                }
             )    
    @GET
    @Path("/getRatingAvgs")
    @Produces({MediaType.APPLICATION_JSON})
    String getRatingAvgs(
            @QueryParam("foodId") String foodId);
    
    // Method to get all the ratings for a food
    @Operation( 
               description = "Get all the ratings inserted for a Food",
               responses = {
                   @ApiResponse(
                      description = "Return all the ratings as a Json response",
                      content = {
                             @Content(mediaType = MediaType.APPLICATION_JSON,
                                     array = @ArraySchema(schema = @Schema(implementation = RatingData.class))
                            )
                      }
                   )
                }
             )    
    @GET
    @Path("/getAllRatings")
    @Produces({MediaType.APPLICATION_JSON})
    String getAllRatings(@QueryParam("foodId") String foodId);
    
    // Method to get the global summary score for a food
    @Operation( 
               description = "Get the global summary score Food",
               responses = {
                   @ApiResponse(
                      description = "Return the global summary score of a food as a Json response",
                      content = {
                             @Content(mediaType = MediaType.APPLICATION_JSON,
                                     array = @ArraySchema(schema = @Schema(implementation = RatingData.class))
                            )
                      }
                   )
                }
              )
    @GET
    @Path("/getGlobalScore")
    @Produces({MediaType.APPLICATION_JSON})
    String getGlobalScore(@QueryParam("foodId") String foodId);
}
