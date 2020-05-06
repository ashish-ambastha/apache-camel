package com.flipkart.apache.camel.router;

import com.flipkart.apache.camel.external.ExternalClient;
import com.flipkart.apache.camel.processor.initiate.sandbox.IdempotentRequestProcessor;
import com.flipkart.apache.camel.processor.initiate.sandbox.ParseResponseProcessor;
import com.flipkart.apache.camel.processor.initiate.sandbox.ServerRequestAdapterProcessor;
import com.google.inject.Inject;
import org.apache.camel.builder.RouteBuilder;

public class InitiateRequestRoute extends RouteBuilder {

    @Inject
    private ExternalClient externalClient;

    public void configure() throws Exception {
        from("direct:initiate")
                .process(new ServerRequestAdapterProcessor())
                .process(new IdempotentRequestProcessor(externalClient))
                .process(new ParseResponseProcessor())
                .end();
    }
}
