package it.univaq.disim.sose.apigatewayservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author: Adam Bouafia, Date : 07-01-2024
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;

@Slf4j
public class PreFilter extends ZuulFilter {

    /**
     * Returns the filter type.
     * 
     * @return The filter type.
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * Returns the filter order.
     * 
     * @return The filter order.
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * Determines whether the filter should be executed.
     * 
     * @return true if the filter should be executed, false otherwise.
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * Executes the filter logic.
     * 
     * @return The result of the filter execution.
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("PreFilter: " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
