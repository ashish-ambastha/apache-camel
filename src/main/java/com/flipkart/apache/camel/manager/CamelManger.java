package com.flipkart.apache.camel.manager;

import com.flipkart.apache.camel.router.SampleRoute;
import com.google.inject.Inject;
import io.dropwizard.lifecycle.Managed;
import org.apache.camel.CamelContext;

public class CamelManger implements Managed {

    private CamelContext camelContext;

    @Inject
    public CamelManger(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public void start() throws Exception {
        camelContext.addRoutes(new SampleRoute(camelContext));
        camelContext.start();
        System.out.println("Camel context is started");
    }

    public void stop() throws Exception {
        camelContext.stop();
    }
}
