package it.univaq.disim.sose.apigatewayservice.exception;

/**
 * @author: Adam Bouafia, Date : 07-01-2024
 */
/**
 * This class represents a custom runtime exception with an associated HTTP status code.
 */
public class RunTimeExceptionPlaceHolder extends RuntimeException {

  int httpStatus;

  /**
   * Constructs a new RunTimeExceptionPlaceHolder with the specified error message and HTTP status code.
   *
   * @param message    the error message
   * @param httpStatus the HTTP status code
   */
  public RunTimeExceptionPlaceHolder(String message, int httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }

  /**
   * Returns the HTTP status code associated with this exception.
   *
   * @return the HTTP status code
   */
  public int getHttpStatus() {
    return httpStatus;
  }

}
