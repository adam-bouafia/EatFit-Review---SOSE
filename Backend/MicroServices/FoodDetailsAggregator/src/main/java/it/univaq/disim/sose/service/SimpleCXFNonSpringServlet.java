package it.univaq.disim.sose.service;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

/**
 * This class extends the CXFNonSpringServlet to configure and publish a web service endpoint.
 */
public class SimpleCXFNonSpringServlet extends CXFNonSpringServlet {

    private static final long serialVersionUID = -4978737275160241311L;

    /**
     * This method is called when the servlet is initialized. It sets up the CXF bus and publishes the web service endpoint.
     *
     * @param servletConfig the servlet configuration object
     */
    @Override
    public void loadBus(ServletConfig servletConfig) {
        // Call the superclass method to perform the default bus loading
        super.loadBus(servletConfig);

        // Retrieve the CXF bus associated with this servlet
        Bus bus = getBus();
        
        // Set the retrieved bus as the default bus for the CXF environment
        BusFactory.setDefaultBus(bus);
        
        // Publish the web service endpoint at the specified URL
        Endpoint.publish("/fooddetailsaggregator", new FoodDetailsAggregatorImpl());
    }
}
