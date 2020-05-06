package com.flipkart.apache.camel.manager;

import com.flipkart.apache.camel.router.InitiateRequestRoute;
import com.flipkart.apache.camel.router.InitiateRoute;
import com.flipkart.apache.camel.router.MultiProcessorRoute;
import com.flipkart.apache.camel.router.SampleRoute;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.dropwizard.lifecycle.Managed;
import org.apache.camel.CamelContext;

public class CamelManger implements Managed {

    private CamelContext camelContext;
    private InitiateRequestRoute initiateRequestRoute;
    private InitiateRoute idempotentRoute;
    private InitiateRoute nonIdempotentRoute;

    @Inject
    public CamelManger(CamelContext camelContext, InitiateRequestRoute initiateRequestRoute,
                       @Named("idempotentRoute") InitiateRoute idempotentRoute,
                       @Named("nonIdempotentRoute") InitiateRoute nonIdempotentRoute) {
        this.camelContext = camelContext;
        this.initiateRequestRoute = initiateRequestRoute;
        this.idempotentRoute = idempotentRoute;
        this.nonIdempotentRoute = nonIdempotentRoute;
    }

    public void start() throws Exception {
        camelContext.addRoutes(new SampleRoute(camelContext));
        camelContext.addRoutes(new MultiProcessorRoute(camelContext));
        camelContext.addRoutes(initiateRequestRoute);
        camelContext.addRoutes(idempotentRoute);
        camelContext.addRoutes(nonIdempotentRoute);
        camelContext.start();
        System.out.println("Camel context is started");
    }

    public void stop() throws Exception {
        camelContext.stop();
    }
}
