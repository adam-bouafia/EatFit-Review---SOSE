package it.univaq.disim.sose.apigatewayservice.config;

import brave.Span;
import brave.Tracer;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.sleuth.instrument.web.TraceWebServletAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

/**
 * @author: Adam Bouafia, Date : 07-01-2024
 */
/**
 * This class is responsible for adding the trace ID to the HTTP response headers.
 * It is a filter that intercepts the request and response and adds the trace ID
 * to the response headers if a current span exists in the tracer.
 * 
 * The trace ID is returned in a hex form for readability. Additionally, custom tags
 * can be added to the current span.
 */
@Component
@Order(TraceWebServletAutoConfiguration.TRACING_FILTER_ORDER + 1)
public class AddTraceIdToHttpResponseConfig extends GenericFilterBean {

  private final Tracer tracer;

  AddTraceIdToHttpResponseConfig(Tracer tracer) {
    this.tracer = tracer;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    Span currentSpan = this.tracer.currentSpan();
    if (currentSpan == null) {
      chain.doFilter(request, response);
      return;
    }
    // for readability we're returning trace id in a hex form
    ((HttpServletResponse) response).addHeader("ZIPKIN-TRACE-ID",
        currentSpan.context().traceIdString());
    // we can also add some custom tags
    currentSpan.tag("custom", "tag");
    chain.doFilter(request, response);
  }
}
