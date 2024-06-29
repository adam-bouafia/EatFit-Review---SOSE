package it.univaq.disim.sose.service.Authentic; // Defines the package for the AuthService interface

import java.sql.SQLException; // Importing SQLException for handling SQL exceptions

import javax.ws.rs.FormParam; // Importing FormParam for retrieving form parameters in RESTful services
import javax.ws.rs.POST; // Importing POST annotation to specify HTTP POST request
import javax.ws.rs.Path; // Importing Path annotation to specify the path of the RESTful service
import javax.ws.rs.Produces; // Importing Produces annotation to specify the response media type
import javax.ws.rs.core.MediaType; // Importing MediaType for defining standard media types

import io.swagger.v3.oas.annotations.Operation; // Importing Operation for Swagger API documentation
import io.swagger.v3.oas.annotations.media.Content; // Importing Content for Swagger API documentation
import io.swagger.v3.oas.annotations.responses.ApiResponse; // Importing ApiResponse for Swagger API documentation

@Path("User") // Specifies the base URI for all resource URIs provided by the service
public interface AuthService {

	@Operation( 
		description = "Login operation by specifying username and password", // Description of the operation
		responses = {
			@ApiResponse(
				description = "Return the Token for the user logged", // Description of the API response
				content = {
					@Content(mediaType = MediaType.APPLICATION_JSON) // Media type of the response content
				}
			)
		}
	)
	@POST // Specifies that this method will respond to HTTP POST requests
	@Produces({MediaType.APPLICATION_JSON}) // Specifies the media type(s) that the method will produce
	@Path("/Login") // The relative URI path of the method
	String login(@FormParam("username") String username, @FormParam("password") String password ) throws SQLException;
	// Method to handle login requests by accepting username and password as form parameters
	// Throws SQLException if any SQL error occurs
	
	@Operation( 
		description = "Signup operation by specifying username and password", // Description of the operation
		responses = {
			@ApiResponse(
				description = "Return the id for the registered user", // Description of the API response
				content = {
					@Content(mediaType = MediaType.APPLICATION_JSON) // Media type of the response content
				}
			)
		}
	)
	@POST // Specifies that this method will respond to HTTP POST requests
	@Produces({MediaType.APPLICATION_JSON}) // Specifies the media type(s) that the method will produce
	@Path("/signup") // The relative URI path of the method
	String signup(@FormParam("username") String username, @FormParam("password") String password ) throws SQLException;
	// Method to handle signup requests by accepting username and password as form parameters
	// Throws SQLException if any SQL error occurs
	
	@Operation( 
		description = "Check the token of the user by specifying userID and userToken", // Description of the operation
		responses = {
			@ApiResponse(
				description = "Return true if logged, false otherwise", // Description of the API response
				content = {
					@Content(mediaType = MediaType.APPLICATION_JSON) // Media type of the response content
				}
			)
		}
	)
	@POST // Specifies that this method will respond to HTTP POST requests
	@Produces({MediaType.APPLICATION_JSON}) // Specifies the media type(s) that the method will produce
	@Path("/checkUser") // The relative URI path of the method
	String checkUser(@FormParam("userID") int userID, @FormParam("userToken") String userToken) throws SQLException;
	// Method to handle token checking requests by accepting userID and userToken as form parameters
	// Throws SQLException if any SQL error occurs
}
