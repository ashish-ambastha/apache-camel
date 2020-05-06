package com.flipkart.apache.camel.router;

import com.flipkart.apache.camel.model.api.SandboxServerRequest;
import com.flipkart.apache.camel.model.api.SandboxServerResponse;
import com.flipkart.apache.camel.processor.ClientRequestProcessor;
import com.flipkart.apache.camel.processor.initiate.sandbox.ParseResponseProcessor;
import com.flipkart.apache.camel.processor.initiate.sandbox.ServerRequestAdapterProcessor;
import com.google.inject.Inject;
import org.apache.camel.builder.RouteBuilder;

public class InitiateRoute extends RouteBuilder {

    private ClientRequestProcessor<SandboxServerRequest, SandboxServerResponse> clientRequestProcessor;
    private String routeName;

    @Inject
    public InitiateRoute(ClientRequestProcessor<SandboxServerRequest, SandboxServerResponse> clientRequestProcessor,
                         String routeName) {
        this.clientRequestProcessor = clientRequestProcessor;
        this.routeName = routeName;
    }

    public void configure() throws Exception {
        from(routeName)
                .process(new ServerRequestAdapterProcessor())
                .process(clientRequestProcessor)
                .process(new ParseResponseProcessor())
                .end();
    }
}
