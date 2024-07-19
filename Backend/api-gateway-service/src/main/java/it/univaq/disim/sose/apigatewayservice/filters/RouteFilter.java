package it.univaq.disim.sose.apigatewayservice.filters;

import com.netflix.zuul.ZuulFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author: Adam Bouafia, Date : 07-01-2024
 */
/**
 * This class represents a route filter for the MangaStore API Gateway Service.
 * It extends the ZuulFilter class and is responsible for filtering requests during the routing phase.
 */
@Slf4j
public class RouteFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return FilterConstants.ROUTE_TYPE;
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    System.out.println("Inside Route Filter");
    return null;
  }
}
