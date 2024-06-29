package it.univaq.disim.sose.service.DAO; // Defines the package for the SQLiteDAOFactory class

import java.sql.Connection; // Importing necessary classes for database connection and operations
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.univaq.disim.sose.utils.Utils; // Importing the Utils class for utility functions

// Concrete implementation of DAOFactory for SQLite
public class SQLiteDAOFactory extends DAOFactory {
	
	// Constants for the SQLite database driver and connection string
	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DATABASE = "jdbc:sqlite::resource:user.db";
	
	// Method to create a database connection
	public static Connection createConnection() {
		Connection conn = null;
		
		try {
			// Load the SQLite JDBC driver
			Class.forName(DRIVER);
			Utils.consoleLog(DATABASE); // Log the database connection string
			// Establish the connection to the database
			conn = DriverManager.getConnection(DATABASE);
			
			// System.out.println("Connected to database"); // Commented out connection message
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace(); // Print any exceptions
		} 
		return conn; // Return the connection object
	}
	
	// Method to close the database connection and related resources
	public static void closeDbConnection(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs !=null) {
				rs.close(); // Close the ResultSet if it is not null
			}
			if(stmt != null) {
				stmt.close(); // Close the Statement if it is not null
			}
			if(conn!= null) {
				conn.close(); // Close the Connection if it is not null
			}
		}
		catch(SQLException se) {
			se.printStackTrace(); // Print any exceptions
		}
	}
	
	// Method to create the database and its tables
	public static void DBCreation() {
		Connection conn = null;
		try {
			// Load the SQLite JDBC driver
			Class.forName(DRIVER);
			// Establish the connection to the database
			conn = DriverManager.getConnection(DATABASE);
			Utils.consoleLog("Connected to database ");
			// Create a statement object to execute SQL queries
			Statement statement = conn.createStatement();
			// Execute the SQL query to create the review table if it does not exist
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS review (review_id INTEGER PRIMARY KEY AUTOINCREMENT, food_id INTEGER, title TEXT, comment TEXT, user_id INTEGER)");
			Utils.consoleLog("Database created ");
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace(); // Print any exceptions
		}
	}

	// Implementation of the getUserDAO method to return an instance of SQLiteUserDAOImpl
	@Override
	public UserDAO getUserDAO() {
		return new SQLiteUserDAOImpl();
	}
}
