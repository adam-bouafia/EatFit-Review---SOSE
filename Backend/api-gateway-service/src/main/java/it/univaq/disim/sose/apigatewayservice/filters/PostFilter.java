package it.univaq.disim.sose.apigatewayservice.filters;

import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author: Adam Bouafia, Date : 07-01-2024
 */
/**
 * This class represents a PostFilter, which is a type of ZuulFilter used in the MangaStore API Gateway service.
 * It is responsible for filtering requests after they have been routed to the target service and before the response is sent back to the client.
 */
public class PostFilter extends ZuulFilter {

  /**
   * Returns the filter type of this PostFilter.
   * @return The filter type, which is FilterConstants.POST_TYPE.
   */
  @Override
  public String filterType() {
    return FilterConstants.POST_TYPE;
  }

  /**
   * Returns the filter order of this PostFilter.
   * @return The filter order, which is 1.
   */
  @Override
  public int filterOrder() {
    return 1;
  }

  /**
   * Determines whether this PostFilter should be applied or not.
   * @return true, indicating that the filter should always be applied.
   */
  @Override
  public boolean shouldFilter() {
    return true;
  }

  /**
   * Executes the logic of this PostFilter.
   * This method is called when a request has been processed by the target service and a response is about to be sent back to the client.
   * It prints a message to the console indicating that the filter is inside the response filter.
   * @return null, as no modifications are made to the response.
   */
  @Override
  public Object run() {
    System.out.println("Inside Response Filter");
    return null;
  }
}
