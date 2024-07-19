package it.univaq.disim.sose.apigatewayservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an error in the MangaStore API Gateway Service.
 * An Error object contains a code and a message describing the error.
 * 
 * @author Adam Bouafia
 * @date 07-01-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error {

  /**
   * The error code.
   */
  private String code;
  
  /**
   * The error message.
   */
  private String message;
}
