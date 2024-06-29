package it.univaq.disim.sose.domain;

import java.sql.ResultSet; // Importing ResultSet for database operations
import java.sql.SQLException; // Importing SQLException for handling SQL exceptions
import javax.xml.bind.annotation.XmlRootElement; // Importing XmlRootElement for XML binding

// Annotating the User class to be the root element of the XML representation
@XmlRootElement(name = "User")
public class User {

    // Defining fields for the User class
	private int userID; // Unique identifier for the user
	private String username; // Username of the user
	private String password; // Password of the user
	private String token; // Authentication token for the user

    // Constructor to initialize User object with specific values
	public User(int userID, String username, String password, String token) {
		super(); // Calling the superclass constructor
		
		// Initializing fields with the provided values
		this.userID = userID;
		this.username = username;	
		this.password = password;
		this.token = token;
	}
	
    // Constructor to initialize User object from a ResultSet (typically from a database query)
	public User(ResultSet res) throws SQLException {
		this.userID = res.getInt(1); // Retrieving the userID from the ResultSet
		this.username = res.getString(2); // Retrieving the username from the ResultSet
		this.password = res.getString(3); // Retrieving the password from the ResultSet
		this.token = res.getString(4); // Retrieving the token from the ResultSet
	}
	
    // Getter and Setter methods for the userID field
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

    // Getter and Setter methods for the username field
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    // Getter and Setter methods for the password field
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    // Getter and Setter methods for the token field
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
