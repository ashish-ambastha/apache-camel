package com.flipkart.apache.camel.router;

import com.flipkart.apache.camel.external.ExternalClient;
import com.flipkart.apache.camel.processor.initiate.sandbox.ExternalRequestProcessor;
import com.flipkart.apache.camel.processor.initiate.sandbox.ParseResponseCodeProcessor;
import com.flipkart.apache.camel.processor.initiate.sandbox.ServerRequestAdapterProcessor;
import com.google.inject.Inject;
import org.apache.camel.builder.RouteBuilder;

public class InitiateRequestRoute extends RouteBuilder {

    @Inject
    private ExternalClient externalClient;

    public void configure() throws Exception {
        from("direct:initiate")
                .process(new ServerRequestAdapterProcessor())
                .process(new ExternalRequestProcessor(externalClient))
                .process(new ParseResponseCodeProcessor())
                .end();
    }
}
