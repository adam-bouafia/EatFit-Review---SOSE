package it.univaq.disim.sose.service.DAO; // Defines the package for the DAOFactory class

// Abstract class for DAOFactory
public abstract class DAOFactory {
	
	// Constants representing different database types
	public static final int SQLITE = 1;
	public static final int MYSQL = 0;
	
	// Abstract method to get the UserDAO instance
	public abstract UserDAO getUserDAO();
	
	// Static method to get the appropriate DAOFactory based on the database type
	public static DAOFactory getDAOFactory(int database) {
		switch (database) {
			// If the database type is SQLITE, return an instance of SQLiteDAOFactory
			case SQLITE:
				return new SQLiteDAOFactory();
			// If the database type is MYSQL, return null (MySQL not implemented)
			case MYSQL:
				return null;
			// If the database type is not recognized, return null
			default:
				return null;
		}
	}
}
