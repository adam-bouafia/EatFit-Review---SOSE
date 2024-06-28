package it.univaq.disim.sose.search;

/**
 * This class represents a custom exception for search-related errors.
 * It extends the standard Java Exception class and provides additional constructors
 * for more detailed exception handling.
 */
public class SearchException extends Exception {

    // Serial version UID for serialization
    private static final long serialVersionUID = 7692673956797365627L;

    // No-argument constructor
    public SearchException() {
        super();
    }

    // Constructor that accepts a message
    public SearchException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public SearchException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public SearchException(Throwable cause) {
        super(cause);
    }
}