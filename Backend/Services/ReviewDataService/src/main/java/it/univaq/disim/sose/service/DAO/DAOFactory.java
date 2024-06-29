package it.univaq.disim.sose.service.DAO;

// Abstract factory class for creating DAO objects
public abstract class DAOFactory {
    
    // Constants representing different database types
    public static final int SQLITE = 1;
    public static final int MYSQL = 0;
    
    // Abstract method to get a ReviewDAO implementation
    public abstract ReviewDAO getReviewDAO();
    
    // Factory method to get the appropriate DAOFactory implementation based on the database type
    public static DAOFactory getDAOFactory(int database) {
        switch (database) {
            case SQLITE:
                // Return SQLiteDAOFactory instance
                return new SQLiteDAOFactory();
            case MYSQL:
                // Return null for MYSQL as it is not implemented
                return null;
            default:
                // Return null for unsupported database types
                return null;
        }
    }
}
